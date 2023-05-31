package gesia.gesiabackend.modules.account;

import gesia.gesiabackend.modules.account.dto.ChangeAccountRequest;
import gesia.gesiabackend.modules.common.BaseTimeEntity;
import gesia.gesiabackend.modules.nft.NftHistory;
import gesia.gesiabackend.modules.nfv.Certification;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_sq")
    private Long id;

    @Column(name = "account_username")
    private String username;

    @Column(name = "account_password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Embedded
    @Column(name = "account_bank")
    private Bank bank;

    @Embedded
    @Column(name = "account_info")
    private AccountInfo accountInfo;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_approval_status")
    private ApprovalStatus approvalStatus;

    @Column(name = "delete_at")
    private LocalDateTime disableAt;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountManager> accountManager = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Certification> certifications = new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<NftHistory> nftHistories = new ArrayList<>();

    @Builder
    public Account(String username, String password, LocalDateTime disableAt, AccountType accountType, AccountInfo accountInfo, Bank bank, ApprovalStatus approvalStatus, List<AccountManager> accountManager, List<Certification> certifications) {
        this.username = username;
        this.password = password;
        this.disableAt = disableAt;
        this.accountType = accountType;
        this.accountInfo = accountInfo;
        this.bank = bank;
        this.approvalStatus = approvalStatus;
        this.accountManager = accountManager;
        this.certifications = certifications;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateDisableAt() {
        this.disableAt = LocalDateTime.now();
    }

    public boolean isWithdrawalAccount() {
        return this.disableAt != null;
    }

    public void setEncodePassword(String hashPassword) {
        this.password = hashPassword;
    }

    public void updateAccount(ChangeAccountRequest changeAccountRequest) {
        this.bank = changeAccountRequest.getBank();
        this.accountInfo = changeAccountRequest.getAccountInfo();
    }
}
