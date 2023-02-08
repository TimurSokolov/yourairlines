package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.Client;
import com.airlines.yourairlines.dto.ClientDetails;
import com.airlines.yourairlines.repository.IClientRepository;
import com.airlines.yourairlines.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends UserService<Client, ClientDetails> implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private ClientDetailsContextService clientDetailsContextService;


    @Override
    public IUserRepository<Client> getRepository() {
        return clientRepository;
    }

    @Override
    public void setUserDetailsContextService(ClientDetails userDetails) {
        clientDetailsContextService.setClientDetails(userDetails);
    }


    @Override
    public Client createNewUser() {
        return new Client();
    }


    @Override
    public ClientDetails createUserDetails() {
        return new ClientDetails();
    }

    @Override
    protected void validate(Client dto) {
    }


}
