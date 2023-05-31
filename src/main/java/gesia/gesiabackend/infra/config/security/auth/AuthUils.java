package gesia.gesiabackend.infra.config.security.auth;

import gesia.gesiabackend.modules.common.exception.BadRequestException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import static gesia.gesiabackend.modules.common.Const.JWT_WITHOUT_ACCESS;

public class AuthUils {

    public static void checkJwtToken(String username) {
        if (!getAuthenticationPrincipalUsername().equals(username)) {
            throw new BadRequestException(JWT_WITHOUT_ACCESS);
        }
    }

    private static String getAuthenticationPrincipalUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();
        return ((UserDetails) principal).getUsername();
    }
}
