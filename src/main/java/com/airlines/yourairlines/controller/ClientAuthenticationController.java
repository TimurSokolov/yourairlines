package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.Client;
import com.airlines.yourairlines.dto.ClientDetails;
import com.airlines.yourairlines.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientAuthenticationController extends UserAuthenticationController<Client, ClientDetails> {
    @Autowired
    private IClientService clientService;

    @Autowired
    private ClientDetailsContextService clientDetailsContextService;

    public ClientAuthenticationController() {
        super(Client.class);
    }


    @Override
    public IUserService<Client, ClientDetails> getService() {
        return clientService;
    }

    @Override
    public ClientDetails getUserDetailsContextService() {
        return clientDetailsContextService.getClientDetails();
    }

    @Override
    @PostMapping("/register")
    public boolean register(AuthenticationDto authenticationDto) {
        return clientService.register(authenticationDto);
    }

    @Override
    public boolean login(AuthenticationDto authenticationDto) {
        return clientService.login(authenticationDto);
    }


}
