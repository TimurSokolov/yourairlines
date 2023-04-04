package com.airlines.yourairlines.service;

import com.airlines.yourairlines.entity.Employee;
import com.airlines.yourairlines.repository.IEmployeeRepository;
import com.airlines.yourairlines.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends PersonService<Employee> implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public IPersonRepository<Employee> getRepository() {
        return employeeRepository;
    }

    @Override
    protected void validate(Employee entity) {
    }
}
