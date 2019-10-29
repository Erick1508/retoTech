package com.reto.tech.controller;

import com.reto.tech.domain.entities.Client;
import com.reto.tech.domain.dto.ClientDTO;
import com.reto.tech.facade.ApplicationFacade;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    private final ApplicationFacade applicationFacade;
    private final ModelMapper modelMapper = new ModelMapper();

    public ClientController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @PostMapping(value = "creacliente")
    public Map getError(@RequestBody ClientDTO client) {
        Client clientEntity = modelMapper.map(client, Client.class);
        return applicationFacade.sendClient(clientEntity);
    }

}
