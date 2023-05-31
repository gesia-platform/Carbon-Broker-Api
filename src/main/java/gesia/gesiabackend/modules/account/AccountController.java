package gesia.gesiabackend.modules.account;

import gesia.gesiabackend.infra.config.security.jwt.JwtTokenProvider;
import gesia.gesiabackend.modules.account.dto.*;
import gesia.gesiabackend.modules.account.validator.AccountEmailVerificationValidator;
import gesia.gesiabackend.modules.account.validator.AccountSignUpValidator;
import gesia.gesiabackend.modules.common.CommonService;
import gesia.gesiabackend.modules.common.dto.ResultResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import static gesia.gesiabackend.modules.common.Const.SUCCESS;
import static gesia.gesiabackend.modules.common.Const.SUCCESS_MSG;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountEmailVerificationValidator accountEmailVerificationValidator;
    private final AccountSignUpValidator accountSignUpValidator;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CommonService commonService;

    @InitBinder("accountSignUpRequest")
    public void signUpRequestInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(accountSignUpValidator);
    }

    @InitBinder("accountEmailVerificationRequest")
    public void emailVerificationRequestInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(accountEmailVerificationValidator);
    }

    @PostMapping("/accounts/sign-in")
    public ResultResponse signIn(@RequestBody @Valid AccountSignInRequest accountSignInRequest) {
        commonService.checkWithdrawalAccount(accountSignInRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        accountSignInRequest.getUsername(),
                        accountSignInRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtTokenProvider.createToken(authentication);
        AccountSignInResponse accountSignInResponse = AccountSignInResponse.builder()
                .username(accountSignInRequest.getUsername())
                .jwtToken(jwtToken)
                .build();
        return ResultResponse.result(SUCCESS, SUCCESS_MSG, accountSignInResponse);
    }

    @PostMapping("/accounts/sign-up")
    public ResultResponse signUp(@RequestBody @Valid AccountSignUpRequest accountSignUpRequest) {
        accountService.createAccount(accountSignUpRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @PostMapping("/accounts/verify/mail")
    public ResultResponse sendSignUpVerification(@RequestBody @Valid AccountEmailVerificationRequest accountEmailVerificationRequest) {
        accountService.sendVerificationCode(accountEmailVerificationRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @GetMapping("/accounts/verify")
    public ResultResponse verifyCode(@RequestParam String code) {
        accountService.verifyCode(code);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @GetMapping("/accounts/username")
    public ResultResponse findAccountUsername(@Valid SearchAccountUsernameRequest searchAccountUsernameRequest) {
        AccountResponse accountResponse = accountService.getAccount(searchAccountUsernameRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG, accountResponse);
    }

    @GetMapping("/accounts/password")
    public ResultResponse findAccountPassword(@Valid SearchAccountPasswordRequest searchAccountPasswordRequest) {
        accountService.sendNewAccountPassword(searchAccountPasswordRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @GetMapping("/accounts/{username}")
    public ResultResponse searchAccount(@PathVariable String username) {
        SearchAccountResponse searchAccountResponse = accountService.getAccount(username);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG, searchAccountResponse);
    }

    @PutMapping("/accounts/{username}")
    public ResultResponse modifyAccount(@PathVariable String username,
                                        @RequestBody @Valid ChangeAccountRequest changeAccountRequest) {
        accountService.updateAccount(username, changeAccountRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @PatchMapping("/accounts/{username}/password")
    public ResultResponse modifyAccountPassword(@PathVariable String username,
                                                @RequestBody @Valid ChangeAccountPasswordRequest changeAccountPasswordRequest) {
        accountService.updateAccountPassword(username, changeAccountPasswordRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @PatchMapping("/accounts/{username}/withdrawal")
    public ResultResponse withdrawalAccount(@PathVariable String username,
                                            @RequestBody @Valid AccountWithdrawalRequest accountWithdrawalRequest) {
        accountService.disableAccount(username, accountWithdrawalRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }
}
