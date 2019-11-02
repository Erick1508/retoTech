package com.reto.tech.controller;

import com.reto.tech.domain.entities.Client;
import com.reto.tech.domain.dto.ClientDTO;
import com.reto.tech.facade.ApplicationFacade;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    private final ApplicationFacade applicationFacade;
    private final ModelMapper modelMapper = new ModelMapper();

    public ClientController(ApplicationFacade applicationFacade) {
        this.applicationFacade = applicationFacade;
    }

    @ApiOperation(value = "Recibe los parámetros de Nombre, Apellido, edad y fecha de nacimiento" +
            "de un cliente y los almacena en Base de Datos", response = ClientDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente creado exitosamente", response = ClientDTO.class),
            @ApiResponse(code = 201, message = "Created", response = ClientDTO.class)})
    @PostMapping(value = "creacliente")
    public ClientDTO createClient(@ApiParam(value = "Crear un cliente, introducir edad, nombre, apellido y fecha de nacimiento", required = true) @RequestBody ClientDTO client, HttpServletResponse response) {
        Client clientEntity = modelMapper.map(client, Client.class);
        applicationFacade.sendClient(clientEntity);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return client;
    }

    @ApiOperation(value = "Obtiene el promedio y la desvación estándar de las edades de todos lo clientes",
            response = Map.class)
    @GetMapping(value = "kpideclientes")
    public Map getAgeAverage() {
        return applicationFacade.getAgeAverage();
    }

    @ApiOperation(value = "Lista de todos clientes mostrando sus datos, incluyendo su fecha probable de muerte",
            response = List.class)
    @GetMapping(value = "/listclientes")
    public List<Map> getAllClient() {
        return applicationFacade.getAllClient();
    }

}
