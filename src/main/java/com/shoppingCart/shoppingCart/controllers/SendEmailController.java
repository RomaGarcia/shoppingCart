package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.EmailsDetails;
import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.services.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {

    @Autowired
    private SendEmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody EmailsDetails details, Client client, Product product)
    {
        String status = emailService.sendSimpleMail(details, client, product);

        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(
            @RequestBody EmailsDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);

        return status;
    }
}
