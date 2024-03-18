package jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class JDBCFirst {

	public static void main(String[] args) {

		// 접속을 위한 기본 설정을 문자열로 세팅
		String dbid = "hr";
		String dbpw="hr";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		Scanner scanner =  new Scanner(System.in);
		
//		String name, phone, addr;
//		
//		System.out.print("이름 입력 : ");
//		name = scanner.nextLine();
//		System.out.print("전화번호 입력 : ");
//		phone = scanner.nextLine();
//		System.out.print("주소 입력 : ");
//		addr = scanner.nextLine();
		
		String name = "손오공";
		int age = 25;
		boolean isMarried = false;
		String birthday = "95/5/4";
		double height = 181.4;
		
		
		
		Connection conn = null;  // 연결
		PreparedStatement pstmt = null; // 명령을 실행하기 위한 객체, 문장임을 전달해줘야한다. => try문에서 넣어줌
//		String query = "insert into my_table values (?,?,?)";
		
		String query="""
				insert into friend
				values
				(
					friend_seq.nextval
					, ?
					, ?
					, ?
					, ?
					, ?
				)
				"""; // 다중행 문자열 -> """ 엔터
				// 밑에 """ 보다 들여쓰기 하면 안됨. 들여쓴만큼 공백 처리 됨
		System.out.println(query);
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, dbid, dbpw);
			System.out.println("DB 접속 성공");
			
			pstmt = conn.prepareStatement(query); // 쿼리 문장 준비
			
			pstmt.setString(1, name);
			pstmt.setInt(2,age);
			pstmt.setBoolean(3, isMarried);
			pstmt.setString(4, birthday);
			pstmt.setDouble(5, height);
			
			int result = pstmt.executeUpdate(); // 쿼리문 실제로 실행됨
			
			System.out.println(result+"개 저장 완료");
			pstmt.close();
			conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		
		
	}

}
