package com.tvsconsult.services;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("ZohoSMTP")
public class ZohoSMTP {
	
	private final String zohoUsername = "georgi@tvsconsult.com";
	
	/*
    @Autowired
    Session session;
    
    @Async
	public void sendEmail(String htmlText, String contentStr, String subject, String recipientEmail) throws AddressException, MessagingException {
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(zohoUsername));
		message.setSubject(subject);
		// This mail has 2 part, the BODY and the embedded image
		MimeMultipart multipart = new MimeMultipart("related");
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(contentStr + htmlText, "text/html");
		multipart.addBodyPart(messageBodyPart);
		// put everything together
		message.setContent(multipart);
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, true));
		System.out.println("Create MIME message done.");
		Transport.send(message, InternetAddress.parse(recipientEmail, true));
	}
	
	*/
}
