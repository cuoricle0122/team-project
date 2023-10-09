package org.teamproject.hotelreservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // MySQL 데이터베이스 연결을 위한 드라이버 로드
            Class.forName("com.mysql.jdbc.Driver");

            // 데이터베이스 연결 설정
            String url = "jdbc:mysql://localhost:3306/hotelProject";
            String username = "hotelProject";
            String password = "aA!123456";

            // 데이터베이스에 연결
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("데이터베이스에 성공적으로 연결되었습니다.");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 클래스를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 중 오류가 발생했습니다.");
        }
    }
}