package com.shoppingCart.shoppingCart;

import com.shoppingCart.shoppingCart.models.*;
import com.shoppingCart.shoppingCart.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ShoppingCartApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, ProductRepository productRepository, CategoryRepository categoryRepository, ShoppingCartRepository shoppingCartRepository, TicketRepository ticketRepository){
		return (args) -> {

			Client client1 = new Client("Agostina", "Macchi", "agosmac@hotmail.com", passwordEncoder.encode("1234"), "Av siempreviva");
			Client client2 = new Client("Ramiro", "Rodriguez", "ramiro@admin.com", passwordEncoder.encode("12345"), "Av siempreviva");
			client1.setStatus(true);
			client2.setStatus(true);
			clientRepository.save(client1);
			clientRepository.save(client2);


			Category category1 = new Category("bebidas");

			categoryRepository.save(category1);


			Product product1 = new Product("Fanta", 10.00, 20, "gaseosa sabor naranja", category1);

			productRepository.save(product1);
			Product product2 = new Product("Coca", 300.00, 20, "gaseosa sabor cola", category1);

			productRepository.save(product2);
			ShoppingCart shoppingCart1 = new ShoppingCart(client1);
			shoppingCartRepository.save(shoppingCart1);
			clientRepository.save(client1);
			ticketRepository.save(new Ticket());


		};
	}

}
