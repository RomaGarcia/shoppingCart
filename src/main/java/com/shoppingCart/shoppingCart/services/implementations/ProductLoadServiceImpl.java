package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.models.ProductLoad;
import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.repositories.ProductLoadRepository;
import com.shoppingCart.shoppingCart.repositories.ProductRepository;
import com.shoppingCart.shoppingCart.repositories.ShoppingCartRepository;
import com.shoppingCart.shoppingCart.services.ProductLoadService;
import com.shoppingCart.shoppingCart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductLoadServiceImpl implements ProductLoadService {
    @Autowired
    public ProductLoadRepository productLoadRepository;
    @Autowired
    public ShoppingCartService shoppingCartService;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ResponseEntity<Object> add(Long productId, Integer amount, Long shoppingCartId){
        ShoppingCart shoppingCart=shoppingCartRepository.findById(shoppingCartId).get();
        ProductLoad productLoad= new ProductLoad(productRepository.findById(productId).get(), amount, shoppingCart);
        productLoadRepository.save(productLoad);
        shoppingCart.addProductLoad(productLoad);
        shoppingCartRepository.save(shoppingCart);


        return new ResponseEntity<>("añadido", HttpStatus.CREATED);
    }
    @Override
    public void setAmount(Long id, Integer amount){
        ProductLoad productLoad = productLoadRepository.findById(id).get();
        productLoad.setAmount(productLoad.getAmount()+amount);
    }
    @Override
    public void remove(Long id){
        ProductLoad productLoad = productLoadRepository.findById(id).get();
        shoppingCartService.remove(productLoad.getShoppingCart(), productLoad);
        //productLoad.setShoppingCart(null);

       productLoadRepository.delete(productLoad);

    }


}
