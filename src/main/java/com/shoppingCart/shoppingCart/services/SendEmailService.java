package com.shoppingCart.shoppingCart.services;


import com.shoppingCart.shoppingCart.dtos.EmailsDetailsDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.EmailsDetails;

import com.shoppingCart.shoppingCart.models.*;

import java.util.Set;


public interface SendEmailService {

    String sendSimpleMail(EmailsDetails details, Client client);

    void sendValidationMail(Client client);

    String sendMailWithAttachment(EmailsDetails details);
}
