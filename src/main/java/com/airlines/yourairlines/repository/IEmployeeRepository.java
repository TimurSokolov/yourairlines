package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends IPersonRepository<Employee> {}
