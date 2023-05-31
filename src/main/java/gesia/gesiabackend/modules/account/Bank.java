package gesia.gesiabackend.modules.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static gesia.gesiabackend.modules.common.Const.ACCOUNT_DTO_NO_BANK_INFO;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Bank {

    @NotBlank(message = ACCOUNT_DTO_NO_BANK_INFO)
    @Column(name = "bank_name")
    private String name;

    @NotBlank(message = ACCOUNT_DTO_NO_BANK_INFO)
    @Column(name = "bank_account_num")
    private String accountNumber;
}
