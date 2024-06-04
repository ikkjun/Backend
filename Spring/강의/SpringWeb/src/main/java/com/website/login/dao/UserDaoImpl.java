package com.website.login.dao;

import com.website.login.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.website.login.dao.UserMapper.";

    @Override
    public UserDto select(String id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }
}