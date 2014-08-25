/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import org.testng.Assert;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import com.dlut.smart.dao.UserDAO;
import com.dlut.smart.module.User;

/**
 *
 * @author jerry
 */
@ContextConfiguration(locations={"/WEB-INF/applicationContext.xml"})

public class UserServiceTest extends AbstractTestNGSpringContextTests{
    
    @Autowired 
    private UserDAO userDAO;
    
    @Test 
    public void findUserById(){
        User user = userDAO.getUserById(1);
        User user1 = new User("maggie","baijie1990",1);
        userDAO.addUser(user1);
        Assert.assertEquals(user.getUser_name(),"jiawei");
    }
    
}
