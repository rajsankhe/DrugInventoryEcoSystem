/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

/**
 *
 * @author Admin
 */
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {

    public static void sendMail(String username, String to, String userPassword) {
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session
        final String from = "noreply.brocoder.aed@gmail.com";
        final String password = "broCoders$332";
        String sub = "Welcome to Drug Inventory System";
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            StringBuilder emailBody = new StringBuilder();

            emailBody.append("<h1>Welcome onboard!!!!</h1><br>Your username is :").
                    append(username).
                    append("</p><p>Your Password is: ").
                    append(userPassword).
                    append("</p>");
            message.setContent(emailBody.toString(), "text/html; charset=utf-8");
            //send message
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
