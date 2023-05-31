package gesia.gesiabackend.modules.account.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountResponse {

    private String email;

    private String password;

    private String name;

    @Builder
    public AccountResponse(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
