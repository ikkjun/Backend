package com.website.login.dao;

import com.website.login.UserDto;

public interface UserDao {
    UserDto select(String id) throws Exception;
}