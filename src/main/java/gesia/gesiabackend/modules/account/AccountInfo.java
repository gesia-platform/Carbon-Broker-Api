package gesia.gesiabackend.modules.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static gesia.gesiabackend.modules.common.Const.ACCOUNT_DTO_NO_ACCOUNT_DETAILS;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AccountInfo {

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_name")
    private String name;

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_representative_name")
    private String representativeName;

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_contact")
    private String contact;

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_fax")
    private String fax;

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_introduction")
    private String introduction;

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_business_number")
    private String businessNumber;

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_address_street")
    private String streetAddress;   // 도로명 주소

    @NotBlank(message = ACCOUNT_DTO_NO_ACCOUNT_DETAILS)
    @Column(name = "account_address_detail")
    private String detailAddress;   // 상세 주소
}
