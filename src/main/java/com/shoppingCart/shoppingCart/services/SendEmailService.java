package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.EmailsDetailsDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.EmailsDetails;

public interface SendEmailService {

    String sendSimpleMail(EmailsDetails details);

    void sendValidationMail(Client client);

    String sendMailWithAttachment(EmailsDetails details);
}
