package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.EmailsDetails;
import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.models.ShoppingCart;

public interface SendEmailService {

    String sendSimpleMail(EmailsDetails details, Client client, Product product);

    String sendMailWithAttachment(EmailsDetails details);
}
