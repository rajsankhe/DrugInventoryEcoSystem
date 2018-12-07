/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils.email;

/**
 *
 * @author Admin
 */
import business.workqueue.WorkRequest;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public void sendMail(String username, String to, String userPassword) {
        System.out.println("Mail triggered! to: " + to);
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

    public void sendMailMulti(WorkRequest workRequest, List<String> emailIdList) {
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

            for (String email : emailIdList) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }

            message.setSubject(sub);
            message.setContent(createEmailMessageWorkAlert(workRequest), "text/html; charset=utf-8");
            //send message
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public String createEmailMessageLoginCredentials(String username, String password) {
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("<h1>Welcome onboard!!!!</h1><br>Your username is :").
                append(username).
                append("</p><p>Your Password is: ").
                append(password).
                append("</p>");

        return emailBody.toString();
    }

    public String createEmailMessageWorkAlert(WorkRequest workRequest) {
        StringBuilder emailBody = new StringBuilder();

        emailBody.append("<h1>Work Request completed successfully</h1><br> Details: Request </p><p>ID: ").
                append(workRequest.getRequestId()).
                append("</p>");

        return emailBody.toString();
    }
}
