package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.Employee;
import com.airlines.yourairlines.dto.EmployeeDetails;
import com.airlines.yourairlines.service.IEmployeeService;
import com.airlines.yourairlines.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends UserController<Employee, EmployeeDetails> {
    @Autowired
    private IEmployeeService employeeService;

    @Override
    public IUserService<Employee, EmployeeDetails> getService() {
        return employeeService;
    }

}
