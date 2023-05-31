package gesia.gesiabackend.modules.code;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CodeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_group_sq")
    private Long id;

    @Column(name = "code_group_name")
    private String number;

    @Column(name = "code_group_description")
    private String description;

    @OneToMany(mappedBy = "codeGroup", cascade = CascadeType.ALL)
    private List<Code> codes = new ArrayList<>();
}
