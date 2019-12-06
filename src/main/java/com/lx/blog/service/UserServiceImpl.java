package com.lx.blog.service;

import com.lx.blog.dao.UserDao;
import com.lx.blog.pojo.User;
import com.lx.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user=userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
