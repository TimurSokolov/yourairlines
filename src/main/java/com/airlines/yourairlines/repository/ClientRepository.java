package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Client;
import com.airlines.yourairlines.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class ClientRepository extends UserRepository<Client> implements IClientRepository {
    @Autowired
    private ClientMapper clientMapper;


    public ClientRepository() {
        super(Client.class);
    }

    @Override
    RowMapper<Client> getMapper() {
        return clientMapper;
    }

    @Override
    PreparedStatementCreator getPreparedStatementCreator(Client dtoToSave) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        String stringForSqlQuery = stackTrace[3].getMethodName().compareTo("save") == 0 ?
                "INSERT INTO client (name, surname, login, password, phonenumber, email, cardnumber, homeairport) " +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)" :
                "UPDATE client SET name = ?, surname = ?, login = ?, password = ?, phonenumber = ?, " + "email = ?, " +
                        "cardnumber = ?, homeairport = ? WHERE id = " + dtoToSave.getId();
        return connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(stringForSqlQuery);

            preparedStatement.setString(1, dtoToSave.getName());
            preparedStatement.setString(2, dtoToSave.getSurname());
            preparedStatement.setString(3, dtoToSave.getLogin());
            preparedStatement.setString(4, dtoToSave.getPassword());
            preparedStatement.setString(5, dtoToSave.getPhoneNumber());
            preparedStatement.setString(6, dtoToSave.getEmail());
            preparedStatement.setString(7, dtoToSave.getCardNumber());
            preparedStatement.setString(8, dtoToSave.getHomeAirport());
            return preparedStatement;
        };
    }
}
