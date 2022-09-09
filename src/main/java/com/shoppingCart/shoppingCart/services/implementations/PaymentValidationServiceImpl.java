package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.CardValidationDTO;
import com.shoppingCart.shoppingCart.services.PaymentValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class PaymentValidationServiceImpl implements PaymentValidationService {

    @Autowired
    RestTemplate template;

    @Override
    public String validation(CardValidationDTO cardValidationDTO){

          HttpHeaders headers = new HttpHeaders();
          headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<CardValidationDTO> entity = new HttpEntity<CardValidationDTO>(cardValidationDTO, headers);


        return template.exchange("http://localhost:8081/cardValidation", HttpMethod.POST, entity, String.class).getBody();
    }


//    @PostMapping("/hombanking/loans")
//    public String template(@RequestBody LoanApplicationDTO loanApplicationDTO){
////       Client newClient = new Client("Ramiro", "Rodriguez", "ramiro@gmail.com", "123456", "Av Siempreviva");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<LoanApplicationDTO> entity = new HttpEntity<LoanApplicationDTO>(loanApplicationDTO, headers);
//        return template.exchange("http://localhost:8081/api/loans", HttpMethod.POST, entity, String.class).getBody();
//    }


}
