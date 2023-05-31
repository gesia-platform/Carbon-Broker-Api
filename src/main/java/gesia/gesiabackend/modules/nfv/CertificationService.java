package gesia.gesiabackend.modules.nfv;

import gesia.gesiabackend.infra.config.security.auth.AuthUils;
import gesia.gesiabackend.modules.account.Account;
import gesia.gesiabackend.modules.account.AccountRepository;
import gesia.gesiabackend.modules.common.exception.BadRequestException;
import gesia.gesiabackend.modules.nft.Nft;
import gesia.gesiabackend.modules.nft.NftMarketType;
import gesia.gesiabackend.modules.nft.NftRepository;
import gesia.gesiabackend.modules.nft.TransactionType;
import gesia.gesiabackend.modules.nfv.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static gesia.gesiabackend.modules.common.Const.*;

@Service
@RequiredArgsConstructor
@Transactional
public class CertificationService {

    private final CertificationRepository certificationRepository;
    private final AccountRepository accountRepository;
    private final NfvRepository nfvRepository;
    private final NftRepository nftRepository;

    public void createCert(CertificationRequest certificationRequest, String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        Certification certification = Certification.builder()
                .number(certificationRequest.getNumber())
                .name(certificationRequest.getName())
                .filePath(certificationRequest.getFilePath())
                .walletAddr(certificationRequest.getWalletAddr())
                .registrationNumber(certificationRequest.getRegistrationNumber())
                .businessType(certificationRequest.getBusinessType())
                .participationType(certificationRequest.getParticipationType())
                .representativeName(certificationRequest.getRepresentativeName())
                .address(certificationRequest.getAddress())
                .issuanceType(certificationRequest.getIssuanceType())
                .apiUrl(certificationRequest.getApiUrl())
                .apiParameter(certificationRequest.getApiParameter())
                .startDate(certificationRequest.getStartDate())
                .dueDate(certificationRequest.getDueDate())
                .category(certificationRequest.getCategory())
                .categorySq(certificationRequest.getCategorySq())
                .approvalStatus(certificationRequest.getApprovalStatus())
                .yearlyAuthQuantity(certificationRequest.getYearlyAuthQuantity())
                .institutionName(certificationRequest.getInstitutionName())
                .account(account)
                .build();

        certificationRepository.save(certification);
    }

    public void updateCert(CertificationRequest certificationRequest, Long id, String username) {
        AuthUils.checkJwtToken(username);

        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        Certification CertificationById = certificationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        if (!account.getId().equals(CertificationById.getAccount().getId())) {
            throw new BadRequestException(CERTIFICATION_NOT_FOUND_ACCOUNT_BY_CERT);
        }
        if (CertificationById.isTrueStatus()) {
            throw new BadRequestException(CERTIFICATION_EDITING_DISABLED);
        }

        CertificationById.updateCertification(certificationRequest);
    }

    public List<CertificationResponse> readCert(String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        AuthUils.checkJwtToken(account.getUsername());

        List<Certification> certifications = certificationRepository.findByAccount(account);

        List<CertificationResponse> certificationResponses = new ArrayList<>();

        for (Certification certification : certifications) {
            String categoryName = certificationRepository.findCategoryNameById(certification.getId());

            CertificationResponse certificationResponse = CertificationResponse.builder()
                    .number(certification.getNumber())
                    .name(certification.getName())
                    .filePath(certification.getFilePath())
                    .walletAddr(certification.getWalletAddr())
                    .approvalStatus(certification.getApprovalStatus())
                    .registrationNumber(certification.getRegistrationNumber())
                    .businessType(certification.getBusinessType())
                    .participationType(certification.getParticipationType())
                    .representativeName(certification.getRepresentativeName())
                    .address(certification.getAddress())
                    .apiUrl(certification.getApiUrl())
                    .apiParameter(certification.getApiParameter())
                    .startDate(certification.getStartDate())
                    .dueDate(certification.getDueDate())
                    .issuanceType(certification.getIssuanceType())
                    .institutionName(certification.getInstitutionName())
                    .categoryCode(categoryName)
                    .yearlyAuthQuantity(certification.getYearlyAuthQuantity())
                    .build();

            certificationResponses.add(certificationResponse);

            if (certificationResponses.isEmpty()) {
                throw new BadRequestException(CERTIFICATION_NOT_FOUND_BY_ID);
            }
        }
        return certificationResponses;
    }

    public NfvResponse findNfvListByCertificationId(Long id) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NOT_FOUND_BY_ID));

        List<Nfv> getNfvListById = certificationRepository.findNFVListByCertId(certification.getId());
        String categoryName  = certification.getCategory().getName();

        return NfvResponse.builder()
                .nfvList(getNfvListById)
                .categoryName(categoryName)
                .build();
    }

    public NftResponse findNftListByCertificationId(Long id) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NOT_FOUND_BY_ID));

        List<Nft> getNftListById = certificationRepository.findNftListByAccountSq(account.getId());

        return NftResponse.builder()
                .nftList(getNftListById)
                .build();
    }

    public void NfvMinting(NfvRequest nfvRequest, String username, Long id) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        AuthUils.checkJwtToken(account.getUsername());

        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NOT_FOUND_BY_ID));

        if (!account.getId().equals(certification.getAccount().getId())) {
            throw new BadRequestException(CERTIFICATION_NOT_FOUND_ACCOUNT_BY_CERT);
        }

        Nfv nfv = Nfv.builder()
                .accountId(account.getId())
                .certification(certification)
                .name(nfvRequest.getName())
                .ton(nfvRequest.getTon())
                .imageUrl(nfvRequest.getImageUrl())
                .introduction(nfvRequest.getIntroduction())
                .build();

        nfvRepository.save(nfv);
    }

    public void NftMinting(NftRequest nftRequest, String username, Long id) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        AuthUils.checkJwtToken(account.getUsername());

        Nfv nfv = nfvRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NFV_NOT_FOUND));

        if (!account.getId().equals(nfv.getAccountId())) {
            throw new BadRequestException(CERTIFICATION_NOT_FOUND_ACCOUNT_BY_CERT);
        }

        Nft nft = Nft.builder()
                .transactionType(TransactionType.WAITING)
                .nfv(nfv)
                .accountId(account.getId())
                .certificationId(nfv.getCertification().getId())
                .name(nftRequest.getName())
                .ton(nftRequest.getTon())
                .imageUrl(nftRequest.getImageUrl())
                .introduction(nftRequest.getIntroduction())
                .build();

        nftRepository.save(nft);
    }

    public void registerNft(String username, Long id) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(ACCOUNT_NOT_FOUND_ACCOUNT));

        AuthUils.checkJwtToken(account.getUsername());

        Nft nft = nftRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NFT_NOT_FOUND));

        if (!account.getId().equals(nft.getAccountId())) {
            throw new BadRequestException(CERTIFICATION_NOT_FOUND_ACCOUNT_BY_CERT);
        } else {
            nft.setNftMarketType(NftMarketType.BROKER);
            nft.setTransactionType(TransactionType.SELL);
            nftRepository.save(nft);
        }
    }
}