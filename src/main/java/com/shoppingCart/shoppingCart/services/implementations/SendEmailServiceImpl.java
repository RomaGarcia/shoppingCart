package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.models.*;
import com.shoppingCart.shoppingCart.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Set;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;
    /*private Iterable<? extends Product> products;*/

    @Override
    public String sendSimpleMail(EmailsDetails details, Client client, Set<ProductLoad> product) {
        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(/*details.getRecipient()*/client.getEmail());
            ProductLoad productLoan = new ProductLoad();
            mailMessage.setText("MARKETPLACE/E-COMMERCE" + "\n" +
                    "--------------------------------" + "\n" +
                    "TICKET" + "\n" +
                    "--------------------------------" + "\n" +
                    client.getFirstName() + " " + client.getLastName() + "\n" +
                    client.getAddress() + "\n" +
                    "--------------------------------" + "\n"
                    /*productLoan.getProduct().getName()*/);
                    /*.getProduct().getStock() + " x " + productLoan.getProduct().getPrice() + "\n" +
                    productLoan.getProduct().getCategory() + "\n" +
                    productLoan.getProduct().getDescription() + " " + productLoan.getProduct().getName()
                    );*/

            /*ProductLoad[] ProductLoads = new ProductLoad[0];
            for (ProductLoad productLoan:ProductLoads) {
                mailMessage.setText(productLoan.getProduct().getStock() + " x " + productLoan.getProduct().getPrice() + "\n" +
                        productLoan.getProduct().getCategory() + "\n" +
                        productLoan.getProduct().getDescription() + " " + productLoan.getProduct().getName());

            }*/

            mailMessage.setSubject("Ticket de compra");

            javaMailSender.send(mailMessage);
            return "Email enviado correctamente";
        }

        catch (Exception e) {
            return "Error al enviar el email";
        }
    }

    /*@Override
    public String sendSimpleMail(EmailsDetails details, Client client, Set<ProductLoad> product) {
        return null;
    }*/

    public String sendMailWithAttachment(EmailsDetails details)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());

            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        catch (MessagingException e) {

            return "Error while sending mail!!!";
        }
    }
}
