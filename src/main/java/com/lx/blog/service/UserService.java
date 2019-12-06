package com.lx.blog.service;

import com.lx.blog.pojo.User;


public interface UserService {
    User checkUser(String username,String password);
}
