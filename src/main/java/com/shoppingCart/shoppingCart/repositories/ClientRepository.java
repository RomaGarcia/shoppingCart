package com.shoppingCart.shoppingCart.repositories;

import com.shoppingCart.shoppingCart.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByEmail(String email);

    Set<Client> findByStatus(boolean statusRequired);
}
