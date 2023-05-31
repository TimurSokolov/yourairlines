package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends IPersonRepository<Client> {}
