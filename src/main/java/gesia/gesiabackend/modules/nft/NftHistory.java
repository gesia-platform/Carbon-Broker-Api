package gesia.gesiabackend.modules.nft;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gesia.gesiabackend.modules.account.Account;
import gesia.gesiabackend.modules.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NftHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nft_history_sq")
    private Long id;

    @Column(name = "nft_transaction_ton")
    private String ton;

    @Column(name = "ntf_transaction_price")
    private int price;

    @Column(name = "nft_transaction_quantity")
    private int quantity;

    @Column(name = "nft_image_url")
    private String imageUrl;

    @Column(name = "nft_sender_addr")
    private String senderWalletAddress;

    @Column(name = "nft_recipient_addr")
    private String recipientWalletAddress;

    @Column(name = "nft_transaction_status")
    private TransactionStatus transactionStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nft_sq")
    private Nft nft;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_sq")
    private Account account;

    @Builder
    public NftHistory(String ton, int price, int quantity, String imageUrl, String senderWalletAddress, String recipientWalletAddress, TransactionStatus transactionStatus, Nft nft, Account account) {
        this.ton = ton;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.senderWalletAddress = senderWalletAddress;
        this.recipientWalletAddress = recipientWalletAddress;
        this.transactionStatus = transactionStatus;
        this.nft = nft;
        this.account = account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
