package com.shoppingCart.shoppingCart.controllers;

import com.shoppingCart.shoppingCart.dtos.ClientCreateDTO;
import com.shoppingCart.shoppingCart.dtos.ClientDTO;
import com.shoppingCart.shoppingCart.services.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ClientController {

    @Autowired
    public ClientService clientService;


    @ApiOperation(value = "Obtiene todos los clientes activos. Requiere permiso de admin")
    @GetMapping("/api/admin/clients")
    public Set<ClientDTO> getClients() {
        return clientService.getClients();
    }

    @ApiOperation(value = "obtiene todos los clientes. Requiere permiso de admin")
    @GetMapping("/api/admin/clients/all")
    public Set<ClientDTO> getClientsAll() {
        return clientService.getClientsAll();
    }


    @ApiOperation(value = "registrarse como cliente")

    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "Informacion faltante"),
            @ApiResponse(code = 201, message = "cliente creado")
    })

    @PostMapping("/api/clients")
    public ResponseEntity<Object> register(@RequestParam
                                           @ApiParam(name = "firstName", value = "Primer nombre del cliente", example = "Agostina")
                                           String firstName, @RequestParam
                                           @ApiParam(name = "lastName", value = "Apellido del cliente", example = "Macchi")
                                           String lastName, @RequestParam
                                           @ApiParam(name = "email", value = "Mail del cliente", example = "agosmac@hotmail.com") String email, @RequestParam @ApiParam(name = "password", value = "Contraseña del cliente") String password, @RequestParam @ApiParam(name = "adress", value = "Direccion del cliente", example = "Av. Siempreviva")
                                           String address) {
        return clientService.register(firstName, lastName, email, password, address);
    }

    @ApiOperation(value = "editar datos de cliente")
    @PatchMapping("/api/clients/{id}")
    public void update(@PathVariable Long id, @RequestBody ClientCreateDTO clientCreateDTO) {
        clientService.update(id, clientCreateDTO);
    }

    @ApiOperation(value = "Anular/activar cliente. Requiere permiso de admin")
    @PatchMapping("/api/admin/clients/setstatus/{id}")
    public void setStatus(@PathVariable
                          @ApiParam(name = "id", value = "id del cliente", example = "1")
                          Long id) {
        clientService.setStatus(id);
    }

    @ApiOperation(value = "validar cuenta")
    @GetMapping("/api/validarCuenta/{id}")
    public void validation(@PathVariable
                           @ApiParam(name = "id", value = "id del cliente", example = "1")
                           Long id) {
        clientService.validation(id);
    }


}
