package khs.myPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.myPage.model.dto.MyPage;

public class MyPageDao {
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public MyPage selectMyPage(Connection conn, String userId) {
		MyPage myPage = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select * from member" + 
				" inner join lecture using(kh_code)" + 
				" inner join instructor using(instr_idx)" + 
				" where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				myPage = convertAllToMyPage(rset);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return myPage;
	}
	
	
	
	public int updateDetail(Connection conn, MyPage myPage) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update member set email=?, nickname=? where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, myPage.getEmail());
			pstm.setString(2, myPage.getNickName());
			pstm.setString(3, myPage.getUserId());
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	
		return res;
	}
	
	
	
	public int changePassword(Connection conn, String userId, String newPassword) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update member set password=? where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, newPassword);
			pstm.setString(2, userId);
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	
		return res;
	}
	
	
	public String nicknameDuplicatedTest(Connection conn, String newNickname) {
		PreparedStatement pstm = null; 
		String result = null;
		ResultSet rset = null; 
			
		try {
			String query = "SELECT NICKNAME FROM MEMBER WHERE NICKNAME = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, newNickname);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				result = rset.getString(1);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		return result;
	}


	

	//쿼리문으로 받아오는 속성 수 보다 아래 함수에서 저장하는 속성들이 더 많아지면, 오류남
	private MyPage convertAllToMyPage(ResultSet rset) throws SQLException {
		MyPage myPage = new MyPage();
		myPage.setUserId(rset.getString("user_id"));
		myPage.setKhCode(rset.getString("kh_code"));
		myPage.setBanGrade(rset.getString("ban_grade"));
		myPage.setPassword(rset.getString("password"));
		myPage.setEmail(rset.getString("email"));
		myPage.setGrade(rset.getString("grade"));
		myPage.setRegDate(rset.getDate("reg_date"));
		myPage.setName(rset.getString("name"));
		myPage.setNickName(rset.getString("nickname"));
		myPage.setBirthDate(rset.getDate("birth_date"));
		myPage.setIsLeave(rset.getInt("is_leave"));

		myPage.setKhCenter(rset.getString("kh_center"));
		myPage.setVariFile(rset.getString("vari_file"));
		myPage.setClassName(rset.getString("class_name"));
		myPage.setStartDate(rset.getDate("start_date"));
		myPage.setFinalDate(rset.getDate("final_date"));
		myPage.setInstrName(rset.getString("instr_name"));

		return myPage;
	}




	

}
