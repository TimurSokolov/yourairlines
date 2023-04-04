package com.airlines.yourairlines.mapper;

import com.airlines.yourairlines.dto.ClientDto;
import com.airlines.yourairlines.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClientMapper implements EntityMapper<Client, ClientDto> {
    @Override
    public abstract Client mapToEntity(ClientDto clientDto);

    @Override
    public abstract ClientDto mapToDto(Client client);

}
