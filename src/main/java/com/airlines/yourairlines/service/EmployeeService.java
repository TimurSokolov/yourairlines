package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.Employee;
import com.airlines.yourairlines.repository.IEmployeeRepository;
import com.airlines.yourairlines.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends UserService<Employee> implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    protected void validate(Employee dto) {

    }

    @Override
    public IUserRepository<Employee> getRepository() {
        return employeeRepository;
    }
}
