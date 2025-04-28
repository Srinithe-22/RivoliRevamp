package utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.MimeMessage;

public class GmailReader {
    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String username = ""; // Replace with your Gmail address
        String password = "";    // Replace with your app-specific password

        try {
            // Set properties for the IMAP connection
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties);

            // Connect to the store
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            // Access the inbox
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Fetch messages
            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                if (message instanceof MimeMessage) {
                    MimeMessage mimeMessage = (MimeMessage) message;
                    System.out.println("Message read");
                    //if(mimeMessage.getSubject().contains("Your Laura Geller Beauty login code is 8581")){
                        System.out.println("Subject: " + mimeMessage.getSubject());
                        System.out.println("Content: " + mimeMessage.getContent());
                   // }
                }
            }

            // Close connections
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}