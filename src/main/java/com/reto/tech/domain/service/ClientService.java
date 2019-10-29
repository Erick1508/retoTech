package com.reto.tech.domain.service;

import com.reto.tech.domain.entities.Client;
import com.reto.tech.domain.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void saveClient(Client client){
        logger.info("Se cliente {} nacido en {}",
                client.getName(),
                client.getBirthday());
        try {
            clientRepository.save(client);
            clientRepository.flush();
        }catch (Exception e){
            logger.error("Error con {},  mensaje {}", client.getName(), e.getMessage());
        }
    }
}
