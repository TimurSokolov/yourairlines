package com.airlines.yourairlines.controller;

import com.airlines.yourairlines.dto.EmployeeDto;
import com.airlines.yourairlines.entity.Employee;
import com.airlines.yourairlines.mapper.EmployeeMapper;
import com.airlines.yourairlines.mapper.EntityMapper;
import com.airlines.yourairlines.service.IEmployeeService;
import com.airlines.yourairlines.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends PersonController<Employee, EmployeeDto> {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public IPersonService<Employee> getService() {
        return employeeService;
    }

    @Override
    public EntityMapper<Employee, EmployeeDto> getMapper() {
        return employeeMapper;
    }
}
