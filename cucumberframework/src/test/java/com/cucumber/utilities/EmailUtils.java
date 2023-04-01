package com.cucumber.utilities;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.PasswordAuthentication;


import com.cucumber.base.BaseClass;


public class EmailUtils extends BaseClass {

	  

	  public static void SendMail() {

	    String username =TestDataUtils.emailun;

	    String password = TestDataUtils.emailps;

	    // or IP address
	    // final String host = "localhost";

	    // Get system properties
	    Properties props = new Properties();

	    // enable authentication
	    props.put("mail.smtp.auth", "true");

	    // enable STARTTLS
	    props.put("mail.smtp.starttls.enable", "true");

	    // Setup mail server
	    props.put("mail.smtp.host", "smtp.gmail.com");

	    // TLS Port
	    props.put("mail.smtp.port", 587);

	    // creating Session instance referenced to
	    // Authenticator object to pass in
	    // Session.getInstance argument
	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {

	      // override the getPasswordAuthentication method
	      protected PasswordAuthentication getPasswordAuthentication() {

	        return new PasswordAuthentication(username, password);
	      }
	    });

	    try {

	      // compose the message
	      // javax.mail.internet.MimeMessage class is
	      // mostly used for abstraction.
	      Message message = new MimeMessage(session);

	      //from address
	      message.setFrom(new InternetAddress(TestDataUtils.sender));
	      //recipient address
	      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TestDataUtils.recv));
	      message.setSubject(TestDataUtils.mailsub);
	      // Create the message body part
	      MimeBodyPart messageBodyPart = new MimeBodyPart();
	      Multipart multipart = new MimeMultipart();
	      //attachment location
	      DataSource source = new FileDataSource(TestDataUtils.report);
	      messageBodyPart.setDataHandler(new DataHandler(source));
	      messageBodyPart.setFileName(TestDataUtils.filename);
	      multipart.addBodyPart(messageBodyPart);
	      messageBodyPart = new MimeBodyPart();
	      messageBodyPart.setText(TestDataUtils.maildesc);
	      multipart.addBodyPart(messageBodyPart);
	      // Set the Multipart message to the email message
	      message.setContent(multipart);
	      // send Message
	      Transport.send(message);
	    } catch (MessagingException e) {
	      throw new RuntimeException(e);
	    }
	  }
	}