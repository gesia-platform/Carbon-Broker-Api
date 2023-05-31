package gesia.gesiabackend.modules.account.dto;

import gesia.gesiabackend.modules.account.AccountInfo;
import gesia.gesiabackend.modules.account.AccountType;
import gesia.gesiabackend.modules.account.ApprovalStatus;
import gesia.gesiabackend.modules.account.Bank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SearchAccountResponse {

    private String username;

    private AccountType accountType;

    private Bank bank;

    private AccountInfo accountInfo;

    private ApprovalStatus approvalStatus;

    @Builder
    public SearchAccountResponse(String username, AccountType accountType, Bank bank, AccountInfo accountInfo, ApprovalStatus approvalStatus) {
        this.username = username;
        this.accountType = accountType;
        this.bank = bank;
        this.accountInfo = accountInfo;
        this.approvalStatus = approvalStatus;
    }
}
