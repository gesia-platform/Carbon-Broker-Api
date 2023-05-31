package gesia.gesiabackend.modules.code;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_sq")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "code_name")
    private String name;

    @Column(name = "code_description")
    private String description;

    @Column(name = "code_order")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_group_sq")
    private CodeGroup codeGroup;
}
