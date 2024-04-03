package com.website.login.dao;

import com.website.login.BoardDto;
import com.website.login.UserDto;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // ac
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}) // ac 설정 파일
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) // ac 설정 파일
public class UserDaoImplTest extends TestCase {
    @Autowired
    UserDao userDao;

    @Test
    public void linkTest() throws Exception {
        System.out.println("userDao = " + userDao);
        assertTrue(userDao != null);
    }

    @Test
    public void select() throws Exception {

        UserDto userDto = userDao.select("qwer");
        System.out.println("userDto = " + userDto);
        assertTrue(userDto.getId().equals("qwer"));
    }
}