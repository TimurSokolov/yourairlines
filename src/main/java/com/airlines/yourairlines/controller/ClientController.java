package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.Client;
import com.airlines.yourairlines.dto.ClientDetails;
import com.airlines.yourairlines.service.IClientService;
import com.airlines.yourairlines.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController extends UserController<Client, ClientDetails> {
    @Autowired
    private IClientService clientService;

    @Override
    public IUserService<Client, ClientDetails> getService() {
        return clientService;
    }


}
