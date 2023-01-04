package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository extends UserRepository<Client> implements IClientRepository {
}
