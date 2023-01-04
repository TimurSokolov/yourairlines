package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository extends UserRepository<Employee> implements IEmployeeRepository {
}
