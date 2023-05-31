package gesia.gesiabackend.modules.nfv;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gesia.gesiabackend.modules.common.BaseTimeEntity;
import gesia.gesiabackend.modules.nft.Nft;
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
public class Nfv extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nfv_sq")
    private Long id;

    @Column(name = "nfv_name")
    private String name;

    @Column(name = "nfv_introduction")
    private String introduction;

    @Column(name = "nfv_ton")
    private String ton;

    @Column(name = "nfv_image_url")
    private String imageUrl;

    @Column(name = "nfv_price")
    private int price;

    @Column(name = "nfv_quantity")
    private int quantity;

    @Column (name = "account_sq")
    private Long accountId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "certification_sq")
    private Certification certification;

    @JsonIgnore
    @OneToMany(mappedBy = "nfv", cascade = CascadeType.ALL)
    private List<Nft> nfts = new ArrayList<>();

    @Builder
    public Nfv(String name, String introduction, String ton, String imageUrl, Long accountId, Certification certification) {
        this.name = name;
        this.introduction = introduction;
        this.ton = ton;
        this.imageUrl = imageUrl;
        this.accountId = accountId;
        this.certification = certification;
    }
}
