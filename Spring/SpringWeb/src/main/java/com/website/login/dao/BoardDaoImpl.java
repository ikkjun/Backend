package com.website.login.dao;

import com.website.login.*;
import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.support.incrementer.HsqlMaxValueIncrementer;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.website.login.dao.BoardMapper.";

//    <select id="select" parameterType="int" resultType="BoardDto">
    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

    //    <select id="selectAll" resultType="BoardDto">
    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    //    <select id="count" resultType="int">
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    //    <insert id="insert" parameterType="BoardDto">
    @Override
    public int insert(BoardDto boardDto) throws Exception{
        return session.insert(namespace + "insert", boardDto);
    }

    //    <delete id="deleteAll">
    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    //    <delete id="delete" parameterType="int">
    @Override
    public int delete(Integer bno) throws Exception {
        return session.delete(namespace + "delete", bno);
    }

    //    <update id="update" parameterType="BoardDto">
    @Override
    public int update(BoardDto boardDto) throws Exception {
        return session.update(namespace + "update", boardDto);
    }
}