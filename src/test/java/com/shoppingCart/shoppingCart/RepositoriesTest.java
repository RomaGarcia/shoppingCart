package com.shoppingCart.shoppingCart;

import com.shoppingCart.shoppingCart.models.Category;
import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.Product;
import com.shoppingCart.shoppingCart.repositories.CategoryRepository;
import com.shoppingCart.shoppingCart.repositories.ClientRepository;
import com.shoppingCart.shoppingCart.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase()
public class RepositoriesTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void existCategory(){
        List<Category> categories=categoryRepository.findAll();
        assertThat(categories, is(not(empty())));
    }

    @Test
    public void existCategoryBebidas(){
        List<Category> categories=categoryRepository.findAll();
        assertThat(categories, hasItem(hasProperty("name", is("bebidas"))));
    }

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void existClient(){
        List<Client> clients=clientRepository.findAll();
        assertThat(clients, is(not(empty())));
    }

    @Test
    public void existClientAgostina(){
        List<Client> clients=clientRepository.findAll();
        assertThat(clients, hasItem(hasProperty("firstName", is("Agostina"))));
    }

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void existProduct(){
        List<Product> products=productRepository.findAll();
        assertThat(products, is(not(empty())));
    }

    @Test
    public void existProductGaseosa(){
        List<Product> products=productRepository.findAll();
        assertThat(products, hasItem(hasProperty("name", is("Gaseosa"))));
    }



}
