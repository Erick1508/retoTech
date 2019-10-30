package com.reto.tech.facade;


import com.reto.tech.domain.entities.Client;
import com.reto.tech.domain.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
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


    public Map getAgeAverage() {
        List<Client> listClient = clientService.getAllClient();
        float sumAge = 0;
        for(Client client: listClient){
            sumAge += client.getAge();
        }
        Map map = new LinkedHashMap();
        float average = listClient.isEmpty() ? 0 : (sumAge/listClient.size());
        float sumAgeAverage= 0;
        for(Client client: listClient){
            sumAgeAverage +=  (float) Math.pow(client.getAge()-average, 2);
        }
        float desStandard = (float) Math.pow(sumAgeAverage/listClient.size(), 0.5);
        map.put("Promedio de edades", average);
        map.put("Desviación estándar de edades", desStandard);
        return map;
    }
}
