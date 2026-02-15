package com.lb.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender javaMailSender;

	public boolean mailsender(String subject, String body, String to, File f) {

		try {
			MimeMessage mimemsg = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimemsg,true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			helper.addAttachment("Plans_Info", f);
			//helper.addAttachment("plans.pdf", f);
			javaMailSender.send(mimemsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
