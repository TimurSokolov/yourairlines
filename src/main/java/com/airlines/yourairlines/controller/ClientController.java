package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.ClientDto;
import com.airlines.yourairlines.entity.Client;
import com.airlines.yourairlines.mapper.ClientMapper;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.service.IClientService;
import com.airlines.yourairlines.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends PersonController<Client, ClientDto> {
  @Autowired private IClientService clientService;
  @Autowired private ClientMapper clientMapper;

  @Override
  public IPersonService<Client> getService() {
    return clientService;
  }

  @Override
  public EntityMapper<Client, ClientDto> getMapper() {
    return clientMapper;
  }
}
