package com.mail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmailTLS
{
	public static void main(String[] args) {

		//Turn on less secure app from gmail
		//https://myaccount.google.com/lesssecureapps
		
        final String username = "username@gmail.com";
        final String password = "password";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("username@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("username@gmail.com, username1@gmail.com")
            );
            message.setSubject("Testing Gmail TLS from java");
            message.setText("Dear User,"
                    + "\n\n Sendig mail from java !!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

	 
}
