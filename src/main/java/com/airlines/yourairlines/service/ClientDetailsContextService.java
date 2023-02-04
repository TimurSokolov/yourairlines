package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.ClientDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Getter
@Setter
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ClientDetailsContextService extends UserDetailsContextService<ClientDetails> implements IClientDetailsContextService {

    private ClientDetails clientDetails;

}
