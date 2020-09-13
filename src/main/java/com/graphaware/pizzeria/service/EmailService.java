package com.graphaware.pizzeria.service;

import com.graphaware.pizzeria.model.PizzeriaUser;
import com.graphaware.pizzeria.model.Purchase;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private final Properties props;

	public EmailService() throws IOException {
		ClassPathResource resource = new ClassPathResource("email.properties");
		props = PropertiesLoaderUtils.loadProperties(resource);
	}

	public void sendConfirmationEmail(PizzeriaUser user, Purchase purchase) throws MessagingException {
		send(user.getEmail(), "Order confirmation", "Your order has been processed");
	}

	public void send(String recipient, String subject, String body) throws MessagingException {

		System.out.println("Sending email to " + recipient);
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(props.getProperty("user"), props.getProperty("password"));
			}
		});
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("pizzas@gmail.com"));
		message.setRecipients(
				Message.RecipientType.TO, InternetAddress.parse(recipient));
		message.setSubject(subject);

		MimeBodyPart mimeBodyPart = new MimeBodyPart();
		mimeBodyPart.setContent(body, "text/plain");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(mimeBodyPart);

		message.setContent(multipart);

		Transport.send(message);

	}

}
