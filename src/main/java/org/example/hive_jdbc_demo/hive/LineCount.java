package org.example.hive_jdbc_demo.hive;

import org.example.hive_jdbc_demo.hive.conn.HiveConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LineCount {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        assert conn != null;
//        System.out.println(assert conn == null;);

        try {
            conn = HiveConn.getDBConnection();

            // Hive 실행을 위한 SQL 객체
            PreparedStatement preparedStatement = null;

            // Hive 의 commedies 데이터의 전체 라인수 계산하기
            String sql = "select count(line_data) as cnt from hivedb.comedies";

            // SQL 문자열을 Hive 로 실행할수 있는 SQL 쿼리로 변환하기
            preparedStatement = conn.prepareStatement(sql);

            // 쿼리 실행 후, 결과 가져오기
            ResultSet rs = preparedStatement.executeQuery();

            // Count 함수를 수행했기 때문에 반드시 결과값은 1개 레코드 나옴
            // 데이터가 없어도 0이 출력됨
            if (rs.next()) {
                // select 조회 결과를 가져오기
                String cnt = rs.getString("cnt");

                // select 조회 결과를 출력하기
                System.out.println("cnt : " + cnt);
            }
            preparedStatement = null;
        } catch (Exception e) {
            System.out.println("에러 발생 : " + e);
        } finally {
            assert conn != null;
            HiveConn.dbClose(conn);
        }
    }
}
