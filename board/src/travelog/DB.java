package travelog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DB {
	public void select() {
		System.out.println("DB조회");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM board"); 
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			while(rs.next()) {
				System.out.print("[게시판번호:" + rs.getInt("board_no") + "] ");
				System.out.print("카테고리:" + rs.getString("board_category") + " ");
				System.out.print("작성자:" + rs.getString("board_writer") + " ");
				System.out.print("제목:" + rs.getString("board_title") + " ");
				System.out.println();
			}
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void cateSelect(String cate) {
		System.out.println("CATEGORY SELECT 조회");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM board WHERE board_category = ?");
			pstmt.setString(1,cate);
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			if (!rs.isBeforeFirst()) {
		        // rs.isBeforeFirst()는 결과 집합에 데이터가 있는지 여부를 확인합니다.
		        System.out.println("조회되는 내용이 없습니다. 카테고리를 다시 입력 해주세요");
		    } else {
				while(rs.next()) {
					System.out.print("[게시판번호:" + rs.getInt("board_no") + "] ");
					System.out.print("카테고리:" + rs.getString("board_category") + " ");
					System.out.print("작성자:" + rs.getString("board_writer") + " ");
					System.out.print("제목:" + rs.getString("board_title") + " ");
					System.out.println();
				}
		    }
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean detail(int boardNum) {
		System.out.println("DETAIL PAGE");
		try {
			Connection con = DriverManager.getConnection(INFO.JDBC_URL, INFO.USERNAME, INFO.PASSWORD);
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM board WHERE board_no = ?");
			pstmt.setInt(1,boardNum);
			ResultSet rs = pstmt.executeQuery(); // 반환값을 넣을곳이 필요하다.
			
			if (!rs.isBeforeFirst()) {
				// rs.isBeforeFirst()는 결과 집합에 데이터가 있는지 여부를 확인합니다.
				return false;
			} else {
				while(rs.next()) {
					System.out.print("[게시판번호:" + rs.getInt("board_no") + "] ");
					System.out.print("카테고리:" + rs.getString("board_category") + " ");
					System.out.print("작성자:" + rs.getString("board_writer") + " ");
					System.out.print("제목:" + rs.getString("board_title") + " ");
					System.out.print("내용:" + rs.getString("board_contents") + " ");
					System.out.print("날짜:" + rs.getString("board_date") + " ");
					System.out.println();
				}
			}
			System.out.println("조회완료");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
