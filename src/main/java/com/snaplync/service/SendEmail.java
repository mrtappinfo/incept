package com.snaplync.service;

import java.io.PrintStream;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    static final String FROM = "harish.kv.kumar@gmail.com";
    static final String TO = "harish.kv.kumar@gmail.com";
    static final String BODY = "This email was sent through the Amazon SES SMTP interface by using Java.";
    static final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";
    static final String SMTP_USERNAME = "AKIAIBBND44RI2BZSBSQ";
    static final String SMTP_PASSWORD = "AiD+nM5Ovi0+ANUCy1gVC5Kks+X/8iNWroz9SFavFaZN";
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    static final int PORT = 25;
    
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendMessage(String receipient) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtp.port", 25);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        Session session = Session.getDefaultInstance((Properties)props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom((Address)new InternetAddress("harish.kv.kumar@gmail.com"));
        msg.setRecipient(Message.RecipientType.TO, (Address)new InternetAddress(receipient));
        msg.setSubject("Amazon SES test (SMTP interface accessed using Java)");
        msg.setContent((Object)"This email was sent through the Amazon SES SMTP interface by using Java.", "text/plain");
        Transport transport = session.getTransport();
        try {
            System.out.println("Attempting to send an email through the Amazon SES SMTP interface...");
            transport.connect("email-smtp.us-east-1.amazonaws.com", "AKIAIBBND44RI2BZSBSQ", "AiD+nM5Ovi0+ANUCy1gVC5Kks+X/8iNWroz9SFavFaZN");
            transport.sendMessage((Message)msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally {
            transport.close();
        }
    }
}
