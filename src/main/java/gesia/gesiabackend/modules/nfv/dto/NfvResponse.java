package gesia.gesiabackend.modules.nfv.dto;

import gesia.gesiabackend.modules.nfv.Nfv;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class NfvResponse {

    @NotBlank
    private final List<Nfv> nfvList;

    private final String categoryName;

    @Builder
    public NfvResponse(List<Nfv> nfvList, String categoryName) {
        this.nfvList = nfvList;
        this.categoryName = categoryName;
    }
}
