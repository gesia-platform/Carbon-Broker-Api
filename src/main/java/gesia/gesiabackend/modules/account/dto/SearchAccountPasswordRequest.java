package gesia.gesiabackend.modules.account.dto;

import gesia.gesiabackend.modules.account.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import static gesia.gesiabackend.modules.common.Const.*;

@Getter
@Setter
public class SearchAccountPasswordRequest {

    @NotNull(message = ACCOUNT_DTO_NO_ACCOUNT_TYPE)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotBlank(message = ACCOUNT_DTO_NO_USERNAME)
    private String username;

    @NotBlank(message = ACCOUNT_DTO_NO_BUSINESS_NUMBER)
    private String businessNumber;
}
