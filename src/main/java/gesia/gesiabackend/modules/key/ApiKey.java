package gesia.gesiabackend.modules.key;

import gesia.gesiabackend.modules.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ApiKey extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_key_sq")
    private Long id;

    @Column(name = "api_key")
    private String key;

    @Column(name = "api_secret_key")
    private String secretKey;

    @Enumerated
    @Column(name = "api_type")
    private ApiKeyType type;

    @Column(name = "api_due_date")
    private LocalDateTime dueDate;
}
