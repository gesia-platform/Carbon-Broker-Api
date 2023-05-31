package gesia.gesiabackend.modules.nft;

import gesia.gesiabackend.modules.common.dto.ResultResponse;
import gesia.gesiabackend.modules.nfv.dto.NftResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/nft")
@RequiredArgsConstructor
public class NftController {

    private final NftService nftService;

    @GetMapping("/broker/market")
    public ResultResponse NftMarketList () {
        NftResponse nftResponse = nftService.NftMarket();
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @GetMapping("/broker/market/{id}")
    public ResultResponse NftMarketDetail (@PathVariable Long id) {
        NftResponse nftResponse = nftService.NftMarketDetail(id);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @PostMapping("/broker/market/buy/{username}/{id}")
    public ResultResponse BrokerBuyNft (@PathVariable String username, @PathVariable Long id) {
        nftService.BrokerBuyNft(id, username);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @GetMapping("/broker/market/history/{id}")
    public ResultResponse NftMarketHistory (@PathVariable Long id) {
        NftResponse nftResponse = nftService.NftMarketHistory(id);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @GetMapping("/broker/market/detail/{username}/{historyId}")
    public ResultResponse BrokerNftDetail (@PathVariable String username, @PathVariable Long historyId) {
        NftResponse nftResponse = nftService.BrokerNftDetail(username, historyId);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @PostMapping("/broker/market/sale/{id}")
    public ResultResponse BrokerSaleNft (@PathVariable Long id) {
        nftService.BrokerSaleNft(id);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @GetMapping("/broker/market/sale/detail/{username}")
    public ResultResponse BrokerNftSaleDetail (@PathVariable String username) {
        NftResponse nftResponse = nftService.BrokerNftSaleDetail(username);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @GetMapping("/brokerapp/market")
    public ResultResponse BrokerAppNftMarket () {
        NftResponse nftResponse = nftService.BrokerAppNftMarket();
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @GetMapping("/brokerapp/market/{id}")
    public ResultResponse BrokerAppNftMarketDetail (@PathVariable Long id) {
        NftResponse nftResponse = nftService.BrokerAppNftMarketDetail(id);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @PostMapping("/brokerapp/market/buy/{username}/{id}")
    public ResultResponse BrokerAppBuyNft (@PathVariable String username, @PathVariable Long id) {
        nftService.BrokerAppBuyNft(id, username);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @GetMapping("/brokerapp/market/history/{id}")
    public ResultResponse BrokerAppNftMarketHistory (@PathVariable Long id) {
        NftResponse nftResponse = nftService.BrokerAppNftMarketHistory(id);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @GetMapping("/brokerapp/market/detail/{username}/{historyId}")
    public ResultResponse BrokerAppNftDetail (@PathVariable String username, @PathVariable Long historyId) {
        NftResponse nftResponse = nftService.BrokerAppNftDetail(username, historyId);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }
}