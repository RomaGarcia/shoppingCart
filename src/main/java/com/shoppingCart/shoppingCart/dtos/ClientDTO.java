package com.shoppingCart.shoppingCart.dtos;

import com.shoppingCart.shoppingCart.models.Client;
import com.shoppingCart.shoppingCart.models.ShoppingCart;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

    private String status;

    private Set<ShoppingCartDTO> shoppingCartDTO = new HashSet<>();



    public ClientDTO(Client client) {
        this.firstName=client.getFirstName();
        this.lastName=client.getLastName();
        this.email= client.getEmail();
        this.address=client.getAddress();
        this.status= client.getStatus();
        this.shoppingCartDTO=client.getShoppingCart().stream().map(ShoppingCartDTO::new).collect(Collectors.toSet());

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ShoppingCartDTO> getShoppingCartDTO() {
        return shoppingCartDTO;
    }

    public void setShoppingCartDTO(Set<ShoppingCartDTO> shoppingCartDTO) {
        this.shoppingCartDTO = shoppingCartDTO;
    }
}
