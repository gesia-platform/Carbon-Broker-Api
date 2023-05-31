package gesia.gesiabackend.modules.nfv.dto;

import gesia.gesiabackend.modules.nft.TransactionType;
import gesia.gesiabackend.modules.nfv.Nfv;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class NftRequest {

    @NotBlank
    private Long accountId;

    @NotBlank
    private Long certificationId;

    @NotBlank
    private TransactionType transactionType;

    @NotBlank
    private String name;

    @NotBlank
    private String ton;

    @NotBlank
    private int quantity;

    @NotBlank
    private int price;

    @NotBlank
    private String address;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String introduction;

    @NotBlank
    private Nfv nfv;
}