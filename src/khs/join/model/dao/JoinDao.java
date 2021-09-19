package khs.join.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.join.model.dto.Member;
public class JoinDao {

	// 템플릿 불러오기, 코드 및 연결절차 간소화 
	JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	//*************2. 회원가입 DAO 구현 ******************
		public int insertMember(Member newMember, Connection conn) {
			
			PreparedStatement pstm = null; 
			int resultInt = 0;
				
			try {
				// 1. JDBC 드라이버 연결 
				// 2. Connection 생성, 오라클과 연결 
				// 3. Statement, 쿼리 실행 객채 생성

				System.out.println("1. 회원가입 Dao 진입확인");
				
				String query = "INSERT INTO MEMBER (USER_ID, PASSWORD, EMAIL, NAME, "
						+ "NICKNAME, BIRTH_DATE, KH_CENTER)"
						+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
				
				pstm = conn.prepareStatement(query);
				pstm.setString(1, newMember.getUserId());
				pstm.setString(2, newMember.getPassword());
				pstm.setString(3, newMember.getEmail());
				
				pstm.setString(4, newMember.getName());
				pstm.setString(5, newMember.getNickname());
				pstm.setDate(6, newMember.getBirthDate());
				pstm.setString(7, newMember.getKhCenter());
				
				System.out.println("2. 회원가입 Query 입력 확인");
				System.out.println(query);
				
				//4. DQL을 통해 성공여부를 반환받음, 성공시 UPDATE행갯수, 실패시 0 
				resultInt = pstm.executeUpdate();
				
			} catch (SQLException e) {
				//5. 예외 던지기 
				throw new DataAccessException(e);
			} finally {
				template.close(pstm);
			}
			return resultInt;
		}
	
	
}
