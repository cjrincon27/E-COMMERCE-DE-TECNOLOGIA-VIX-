package ChallengeFinal.service.implement;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import ChallengeFinal.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

    @Service
    public class EmailServiceImplement implements EmailService {

        private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImplement.class);

        @Autowired
        private JavaMailSender sender;

        public boolean sendEmailTool(String textMessage, String email, String subject) {
            boolean send = false;
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            try {
                helper.setTo(email);
                helper.setText(textMessage, true);
                helper.setSubject(subject);
                sender.send(message);
                send = true;
                LOGGER.info("Mail enviado!");
            } catch (MessagingException e) {
                LOGGER.error("Hubo un error al enviar el mail: {}", e);
            }
            return send;
        }
    }

