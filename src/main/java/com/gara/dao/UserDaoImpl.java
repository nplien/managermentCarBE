package com.gara.dao;


import com.gara.model.DonHangModel;
import com.gara.model.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserModel getExistedUser(String username, String password) {
        UserModel user= null;
        try {
            String sql = "SELECT * " +
                    "FROM users " +
                    "WHERE username= ? " +
                    "AND password = ?";
            SqlParameterSource nameParameterSource = new MapSqlParameterSource("username", username);

            user = jdbcTemplate.queryForObject(sql,new Object[]{username,password},
                    (rs, rowNum) -> {
                        UserModel item = UserModel.builder()
                                .id(rs.getInt("id"))
                                .username(rs.getString("username"))
                                .type(rs.getString("type"))
                                .email(rs.getString("email"))
                                .build();
                        return item;
            });
        } catch (Exception e) {
            logger.error("getExistedUser fail", e);
        }
        return user;
    }
}