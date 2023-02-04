package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.AuthenticationDto;
import com.airlines.yourairlines.dto.Employee;
import com.airlines.yourairlines.dto.EmployeeDetails;
import com.airlines.yourairlines.service.EmployeeDetailsContextService;
import com.airlines.yourairlines.service.IEmployeeService;
import com.airlines.yourairlines.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeAuthenticationController extends UserAuthenticationController<Employee, EmployeeDetails> {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private EmployeeDetailsContextService employeeDetailsContextService;

    public EmployeeAuthenticationController() {
        super(Employee.class);
    }

    @Override
    public IUserService<Employee, EmployeeDetails> getService() {
        return employeeService;
    }

    @Override
    public EmployeeDetails getUserDetailsContextService() {
        return employeeDetailsContextService.getEmployeeDetails();
    }

    @Override
    @PostMapping("/register")
    public boolean register(AuthenticationDto authenticationDto) {
        return employeeService.register(authenticationDto);
    }

    @Override
    @PutMapping("/login")
    public boolean login(AuthenticationDto authenticationDto) {
        return employeeService.login(authenticationDto);
    }
}
