package gesia.gesiabackend.modules.account.dto;

import gesia.gesiabackend.modules.account.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import static gesia.gesiabackend.modules.common.Const.*;

@Getter
public class AccountSignInRequest {

    @Email
    @NotBlank(message = ACCOUNT_DTO_NO_USERNAME)
    private String username;

    @NotBlank(message = ACCOUNT_DTO_NO_PASSWORD)
    @Length(min = 8, max = 20, message = ACCOUNT_DTO_WRONG_PASSWORD_RULE)
    private String password;

    @NotNull(message = ACCOUNT_DTO_NO_ACCOUNT_TYPE)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
