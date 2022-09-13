package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.dtos.CardValidationDTO;
import com.shoppingCart.shoppingCart.dtos.ShoppingCartDTO;
import com.shoppingCart.shoppingCart.dtos.EmailsDetailsDTO;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.models.EmailsDetails;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.repositories.ProductRepository;
import com.shoppingCart.shoppingCart.repositories.ShoppingCartRepository;
import com.shoppingCart.shoppingCart.services.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentValidationService  paymentValidationService;

    @Autowired
    private SendEmailService sendEmailService;

    @Override
    public List<ShoppingCartDTO> getAllShoppingCart() {
        return shoppingCartRepository.findAll().stream().map(shoppingCart -> new ShoppingCartDTO(shoppingCart)).collect(toList());
    }

    @Override
    public ShoppingCartDTO getShoppingCartById(Long id) {
        return new ShoppingCartDTO(shoppingCartRepository.findById(id).get());

    }

    @Override
    public void postShoppingCart(Authentication authentication) {
        Client clientConnected = clientRepository.findByEmail(authentication.getName());

    }

    @Override
    public void remove(ShoppingCart shoppingCart, ProductLoad productLoad) {
        shoppingCart.getProductLoans().remove(productLoad);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ResponseEntity<Object> buy(Long id, String wayToPay, CardValidationDTO cardValidationDTO) {

        String response= paymentValidationService.validation(cardValidationDTO);

        if(!response.equals(null)){
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).get();
        Set<ProductLoad> productLoads = shoppingCart.getProductLoans();

        if (productLoads == null) {
            return new ResponseEntity<>("There are no product in the cart", HttpStatus.FORBIDDEN);
        }
        if (!productService.discount(productLoads)) {
            return new ResponseEntity<>("There is not enaugh stock", HttpStatus.FORBIDDEN);
        }

        shoppingCart.setTicket(ticketService.create(shoppingCart, wayToPay));
        shoppingCart.setStatus(false);
        ShoppingCart newShoppingCart = new ShoppingCart(shoppingCart.getClient());
        shoppingCartRepository.save(shoppingCart);
        shoppingCartRepository.save(newShoppingCart);

        EmailsDetails details = new EmailsDetails();
        Client client = shoppingCart.getClient();
        Product product = new Product();

        sendEmailService.sendSimpleMail(details, client, product);

        return new ResponseEntity<>("Compra realizada", HttpStatus.ACCEPTED);
    }
}
