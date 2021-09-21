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
		String query = "select * from member where user_id = ?";
		
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

	

	
	private MyPage convertAllToMyPage(ResultSet rset) throws SQLException {
		MyPage myPage = new MyPage();
		myPage.setUserId(rset.getString("user_id"));
		myPage.setPassword(rset.getString("password"));
		myPage.setEmail(rset.getString("email"));
		myPage.setGrade(rset.getString("grade"));
		myPage.setRegDate(rset.getDate("reg_date"));
		myPage.setName(rset.getString("name"));
		myPage.setNickName(rset.getString("nickname"));
		myPage.setBirthDate(rset.getDate("birth_date"));
		myPage.setKhCenter(rset.getString("kh_center"));
		myPage.setIsLeave(rset.getInt("is_leave"));
		myPage.setIsBan(rset.getInt("is_ban"));
		
		return myPage;
	}





	

}
