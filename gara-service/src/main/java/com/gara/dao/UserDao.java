package com.gara.dao;


import com.gara.model.DonHangModel;
import com.gara.model.UserModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    UserModel getExistedUser(String username, String password);
}
