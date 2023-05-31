package gesia.gesiabackend.modules.nfv.dto;

import gesia.gesiabackend.modules.account.ApprovalStatus;
import gesia.gesiabackend.modules.nfv.BusinessType;
import gesia.gesiabackend.modules.nfv.Category;
import gesia.gesiabackend.modules.nfv.IssuanceType;
import gesia.gesiabackend.modules.nfv.ParticipationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CertificationRequest {

    @NotBlank
    private String number;

    @NotBlank
    private String name;

    @NotBlank
    private String filePath;

    @NotBlank
    private String walletAddr;

    @NotBlank
    private String registrationNumber;

    @Enumerated(EnumType.ORDINAL)
    private BusinessType businessType;

    @Enumerated(EnumType.ORDINAL)
    private ParticipationType participationType;

    @NotBlank
    private String representativeName;

    @NotBlank
    private String address;

    @Enumerated(EnumType.STRING)
    private IssuanceType issuanceType;

    @NotBlank
    private String apiUrl;

    @NotBlank
    private String apiParameter;

    @NotBlank
    private String startDate;

    @NotBlank
    private String dueDate;

    @NotBlank
    private Long categorySq;

    @NotNull
    private Category category;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;

    @NotBlank
    private String yearlyAuthQuantity;

    @NotBlank
    private String institutionName;

    @NotBlank
    private String account;
}
