package gesia.gesiabackend.modules.nft;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gesia.gesiabackend.modules.common.BaseTimeEntity;
import gesia.gesiabackend.modules.nfv.Nfv;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Nft extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nft_sq")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private NftMarketType nftMarketType;

    @Enumerated(EnumType.ORDINAL)
    @Column
    private TransactionType transactionType;

    @Column(name = "nft_name")
    private String name;

    @Column(name = "nft_ton")
    private String ton;

    @Column(name = "ntf_price")
    private int price;

    @Column(name = "nft_quantity")
    private int quantity;

    @Column(name = "nft_addr")
    private String address;

    @Column(name = "nft_image_url")
    private String imageUrl;

    @Column(name = "nft_introduction")
    private String introduction;

    @Column (name = "account_sq")
    private Long accountId;

    @Column (name = "cert_sq")
    private Long certificationId;

    @JsonIgnore
    @OneToMany(mappedBy = "nft", cascade = CascadeType.ALL)
    private List<NftHistory> nftHistories = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nfv_sq")
    private Nfv nfv;

    @Builder
    public Nft(NftMarketType nftMarketType, TransactionType transactionType, String name, String ton, int price, int quantity, String address, String imageUrl, String introduction, Long accountId, Long certificationId, Nfv nfv) {
        this.nftMarketType = nftMarketType;
        this.transactionType = transactionType;
        this.accountId = accountId;
        this.certificationId = certificationId;
        this.name = name;
        this.ton = ton;
        this.price = price;
        this.quantity = quantity;
        this.address = address;
        this.imageUrl = imageUrl;
        this.introduction = introduction;
        this.nfv = nfv;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public void setNftMarketType(NftMarketType nftMarketType) {
        this.nftMarketType = nftMarketType;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}