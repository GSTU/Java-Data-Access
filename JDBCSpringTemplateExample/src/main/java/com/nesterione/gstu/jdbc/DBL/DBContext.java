package com.nesterione.gstu.jdbc.DBL;

import com.nesterione.gstu.jdbc.Entities.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 12.10.2014.
 */
public class DBContext implements Context<User> {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> getAll() {
        String SQL = "SELECT * FROM users";
        List <User> users = jdbcTemplateObject.query(SQL,
                new UserMapper());
        return users;
    }

    @Override
    public User get(int id) {
        //String SQL = "select * from Student where id = ?";
        //Student student = jdbcTemplateObject.queryForObject(SQL,
        //        new Object[]{id}, new StudentMapper());
        //return student;
        return null;
    }

    @Override
    public void create(User entity) {
        String SQL = "insert into users(userName, userLogin, userPassword) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL, entity.getUserName(), entity.getUserLogin(),entity.getUserPassword());
    }

    @Override
    public void remove(User entity) {
        // String SQL = "delete from Student where id = ?";
        // jdbcTemplateObject.update(SQL, id);
        // System.out.println("Deleted Record with ID = " + id );
    }

    @Override
    public void update(User entity) {
       //String SQL = "update Student set age = ? where id = ?";
       //jdbcTemplateObject.update(SQL, age, id);
       // System.out.println("Updated Record with ID = " + id );
    }
}

