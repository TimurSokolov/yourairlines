package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.annotation.Table;
import com.airlines.yourairlines.dto.User;
import com.airlines.yourairlines.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class UserRepository<T extends User> extends CrudRepository<T> implements IUserRepository<T> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserRepository(Class<T> classType) {
        super(classType);
    }

    public T findUserByLogin(String login) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE login = ?";
        try {
            return jdbcTemplate.queryForObject(sql, getMapper(), login);
        } catch (RuntimeException e) {
            throw new NotFoundException("Объект не найден");
        }
    }

    private String getTableName() {
        Table annotation = classType.getAnnotation(Table.class);
        return annotation.tableName();
    }

}
