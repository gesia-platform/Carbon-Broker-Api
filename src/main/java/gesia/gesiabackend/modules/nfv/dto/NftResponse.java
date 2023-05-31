package gesia.gesiabackend.modules.nfv.dto;

import gesia.gesiabackend.modules.nft.Nft;
import gesia.gesiabackend.modules.nft.NftHistory;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class NftResponse {

    @NotNull
    private final List<Nft> nftList;

    @NotNull
    private final List<NftHistory> nftHistoryList;

    @Builder
    public NftResponse(List<Nft> nftList, List<NftHistory> nftHistoryList) {
        this.nftList = nftList;
        this.nftHistoryList = nftHistoryList;
    }
}