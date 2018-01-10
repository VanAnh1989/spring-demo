package demo.DAO.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSend {
	
	@Autowired
	JavaMailSender sender;
	
	public boolean sendmailNow(String content) {
		MimeMessage mail = sender.createMimeMessage();
		MimeMessageHelper heper = new MimeMessageHelper(mail);
		try {
			heper.setTo("anh.nguyen.van@ntq-solution.com.vn");
			heper.setSubject("Text Mail Sender");
			heper.setText(content);
			sender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
}
