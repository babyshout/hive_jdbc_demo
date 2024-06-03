package org.example.hive_jdbc_demo.hive;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest {
    public static void main(String[] args) throws java.sql.SQLException{
        Connection conn = null;

        try {
            // Hive 에 접속하기 위한 드라이버 파일 로드
            Class.forName("org.apache.hive.jdbc.HiveDriver");

            // Hive 접속하기
            conn = DriverManager.getConnection("jdbc:hive2://192.168.72.129:10000/hivedb",
                    "hadoop", "1234");

            System.out.println("Hive 접속 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("Hive 접속 실패");
            System.out.println("org.apache.hive.jdbc.HiveDriver 파일을 찾을 수 없습니다.");
            System.out.println("이유 : " + e);

        } finally {
            if (conn != null)
                conn.close();

        }
    }
}
