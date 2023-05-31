package gesia.gesiabackend.modules.nfv.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class NfvRequest {

    @NotBlank
    private Long accountId;

    @NotBlank
    private Long certificationSq;

    @NotBlank
    private String name;

    @NotBlank
    private String ton;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String introduction;
}