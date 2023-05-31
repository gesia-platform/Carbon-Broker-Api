package gesia.gesiabackend.modules.account.validator;

import gesia.gesiabackend.modules.account.AccountRepository;
import gesia.gesiabackend.modules.account.dto.AccountEmailVerificationRequest;
import gesia.gesiabackend.modules.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import static gesia.gesiabackend.modules.common.Const.ACCOUNT_INVALID_EMAIL_FORMAT;
import static gesia.gesiabackend.modules.common.Const.ACCOUNT_USED_EMAIL;

@Component
@RequiredArgsConstructor
public class AccountEmailVerificationValidator implements Validator {

    private final AccountRepository accountRepository;

    private final Pattern emailValidPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AccountEmailVerificationRequest.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        AccountEmailVerificationRequest accountEmailVerificationRequest = (AccountEmailVerificationRequest) object;

        if (!emailValidPattern.matcher(accountEmailVerificationRequest.getReceiver()).matches()) {
            throw new BadRequestException(ACCOUNT_INVALID_EMAIL_FORMAT);
        }

        if (accountRepository.existsByUsername(accountEmailVerificationRequest.getReceiver())) {
            throw new BadRequestException(ACCOUNT_USED_EMAIL);
        }
    }
}
