package hr.masters.project.service.impl;

import hr.masters.project.service.EmailService;
import hr.masters.project.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService
{
    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Async
    public void sendNewPassword(final String userEmail, final String newPassword)
    {
        final SimpleMailMessage newPasswordEmail = new SimpleMailMessage();
        newPasswordEmail.setFrom(Constants.Email.EMAIL_NAME);
        newPasswordEmail.setSubject(Constants.Email.NEW_PASSWORD_SUBJECT);
        newPasswordEmail.setTo(userEmail);
        newPasswordEmail.setText(Constants.Email.NEW_PASSWORD_HEADING + newPassword);
        mailSender.send(newPasswordEmail);
    }
}
