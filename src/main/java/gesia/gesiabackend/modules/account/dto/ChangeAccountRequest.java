package gesia.gesiabackend.modules.account.dto;

import gesia.gesiabackend.modules.account.AccountInfo;
import gesia.gesiabackend.modules.account.Bank;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class ChangeAccountRequest {

    @Embedded
    @Valid
    private Bank bank;

    @Embedded
    @Valid
    private AccountInfo accountInfo;
}
