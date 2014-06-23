/**
 * 
 */
package com.persinfo.utilities;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author deva
 *
 */
public class MailService {
	
	public static void sendEmail(String subject, String msgBody, String toEmail, String toName){
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("ptecloud@gmail.com", "Anytime, Anywhere Make Cloud Private - PteCloud Admin"));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(toEmail, toName));
            msg.setSubject(subject);
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (Exception e) {
            // ...
        }
	}

}
