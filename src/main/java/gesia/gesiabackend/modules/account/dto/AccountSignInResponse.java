package gesia.gesiabackend.modules.account.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountSignInResponse {

    private String username;

    private String jwtToken;

    @Builder
    public AccountSignInResponse(String username, String jwtToken) {
        this.username = username;
        this.jwtToken = jwtToken;
    }
}
