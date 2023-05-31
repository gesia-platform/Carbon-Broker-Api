package gesia.gesiabackend.infra.mail;

import org.springframework.stereotype.Component;

@Component
public class EmailTemplate {

    public String verifyAuthCodeMailTemplate(String authKey) {
        String content = ""
                + "<html><body>"
                + "<h2>[Gesia]</h2>"
                + "<p><span style='color:red;font-size:23px;font-weight:bold;'>" + authKey + "</span></p>"
                + "</body></html>";
        return content;
    }

    public String reissuePasswordMailTemplate(String authKey) {
        String content = ""
                + "<html><body>"
                + "<h2>[Gesia] 비밀번호 초기화 안내</h2>"
                + "<br>"
                + "<p><span style='color:red;font-size:23px;font-weight:bold;'>" + authKey + "</span></p>"
                + "</body></html>";
        return content;
    }
}
