package gesia.gesiabackend.modules.account.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import static gesia.gesiabackend.modules.common.Const.ACCOUNT_DTO_NO_RECEIVER;

@Getter
public class AccountEmailVerificationRequest {

    @NotBlank(message = ACCOUNT_DTO_NO_RECEIVER)
    private String receiver;
}
