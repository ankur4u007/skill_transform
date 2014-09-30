package springbatch.sendmail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component("sendmailservice")
public class SendMailService {

    private static final Logger log = Logger.getLogger(SendMailService.class);
    @Autowired
    private JavaMailSender mailSender;
    @Value("${sendmail.senderAddress}")
    private String senderAddress;
    @Value("${sendmail.recipient}")
    private String recipient;

    public void sendMail(final String message) {
	log.debug("send Email started");

	final MimeMessagePreparator preparator = new MimeMessagePreparator() {
	    public void prepare(final MimeMessage mimeMessage) throws Exception {
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
		mimeMessage.setFrom(new InternetAddress(senderAddress));
		mimeMessage.setSubject("JOB Report");
		final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setText(message);
	    }

	};
	try {
	    mailSender.send(preparator);
	    log.info("send Email completed");
	} catch (final MailException ex) {
	    log.debug("send Email failed", ex);
	}
    }
}
