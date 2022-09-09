package com.shoppingCart.shoppingCart.services;

import com.shoppingCart.shoppingCart.dtos.CardValidationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface PaymentValidationService {


    String validation(CardValidationDTO cardValidationDTO);
}
