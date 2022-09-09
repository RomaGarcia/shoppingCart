package com.shoppingCart.shoppingCart.services.implementations;

import com.shoppingCart.shoppingCart.models.ShoppingCart;
import com.shoppingCart.shoppingCart.models.Ticket;
import com.shoppingCart.shoppingCart.repositories.TicketRepository;
import com.shoppingCart.shoppingCart.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket create(ShoppingCart shoppingCart, String wayToPay){
        Ticket ticket=new Ticket(LocalDate.now(), wayToPay, shoppingCart);

        ticketRepository.save(ticket);
        return ticket;
    }

}
