package gesia.gesiabackend.modules.nfv;

import gesia.gesiabackend.modules.common.dto.ResultResponse;
import gesia.gesiabackend.modules.nfv.dto.CertificationRequest;
import gesia.gesiabackend.modules.nfv.dto.CertificationResponse;
import gesia.gesiabackend.modules.nfv.dto.NftResponse;
import gesia.gesiabackend.modules.nfv.dto.NfvResponse;
import gesia.gesiabackend.modules.nfv.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cert")
@RequiredArgsConstructor
public class CertificationController {
    private final CertificationService certificationService;

    @PostMapping("/certs/{username}")
    public ResultResponse createCert(@RequestBody CertificationRequest certificationRequest, @PathVariable String username) {
        certificationService.createCert(certificationRequest, username);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @PatchMapping("/certs/{username}/{id}")
    public ResultResponse updateCert(@RequestBody CertificationRequest certificationRequest,
                                     @PathVariable Long id,
                                     @PathVariable String username) {
        certificationService.updateCert(certificationRequest, id, username);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @GetMapping("/certs/{username}")
    public ResultResponse readCert (@PathVariable String username) {
        List<CertificationResponse> certificationResponse = certificationService.readCert(username);
        return ResultResponse.result(0, "SUCCESS_MSG", certificationResponse);
    }

    @GetMapping("/certs/nfv/{id}")
    public ResultResponse readNfv (@PathVariable Long id) {
        NfvResponse nfvResponse = certificationService.findNfvListByCertificationId(id);
        return ResultResponse.result(0, "SUCCESS_MSG", nfvResponse);
    }

    @GetMapping("/certs/nft/{id}")
    public ResultResponse readNft (@PathVariable Long id) {
        NftResponse nftResponse = certificationService.findNftListByCertificationId(id);
        return ResultResponse.result(0, "SUCCESS_MSG", nftResponse);
    }

    @PostMapping("/certs/{username}/nfv/minting/{id}")
    public ResultResponse NfvMinting(@RequestBody NfvRequest nfvRequest,
                                     @PathVariable String username,
                                     @PathVariable Long id) {
        certificationService.NfvMinting(nfvRequest, username, id);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @PostMapping("/certs/{username}/nft/minting/{id}")
    public ResultResponse NftMinting(@RequestBody NftRequest nftRequest,
                                     @PathVariable String username,
                                     @PathVariable Long id) {
        certificationService.NftMinting(nftRequest, username, id);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }

    @PatchMapping("/certs/nft/{username}/register/{id}")
    public ResultResponse registerNft(@PathVariable String username, @PathVariable Long id) {
        certificationService.registerNft(username, id);
        return ResultResponse.result(0, "SUCCESS_MSG");
    }
}