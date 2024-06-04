package com.website.login.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


/**
 * select
 *  1. 100개 생성 후 마지막 로우 선택
 * selectAll
 *
 * count
 * insert
 * deleteAll
 * delete
 * update
 */
@RunWith(SpringJUnit4ClassRunner.class) // ac
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) // ac 설정 파일
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) // ac 설정 파일

public class BoardDaoImplTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void linkTest() throws Exception {
        System.out.println("userDao = " + boardDao);
        assertTrue(boardDao != null);
    }

    @Test
    public void select() {
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void count() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void deleteAll() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}