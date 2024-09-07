package javalasttermproject.javalasttermproject.Model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class ConnectGmail {
    private String username = "viethung45bkpro@gmail.com";
    private String appPassword = "znhoaopnlytsvgpr";
    private Email email;
    public  ConnectGmail(){
        email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(username, appPassword));
    }
    public boolean SendEmail(String emailTo ,String Subject, String Messenge){
        try {
            email.setStartTLSEnabled(true); // Sử dụng TLS để kết nối
            email.setFrom(username);

            email.setSubject(Subject); // Tiêu đề của email
            email.setMsg(Messenge); // Nội dung email
            email.addTo(emailTo);// Email nhận
            email.send();  // Gửi email
            System.out.println("Email sent successfully!");
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

}
