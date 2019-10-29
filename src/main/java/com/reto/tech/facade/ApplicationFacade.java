package com.reto.tech.facade;


import com.reto.tech.domain.entities.Client;
import com.reto.tech.domain.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Erick Marrero
 * @version 29/10/2019
 */
@Component
@Transactional
public class ApplicationFacade {

    private final ClientService clientService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ApplicationFacade(ClientService clientService) {
        this.clientService = clientService;
    }

    public Map sendClient(Client client) {
        Map map = new LinkedHashMap();

        map.put("birthday", client.getBirthday());
        map.put("nombre", client.getName());
        map.put("apellido", client.getLastName());
        map.put("edad", client.getAge());

        clientService.saveClient(client);

        return map;
    }



}
