package gesia.gesiabackend.modules.nfv;

import gesia.gesiabackend.modules.account.Account;
import gesia.gesiabackend.modules.account.ApprovalStatus;
import gesia.gesiabackend.modules.common.BaseTimeEntity;
import gesia.gesiabackend.modules.nfv.dto.CertificationRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Certification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cert_sq")
    private Long id;

    @Column(name = "cert_number")
    private String number;

    @Column(name = "cert_name")
    private String name;

    @Column(name = "cert_file_path")
    private String filePath;

    @Column(name = "cert_wallet_addr")
    private String walletAddr;

    @Column(name = "cert_registration _number")
    private String registrationNumber;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cert_business_type")
    private BusinessType businessType;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cert_participation_type")
    private ParticipationType participationType;

    @Column(name = "cert_ representative_name")
    private String representativeName;

    @Column(name = "cert_address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "cert_approval_status")
    private ApprovalStatus approvalStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "cert_issuance_type")
    private IssuanceType issuanceType;

    @Column(name = "cert_api_url")
    private String apiUrl;

    @Column(name = "cert_api_parameter")
    private String apiParameter;

    @Column(name = "cert_institution_name")
    private String institutionName;

    @Column(name = "cert_yearly_quantity")
    private String yearlyAuthQuantity;

    @Column(name = "cert_start_date")
    private String startDate;

    @Column(name = "cert_due_date")
    private String dueDate;

    @Column(name = "cert_image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_sq")
    private Account account;

    @Column(name = "category_sq")
    private Long categorySq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_sq", referencedColumnName = "category_sq", insertable = false, updatable = false)
    private Category category;

    @OneToOne(mappedBy = "certification")
    private Nfv nfv;

    @Builder
    public Certification(String number, String name, String filePath, String walletAddr, ApprovalStatus approvalStatus, String institutionName, String yearlyAuthQuantity
            , String registrationNumber, BusinessType businessType, IssuanceType issuanceType, ParticipationType participationType, String representativeName, String address, String apiUrl, String apiParameter, String startDate, String dueDate, String image, Category category, Long categorySq, Account account) {
        this.number = number;
        this.name = name;
        this.filePath = filePath;
        this.walletAddr = walletAddr;
        this.approvalStatus = approvalStatus;
        this.institutionName = institutionName;
        this.yearlyAuthQuantity = yearlyAuthQuantity;
        this.registrationNumber = registrationNumber;
        this.businessType = businessType;
        this.issuanceType = issuanceType;
        this.participationType = participationType;
        this.representativeName = representativeName;
        this.address = address;
        this.apiUrl = apiUrl;
        this.apiParameter = apiParameter;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.image = image;
        this.category = category;
        this.categorySq = categorySq;
        this.account = account;
    }

    public boolean isTrueStatus() {
        return this.approvalStatus != ApprovalStatus.REQUEST;
    }

    public void updateCertification(CertificationRequest certificationRequest) {
        this.number = certificationRequest.getNumber();
        this.name = certificationRequest.getName();
        this.filePath = certificationRequest.getFilePath();
        this.walletAddr = certificationRequest.getWalletAddr();
        this.approvalStatus = certificationRequest.getApprovalStatus();
        this.institutionName = certificationRequest.getInstitutionName();
        this.yearlyAuthQuantity = certificationRequest.getYearlyAuthQuantity();
        this.registrationNumber = certificationRequest.getRegistrationNumber();
        this.businessType = certificationRequest.getBusinessType();
        this.issuanceType = certificationRequest.getIssuanceType();
        this.participationType = certificationRequest.getParticipationType();
        this.representativeName = certificationRequest.getRepresentativeName();
        this.address = certificationRequest.getAddress();
        this.apiUrl = certificationRequest.getApiUrl();
        this.apiParameter = certificationRequest.getApiParameter();
        this.startDate = certificationRequest.getStartDate();
        this.dueDate = certificationRequest.getDueDate();
        this.image = certificationRequest.getName();
        this.category = certificationRequest.getCategory();
        this.categorySq = certificationRequest.getCategorySq();
    }
}
