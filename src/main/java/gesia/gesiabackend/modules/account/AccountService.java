package gesia.gesiabackend.modules.account;

import gesia.gesiabackend.infra.config.RedisUtil;
import gesia.gesiabackend.infra.config.security.auth.AuthUils;
import gesia.gesiabackend.infra.mail.EmailMessage;
import gesia.gesiabackend.infra.mail.EmailService;
import gesia.gesiabackend.infra.mail.EmailTemplate;
import gesia.gesiabackend.modules.account.dto.*;
import gesia.gesiabackend.modules.common.CommonService;
import gesia.gesiabackend.modules.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static gesia.gesiabackend.infra.mail.EmailConst.*;
import static gesia.gesiabackend.modules.common.Const.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;
    private final EmailService emailService;
    private final EmailTemplate emailTemplate;
    private final CommonService commonService;

    @Transactional
    public void createAccount(AccountSignUpRequest accountSignUpRequest) {
        if (accountRepository.existsByAccountTypeAndAccountInfoBusinessNumber(accountSignUpRequest.getAccountType(), accountSignUpRequest.getAccountInfo().getBusinessNumber())) {
            throw new BadRequestException(ACCOUNT_USED_ACCOUNT_BY_BUSINESS_NUMBER);
        }

        Account account = Account.builder()
                .username(accountSignUpRequest.getUsername())
                .password(accountSignUpRequest.getPassword())
                .accountType(accountSignUpRequest.getAccountType())
                .bank(accountSignUpRequest.getBank())
                .accountInfo(accountSignUpRequest.getAccountInfo())
                .approvalStatus(accountSignUpRequest.getApprovalStatus())
                .build();
        account.setEncodePassword(passwordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    public void sendVerificationCode(AccountEmailVerificationRequest accountEmailVerificationRequest) {
        String authKey = createAuthKey();
        EmailMessage emailMessage = EmailMessage.builder()
                .to(accountEmailVerificationRequest.getReceiver())
                .subject(EMAIL_SEND_AUTH_CODE_MESSAGE)
                .message(emailTemplate.verifyAuthCodeMailTemplate(authKey))
                .build();
        emailService.send(emailMessage);
        redisUtil.setDataExpire(authKey, accountEmailVerificationRequest.getReceiver(), EMAIL_VERIFICATION_EXPIRATION_TIME);
    }

    private String createAuthKey() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid.substring(0, 8);
    }

    public void verifyCode(String code) {
        String email = getEmailByVerificationCode(code);
        if (email == null) {
            throw new BadRequestException(ACCOUNT_EXPIRED_CODE_OR_INCORRECT_CODE);
        }
    }

    private String getEmailByVerificationCode(String code) {
        return redisUtil.getData(code);
    }

    public AccountResponse getAccount(SearchAccountUsernameRequest searchAccountUsernameRequest) {
        Account account = accountRepository.findByAccountTypeAndAccountInfoBusinessNumber(searchAccountUsernameRequest.getAccountType(), searchAccountUsernameRequest.getBusinessNumber())
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        return AccountResponse.builder()
                .email(account.getUsername())
                .build();
    }

    @Transactional
    public void sendNewAccountPassword(SearchAccountPasswordRequest searchAccountPasswordRequest) {
        Account account = accountRepository.findByAccountTypeAndUsernameAndAccountInfoBusinessNumber(
                        searchAccountPasswordRequest.getAccountType(),
                        searchAccountPasswordRequest.getUsername(),
                        searchAccountPasswordRequest.getBusinessNumber()
                )
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        String authKey = createAuthKey();
        EmailMessage emailMessage = EmailMessage.builder()
                .to(searchAccountPasswordRequest.getUsername())
                .subject(EMAIL_SEND_TEMPORARY_PASSWORD)
                .message(emailTemplate.reissuePasswordMailTemplate(authKey))
                .build();
        account.updatePassword(passwordEncoder.encode(authKey));
        emailService.send(emailMessage);
    }

    @Transactional
    public SearchAccountResponse getAccount(String username) {
        commonService.checkWithdrawalAccount(username);
        AuthUils.checkJwtToken(username);

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        SearchAccountResponse searchAccountResponse = SearchAccountResponse.builder()
                .username(account.getUsername())
                .accountType(account.getAccountType())
                .bank(account.getBank())
                .accountInfo(account.getAccountInfo())
                .approvalStatus(account.getApprovalStatus())
                .build();
        return searchAccountResponse;
    }

    @Transactional
    public void updateAccount(String username, ChangeAccountRequest changeAccountRequest) {
        commonService.checkWithdrawalAccount(username);
        AuthUils.checkJwtToken(username);

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        account.updateAccount(changeAccountRequest);
    }

    @Transactional
    public void updateAccountPassword(String username, ChangeAccountPasswordRequest changeAccountPasswordRequest) {
        commonService.checkWithdrawalAccount(username);
        AuthUils.checkJwtToken(username);

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        if (isPasswordMatches(changeAccountPasswordRequest.getCurrentPassword(), account.getPassword())) {
            account.updatePassword(passwordEncoder.encode(changeAccountPasswordRequest.getNewPassword()));
        } else {
            throw new BadRequestException(ACCOUNT_INCORRECT_PASSWORD);
        }
    }

    @Transactional
    public void disableAccount(String username, AccountWithdrawalRequest accountWithdrawalRequest) {
        commonService.checkWithdrawalAccount(username);
        AuthUils.checkJwtToken(username);

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        if (isPasswordMatches(accountWithdrawalRequest.getPassword(), account.getPassword())) {
            account.updateDisableAt();
        } else {
            throw new BadRequestException(ACCOUNT_INCORRECT_PASSWORD);
        }
    }

    private boolean isPasswordMatches(String inputPassword, String currentPassword) {
        return passwordEncoder.matches(inputPassword, currentPassword);
    }
}
