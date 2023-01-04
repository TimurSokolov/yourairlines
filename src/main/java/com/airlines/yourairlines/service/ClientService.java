package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.Client;
import com.airlines.yourairlines.repository.IClientRepository;
import com.airlines.yourairlines.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends UserService<Client> implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public IUserRepository<Client> getRepository() {
        return clientRepository;
    }

    @Override
    protected void validate(Client dto) {
    }


}
