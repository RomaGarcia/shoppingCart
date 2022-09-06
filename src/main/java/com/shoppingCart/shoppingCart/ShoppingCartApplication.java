package com.shoppingCart.shoppingCart;

import com.shoppingCart.shoppingCart.models.Category;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.repositories.CategoryRepository;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ShoppingCartApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, ProductRepository productRepository, CategoryRepository categoryRepository){
		return (args) -> {

			Client client1 = new Client("Agostina", "Macchi", "agosmac@hotmail.com", passwordEncoder.encode("1234"), "Av siempreviva");
			Client client2 = new Client("Ramiro", "Rodriguez", "ramiro@hotmail.com", passwordEncoder.encode("12345"), "Av siempreviva");

			clientRepository.save(client1);
			clientRepository.save(client2);


			Category category1 = new Category("bebidas");

			categoryRepository.save(category1);


			Product product1 = new Product("Gaseosa", 200.00, 20, "coca-cola", category1);

			productRepository.save(product1);


		};
	}

}
