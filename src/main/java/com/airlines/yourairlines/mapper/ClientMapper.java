package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.Client;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Client client = new Client();

        client.setId(resultSet.getLong("id"));
        client.setName(resultSet.getString("name"));
        client.setSurname(resultSet.getString("surname"));
        client.setLogin(resultSet.getString("login"));
        client.setPassword(resultSet.getString("password"));
        client.setPhoneNumber(resultSet.getString("phonenumber"));
        client.setEmail(resultSet.getString("email"));
        client.setCardNumber(resultSet.getString("cardnumber"));
        client.setHomeAirport(resultSet.getString("homeairport"));

        return client;
    }
}
