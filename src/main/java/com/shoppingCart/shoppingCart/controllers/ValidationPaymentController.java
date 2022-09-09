package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.LoanApplicationDTO;
import com.shoppingCart.shoppingCart.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class ValidationPaymentController {


    @Autowired
    RestTemplate template;

//    @PostMapping("/hombanking/loans")
//    public String template(@RequestBody LoanApplicationDTO loanApplicationDTO){
////       Client newClient = new Client("Ramiro", "Rodriguez", "ramiro@gmail.com", "123456", "Av Siempreviva");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<LoanApplicationDTO> entity = new HttpEntity<LoanApplicationDTO>(loanApplicationDTO, headers);
//        return template.exchange("http://localhost:8081/api/loans", HttpMethod.POST, entity, String.class).getBody();
//    }


}
