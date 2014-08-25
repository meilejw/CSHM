/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dlut.smart.service;

/**
 *
 * @author jerry
 */
import org.springframework.beans.factory.annotation.Autowired;
import com.dlut.smart.dao.UserDAO;
import com.dlut.smart.module.User;

public class UserService {
    @Autowired
    private UserDAO userDao;
    
    public boolean verifyUser(String user_name,String password){
        int result = userDao.getMatchCount(user_name, password);
        return result > 0;
    }
    
}
