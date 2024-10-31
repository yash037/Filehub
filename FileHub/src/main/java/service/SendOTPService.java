package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendOTPService {
    public static boolean sendOTP(String name, String email, String genOTP) {
        String htmlContent = "<html>" +
            "<body>" +
            "<div style='text-align: center; font-family: Arial, sans-serif;'>" +
            "<h2>Verify your OTP</h2>" +
            "<p>Dear <h4>" + name + "</h4> , Enter the below OTP for email validation</p>" +
            "<p>Your OTP is</p>" +
            "<div style='display: inline-block; padding: 10px 20px; background-color: #007bff; color: #ffffff; font-size: 24px; font-weight: bold; border-radius: 5px;'>" +
            genOTP +
            "</div>" +
            "</div>" +
            "</body>" +
            "</html>";

        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "filehub777@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "vhbi ueno rhhe enwa");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Welcome to FileHub");

            // Now set the actual message
            message.setContent(htmlContent, "text/html");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }

}
