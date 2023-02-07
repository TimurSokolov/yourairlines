package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.dto.Employee;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository extends UserRepository<Employee> implements IEmployeeRepository {
    public EmployeeRepository() {
        super(Employee.class);
    }

    @Override
    RowMapper<Employee> getMapper() {
        return null;
    }

    @Override
    PreparedStatementCreator getPreparedStatementCreator(Employee dtoToSave) {
        return null;
    }

}
