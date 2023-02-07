package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.annotation.Table;
import com.airlines.yourairlines.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class UserRepository<T extends User> extends CrudRepository<T> implements IUserRepository<T> {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Class<T> classType;

    public UserRepository(Class<T> classType) {
        super(classType);
    }

    public T findUserByLogin(String login) {
/*        for (T dto : database) {
            if (dto.getLogin().equalsIgnoreCase(login)) {
                return dto;
            }
        }*/
        String sql = "SELECT * FROM " + getTableName() + " WHERE login = ?";
        return jdbcTemplate.queryForObject(sql, getMapper(), login);
    }

    private String getTableName() {
        Table annotation = classType.getAnnotation(Table.class);
        return annotation.tableName();
    }
}
