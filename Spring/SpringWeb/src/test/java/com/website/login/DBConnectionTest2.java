package com.website.login;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;

import static org.junit.Assert.assertTrue;

public class DBConnectionTest2 {
    public static void main(String[] args) throws Exception {
        // 스키마의 이름(springbasic)이 다른 경우 알맞게 변경해야 함
        String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8";

        // DB의 userid와 pwd를 알맞게 변경해야 함
        String DB_USER = "root";
        String DB_PASSWORD = "1234";
        String DB_DRIVER = "com.mysql.jdbc.Driver";

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(DB_DRIVER);
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USER);
        ds.setPassword(DB_PASSWORD);

        Connection conn = ds.getConnection();   // 데이터베이스의 연결을 얻는다.

        System.out.println("conn = " + conn);
    } // main()
}