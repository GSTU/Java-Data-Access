package com.nesterione.gstu.jdbc.DBL;

import com.nesterione.gstu.jdbc.Entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by igor on 08.11.2014.
 */
public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("userName"));
        user.setUserLogin(resultSet.getString("userLogin"));
        user.setUserPassword(resultSet.getString("userPassword"));

        return user;
    }
}