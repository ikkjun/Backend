package com.website.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionTest {
    public static void main(String[] args) throws Exception {
        // 1. DB에 접속하기 위한 계정과 URL
        // 스키마의 이름(springbasic)이 다른 경우 알맞게 변경해야 함
        String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8";

        // DB의 userid와 pwd를 알맞게 변경해야 함
        String DB_USER = "root";
        String DB_PASSWORD = "1234";

        // 2. DriverManager를 이용해서 연결 정보를 주고, 커넥션을 얻어온다.
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 얻는다.

        // 3. 연결된 DB에 sql 명령을 내리려면 Statement가 필요
        Statement stmt  = conn.createStatement(); // Statement를 생성한다.

        String query = "SELECT now()"; // 시스템의 현재 날짜시간을 출력하는 쿼리(query)
        // 위의 쿼리를 실행한 결과를 ResultSet에 담는다.
        ResultSet rs = stmt.executeQuery(query); // query를 실행한 결과를 rs에 담는다.

        // 실행결과가 담긴 rs에서 한 줄씩 읽어서 출력
        while (rs.next()) {
            String curDate = rs.getString(1);  // 읽어온 행의 첫번째 컬럼의 값을 String으로 읽어서 curDate에 저장
            System.out.println(curDate);       // 2022-01-11 13:53:00.0
        }
    } // main()
}

/* [실행결과]
2022-01-11 13:53:00.0
*/