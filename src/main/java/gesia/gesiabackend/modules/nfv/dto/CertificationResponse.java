package gesia.gesiabackend.modules.nfv.dto;

import gesia.gesiabackend.modules.account.ApprovalStatus;
import gesia.gesiabackend.modules.nfv.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CertificationResponse {

    @NotBlank
    private String number;

    @NotBlank
    private String name;

    @NotBlank
    private String filePath;

    @NotBlank
    private String walletAddr;

    @NotBlank
    private ApprovalStatus approvalStatus;

    @NotBlank
    private String registrationNumber;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank
    private BusinessType businessType;

    @Enumerated(EnumType.ORDINAL)
    @NotBlank
    private ParticipationType participationType;

    @NotBlank
    private String representativeName;

    @NotBlank
    private String address;

    @NotBlank
    private String apiUrl;

    @NotBlank
    private String apiParameter;

    @Enumerated(EnumType.STRING)
    private IssuanceType issuanceType;

    @NotBlank
    private String institutionName;

    @NotBlank
    private String startDate;

    @NotBlank
    private String dueDate;

    @NotBlank
    private String yearlyAuthQuantity;

    @NotBlank
    private String categoryCode;

    @Builder
    public CertificationResponse(String number, String name, String filePath, String walletAddr, ApprovalStatus approvalStatus, String registrationNumber, BusinessType businessType, ParticipationType participationType, String representativeName, String address, String apiUrl, String apiParameter, IssuanceType issuanceType, String institutionName, String categoryCode, String startDate, String dueDate, String yearlyAuthQuantity) {
        this.number = number;
        this.name = name;
        this.filePath = filePath;
        this.walletAddr = walletAddr;
        this.approvalStatus = approvalStatus;
        this.registrationNumber = registrationNumber;
        this.businessType = businessType;
        this.participationType = participationType;
        this.representativeName = representativeName;
        this.address = address;
        this.apiUrl = apiUrl;
        this.apiParameter = apiParameter;
        this.issuanceType = issuanceType;
        this.institutionName = institutionName;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.categoryCode = categoryCode;
        this.yearlyAuthQuantity = yearlyAuthQuantity;
    }
}

