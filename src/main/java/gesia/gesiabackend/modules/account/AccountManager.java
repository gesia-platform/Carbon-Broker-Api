package gesia.gesiabackend.modules.account;

import gesia.gesiabackend.modules.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AccountManager extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_sq")
    private Long id;

    @Column(name = "manager_name")
    private String name;

    @Column(name = "manager_phone")
    private String phoneNumber;

    @Column(name = "manager_email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_sq")
    private Account account;
}
