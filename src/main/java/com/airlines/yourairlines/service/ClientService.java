package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Client;
import com.airlines.yourairlines.repository.IClientRepository;
import com.airlines.yourairlines.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends PersonService<Client> implements IClientService {
  @Autowired private IClientRepository clientRepository;

  @Override
  public IPersonRepository<Client> getRepository() {
    return clientRepository;
  }

  @Override
  protected void validate(Client entity) {}
}
