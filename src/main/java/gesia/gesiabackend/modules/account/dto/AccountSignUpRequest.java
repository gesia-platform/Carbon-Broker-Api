package gesia.gesiabackend.modules.account.dto;

import gesia.gesiabackend.modules.account.AccountInfo;
import gesia.gesiabackend.modules.account.AccountType;
import gesia.gesiabackend.modules.account.ApprovalStatus;
import gesia.gesiabackend.modules.account.Bank;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import static gesia.gesiabackend.modules.common.Const.*;

@Getter
public class AccountSignUpRequest {

    @NotBlank(message = ACCOUNT_DTO_NO_USERNAME)
    private String username;

    @NotBlank
    @Length(min = 8, max = 20, message = ACCOUNT_DTO_WRONG_PASSWORD_RULE)
    private String password;

    @NotNull(message = ACCOUNT_DTO_NO_ACCOUNT_TYPE)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Embedded
    @Valid
    private Bank bank;

    @Embedded
    @Valid
    private AccountInfo accountInfo;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    AccountSignUpRequest() {
        this.approvalStatus = ApprovalStatus.REQUEST;
    }
}
