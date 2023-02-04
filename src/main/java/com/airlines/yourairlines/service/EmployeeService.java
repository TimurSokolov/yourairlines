package com.airlines.yourairlines.service;

import com.airlines.yourairlines.dto.Employee;
import com.airlines.yourairlines.dto.EmployeeDetails;
import com.airlines.yourairlines.repository.IEmployeeRepository;
import com.airlines.yourairlines.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends UserService<Employee, EmployeeDetails> implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDetailsContextService employeeDetailsContextService;


    @Override
    public IUserRepository<Employee> getRepository() {
        return employeeRepository;
    }

    @Override
    public void setUserDetailsContextService(EmployeeDetails userDetails) {
        employeeDetailsContextService.setEmployeeDetails(userDetails);
    }

    @Override
    public Employee createNewUser() {
        return new Employee();
    }

    @Override
    public EmployeeDetails createUserDetails() {
        return new EmployeeDetails();
    }

    @Override
    protected void validate(Employee dto) {
    }
}
