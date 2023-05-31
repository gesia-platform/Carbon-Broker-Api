package gesia.gesiabackend.modules.account.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import static gesia.gesiabackend.modules.common.Const.*;

@Getter
public class ChangeAccountPasswordRequest {

    @NotBlank(message = ACCOUNT_DTO_NO_PASSWORD)
    @Length(min = 8, max = 20, message = ACCOUNT_DTO_WRONG_PASSWORD_RULE)
    private String currentPassword;

    @NotBlank(message = ACCOUNT_DTO_NO_NEW_PASSWORD)
    @Length(min = 8, max = 20, message = ACCOUNT_DTO_WRONG_PASSWORD_RULE)
    private String newPassword;
}
