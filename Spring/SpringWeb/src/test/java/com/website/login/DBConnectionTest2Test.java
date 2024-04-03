//package com.website.login;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Date;
//
//import static org.junit.Assert.assertTrue;
//
//// 하나의 ac를 만들어두고 재사용하기 때문에 성능에 이점이 있다.
//@RunWith(SpringJUnit4ClassRunner.class) // ac를 자동으로 만들어준다.
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
//public class DBConnectionTest2Test {
//    @Autowired
//    DataSource ds;  // 컨테이너로부터 자동 주입받는다.
//
//    @Test
//    public void insertUserTest() throws Exception {
//        Connection conn = ds.getConnection();   // 데이터베이스의 연결을 얻는다.
//
//        assertTrue(conn != null);
//    }
//
//    @Test
//    public void selectUserTest() throws Exception {
//        deleteAll();
//        User user = new User("asdf3", "1234", "abc", "aaa@aaa.com", new java.util.Date(), new java.util.Date());
//        int rowCont = insertUser(user);
//        User user2 = selectUser("asdf3");
//
//        assertTrue(user.getId().equals("asdf3"));
//    }
//
//    @Test
//    public void updateUserTest() throws Exception {
//        User user = new User("asdf3", "h", "h", "h", new java.util.Date(), new java.util.Date());
//        updateUser(user);
//        User user2 = selectUser(user.getId());
//
//        System.out.println("==============start=====================");
//        System.out.println("user.toString(): " + user.toString());
//        System.out.println("user2.toString(): " + user2.toString());
//
//        System.out.println("user.toString().equals(user2.toString())"+user.toString().equals(user2.toString()));
//
//        System.out.println("user.toString()=" + user.toString());
//        System.out.println("user2.toString()=" + user2.toString());
//
//        assertTrue(user.toString().equals(user2.toString()));
//
//    }
//
//    // 매개변수로 받은 사용자 정보로 user_info 테이블을 update하는 메서드
//    public int updateUser(User user) throws Exception {
//        // 1. DB 커넥션을 얻어온다.
//        Connection conn = ds.getConnection();
//
//        // 2. sql문 작성
////        update user_info set pwd = "9876", name = "바뀐다", email = "asdf@google.com", birth = "2000-07-22" where id = "qwer3";
//        String sql = "update user_info set pwd = ?, name = ?, email = ?, birth = ? where id = ?";
//        PreparedStatement pstms = conn.prepareStatement(sql);
//        pstms.setString(1, user.getPwd());
//        pstms.setString(2, user.getName());
//        pstms.setString(3, user.getEmail());
//        pstms.setDate(4, new java.sql.Date(user.getBirth().getTime()));
//        pstms.setString(5, user.getId());
//
//        // 3. sql문 실행
//        return pstms.executeUpdate();   // insert, update, delete
//    }
//
//    @Test
//    public void deleteUserTest() throws Exception {
//        int rowCnt = deleteUser("asdf");
//
//        assertTrue(rowCnt == 0);
//
//        User user = new User("asdf3", "1234", "abc", "aaa@aaa.com", new java.util.Date(), new java.util.Date());
//        rowCnt = insertUser(user);
//
//        assertTrue(rowCnt == 1);
//
//        rowCnt = deleteUser(user.getId());
//        assertTrue(rowCnt == 1);
//
//        assertTrue(selectUser(user.getId()) == null);
//    }
//
//    public int deleteUser(String id) throws Exception {
//        Connection conn = ds.getConnection();
//        String sql = "delete from user_info where id = ?";
//
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, id);
//
//        return pstmt.executeUpdate();
//    }
//
//    public User selectUser(String id) throws Exception {
//        Connection conn = ds.getConnection();
//
//        String sql = "select * from user_info where id = ?";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//        pstmt.setString(1, id);
//
//        ResultSet rs = pstmt.executeQuery();
//
//        // 쿼리 결과가 있으면 값을 채워서 반환한다.
//        if (rs.next()) {
//            User user = new User();
//            user.setId(rs.getString(1));
//            user.setPwd(rs.getString(2));
//            user.setName(rs.getString(3));
//            user.setEmail(rs.getString(4));
//            user.setBirth(new Date(rs.getDate(5).getTime()));
//            user.setReg_date(new Date(rs.getDate(6).getTime()));
//
//            return user;
//        }
//
//        return null;
//    }
//
//
//    private void deleteAll() throws Exception {
//        // 1. DataSource로부터 DB연결을 가져온다.
//        Connection conn = ds.getConnection();
//
//        // 2. sql문 작성
//        String sql = "delete from user_info where id = 'asdf3'";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        // 3. sql문 실행
//        pstmt.executeUpdate();
//    }
//
//    // 사용자 정보를 user_info 테이블에 저장하는 메서드
//    public int insertUser(User user) throws Exception {
//        // 1. DataSource로부터 DB연결을 가져온다
//        Connection conn = ds.getConnection();
//
//        // 2. sql문 작성
//        // insert user_info values ("qwer", "qwer", "qwer", "qwer@google.com", "1996-07-22");
//        String sql = "insert into user_info (id, pwd, name, email, birth) values (?, ?, ?, ?, ?)";
//        PreparedStatement pstmt = conn.prepareStatement(sql);
//
//        // ?에 해당하는 값 채우기
//        pstmt.setString(1, user.getId());
//        pstmt.setString(2, user.getPwd());
//        pstmt.setString(3, user.getName());
//        pstmt.setString(4, user.getEmail());
//        pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
//
//        // 3. sql문 실행
//        int rowCnt = pstmt.executeUpdate();
//
//        return rowCnt;
//    }
//
//    @Test
//    public void main() throws Exception {
//        Connection conn = ds.getConnection();
//        assertTrue(conn != null);
//    }
//}