package utils;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class SendSSLEmail {
    public void sendNewMail(String htmlFileName) throws MessagingException, UnsupportedEncodingException {
        final String fromEmail = "edmund.aunstin@nulogic.io";
        final String password = "";
        final String toEmail = "edmund.aunstin@nulogic.io";
        final String[] ccEmail = new String[]{};

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
       /* props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); */

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        SendReport.sendEmail(session, toEmail,ccEmail,"Automation Execution Report", "Please find the latest execution report",htmlFileName);

    }

}
