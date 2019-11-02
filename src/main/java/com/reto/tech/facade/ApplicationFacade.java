package com.reto.tech.facade;


import com.reto.tech.domain.entities.Client;
import com.reto.tech.domain.service.ClientService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.reto.tech.util.DateTimeUtil.getDateClient;
import static com.reto.tech.util.DateTimeUtil.getDateDie;
import static com.reto.tech.util.DateTimeUtil.getDateFormat;

/**
 * @author Erick Marrero
 * @version 29/10/2019
 */
@Component
@Transactional
public class ApplicationFacade {

    private final ClientService clientService;

    public ApplicationFacade(ClientService clientService) {
        this.clientService = clientService;
    }

    public Map sendClient(Client client) {
        Map map = new LinkedHashMap();
        client.setBirthday(getDateClient(client.getBirthday()));
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

    public List<Map> getAllClient(){

        List<Client> clients = clientService.getAllClient();
        List<Map> listClient = new LinkedList<>();
        for (Client client: clients){
            Map map = new LinkedHashMap();
            map.put("Nombre", client.getName());
            map.put("Apellido", client.getLastName());
            map.put("Edad", client.getAge());
            map.put("Fecha de nacimiento", getDateFormat(client.getBirthday()));
            map.put("Fecha probable de muerte", getDateDie(client.getBirthday()));
            listClient.add(map);
        }
        return listClient;
    }
}
