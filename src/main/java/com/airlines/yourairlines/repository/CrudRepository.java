package com.airlines.yourairlines.repository;

import com.airlines.yourairlines.annotation.Table;
import com.airlines.yourairlines.dto.LongIdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

/**
 * Абстрактный CRUD репозиторий
 */

public abstract class CrudRepository<T extends LongIdDto> implements ICrudRepository<T> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    abstract RowMapper<T> getMapper();

    abstract PreparedStatementCreator getPreparedStatementCreator(T dtoToSave);

    public Class<T> classType;

    public CrudRepository(Class<T> classType) {
        this.classType = classType;
    }


    @Override
    public T save(T dtoToSave) {
        jdbcTemplate.update(getPreparedStatementCreator(dtoToSave));
        return dtoToSave;
    }

    @Override
    public T update(T dtoToUpdate) {
        jdbcTemplate.update(getPreparedStatementCreator(dtoToUpdate));
        return dtoToUpdate;
    }

    @Override
    public T findOne(Long id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, getMapper(), id);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE id = ?", id);
    }

    private String getTableName() {
        Table annotation = classType.getAnnotation(Table.class);
        return annotation.tableName();
    }

}
