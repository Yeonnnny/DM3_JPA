package jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCThird {
	// Friend 정보를 전체 조회
	
	public static void main(String[] args) {
		// 접속을 위한 기본 설정을 문자열로 세팅
			String dbid = "hr";
			String dbpw="hr";
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
			Connection conn = null;  // 연결
			PreparedStatement pstmt = null; // 명령을 실행하기 위한 객체, 문장임을 전달해줘야한다. => try문에서 넣어줌

			String query = "select * from friend\r\n"+"order by seq";
			
			try {
				Class.forName(driver);
				conn=DriverManager.getConnection(url, dbid, dbpw);
				System.out.println("DB 접속 성공");
				
				pstmt = conn.prepareStatement(query); // 쿼리 문장 준비

				ResultSet result = pstmt.executeQuery(); // 쿼리문 실제로 실행됨
				
				while(result.next()) {
					int seq = result.getInt("seq");
					String name = result.getString("fname");
					int age = result.getInt("age");
					boolean isMarried = result.getBoolean("is_married");
					String birthday = result.getString("birthday");
					int height = result.getInt("height");
					
					StringBuffer buff = new StringBuffer();
					
					buff.append(seq).append(", ")
						.append(name).append(", ")					
						.append(age).append(", ")
						.append(isMarried).append(", ")
						.append(birthday).append(", ")
						.append(height).append(", ");
					
					System.out.println(buff.toString());
				}
				
				System.out.println("\n끝");
				pstmt.close();
				conn.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("DB 접속 실패");
				e.printStackTrace();
			}
				
		
	}

}
