package com.shoppingCart.shoppingCart.models;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native", strategy="native")
    @ApiModelProperty(notes = "Client ID", example =  "1", required = false)
    public Long id;
    @ApiModelProperty(notes = "Client First Name", example =  "Agostina", required = true)
    private String firstName;
    @ApiModelProperty(notes = "Client Last Name", example =  "Macchi", required = true)
    private String lastName;

    @Column(unique = true)
    @ApiModelProperty(notes = "Client Email", example =  "agosmac@hotmail.com", required = true)
    private String email;

    private String password;
    @ApiModelProperty(notes = "Client Adress", example =  "Av. Siempreviva", required = true)
    private String address;
    @ApiModelProperty(notes = "Client Status", example =  "true", required = true)
    private Boolean status;

    @OneToMany(mappedBy= "client", fetch = FetchType.EAGER)
    private Set<ShoppingCart> shoppingCartList = new HashSet<>();


    public Client() {
    }

    public Client(String firstName, String lastName, String email, String password, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.status = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<ShoppingCart> getShoppingCart() {
        return shoppingCartList;
    }

    public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
        this.shoppingCartList = shoppingCart;
    }

    public void addShoppingCart(ShoppingCart shoppingCart){
        shoppingCart.setClient(this);
        shoppingCartList.add(shoppingCart);
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
