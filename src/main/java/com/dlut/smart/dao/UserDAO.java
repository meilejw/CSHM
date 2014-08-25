/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dlut.smart.dao;

/**
 *
 * @author jerry
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.dlut.smart.module.User;
import org.springframework.jdbc.core.RowCallbackHandler;

@Repository
public class UserDAO {
    @Autowired 	
    private JdbcTemplate jdbcTemplate;
    
    public void addUser(final User user){
        final String sql = "INSERT INTO User(user_name,password,type) VALUES(?,?,?)";
        
		Object[] params = new Object[] { user.getUser_id(),user.getUser_name(),user.getPassword(),user.getType() };
        	KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUser_name());
				ps.setString(2, user.getPassword());
                                ps.setInt(3,user.getType());
				return ps;
			}
		}, keyHolder);
        user.setUser_id(keyHolder.getKey().intValue());
    }
    
    	public User getUserById(final int userId) {
		String sql = "SELECT * FROM User WHERE user_id=?";
		final User user= new User();

		jdbcTemplate.query(sql, new Object[] {userId},
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
                                            user.setUser_id(userId);
                                            user.setUser_name(rs.getString("user_name"));
                                            user.setPassword(rs.getString("password"));
                                            user.setType(rs.getInt("type"));
					}
				});
		return user;
	}
        
        public int getMatchCount(String user_name, String password){
            String sql = "SELECT COUNT(*) FROM USER WHERE user_name=? and password=?";
            return jdbcTemplate.queryForInt(sql, new Object[]{user_name,password});
        }
    
}
