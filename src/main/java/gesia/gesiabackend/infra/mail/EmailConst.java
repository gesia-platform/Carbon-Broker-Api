package gesia.gesiabackend.infra.mail;

public class EmailConst {

    public static final String EMAIL_SEND_AUTH_CODE_MESSAGE = "[Gesia] Guide to sending verification code";
    public static final String EMAIL_SEND_TEMPORARY_PASSWORD = "[Gesia] Guide to sending temporary password";
    public static final long EMAIL_VERIFICATION_EXPIRATION_TIME = 60 * 2L; // 2 minute
}
