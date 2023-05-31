package gesia.gesiabackend.modules.account.validator;

import gesia.gesiabackend.modules.account.AccountRepository;
import gesia.gesiabackend.modules.account.dto.AccountSignUpRequest;
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
public class AccountSignUpValidator implements Validator {

    private final AccountRepository accountRepository;

    private final Pattern emailValidPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AccountSignUpRequest.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        AccountSignUpRequest accountSignUpRequest = (AccountSignUpRequest) object;

        if (!emailValidPattern.matcher(accountSignUpRequest.getUsername()).matches()) {
            throw new BadRequestException(ACCOUNT_INVALID_EMAIL_FORMAT);
        }

        if (accountRepository.existsByUsername(accountSignUpRequest.getUsername())) {
            throw new BadRequestException(ACCOUNT_USED_EMAIL);
        }
    }
}
