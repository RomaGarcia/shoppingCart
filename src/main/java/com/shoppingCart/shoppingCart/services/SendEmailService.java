package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.models.*;

import java.util.Set;

public interface SendEmailService {

    String sendSimpleMail(EmailsDetails details, Client client, Set<ProductLoad> product);

    String sendMailWithAttachment(EmailsDetails details);
}
