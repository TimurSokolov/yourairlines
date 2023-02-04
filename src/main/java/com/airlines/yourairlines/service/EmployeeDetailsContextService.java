package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.EmployeeDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Setter
@Getter
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EmployeeDetailsContextService extends UserDetailsContextService<EmployeeDetails> implements IEmployeeDetailsContextService {


    private EmployeeDetails employeeDetails;
}
