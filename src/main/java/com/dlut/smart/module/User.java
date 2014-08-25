/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dlut.smart.module;

/**
 *
 * @author jerry
 */
public class User {
    private int user_id;
    private String user_name;
    private String password;
    private int type;

    public User() {
    }
    

    public User(int user_id, String user_name, String password, int type) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.type = type;
    }

    public User(String user_name, String password, int type) {
        this.user_name = user_name;
        this.password = password;
        this.type = type;
    }

    
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
    
}
