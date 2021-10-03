package khs.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import khs.common.db.JDBCTemplate;
import khs.common.encrypt.Encrypter;
import khs.common.exception.DataAccessException;
import khs.search.model.dto.Member;


public class SearchDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public String searchUserId(Member member, Connection conn) {
		
		PreparedStatement pstm = null;
		String result = null;
		ResultSet rset = null;

		try {
			String query = "SELECT USER_ID FROM MEMBER WHERE EMAIL = ? AND BIRTH_DATE = ? AND NAME = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, member.getEmail());
			pstm.setDate(2, member.getBirthDate());
			pstm.setString(3, member.getName());
			rset = pstm.executeQuery();
			while (rset.next()) {
				result = rset.getString(1);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return result;
	}

	public String searchUserPassword(String userId, Connection conn) {
		
		PreparedStatement pstm = null;
		String result = null;
		ResultSet rset = null;

		try {
			String query = "SELECT PASSWORD FROM MEMBER WHERE USER_ID = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			while (rset.next()) {
				result = rset.getString(1);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return result;
	}

	public int changePassword(String password, String firstPassword, Connection conn) {
		PreparedStatement pstm = null;
		int result = 0;

		try {
			String query = "UPDATE MEMBER SET PASSWORD = ? WHERE PASSWORD = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, password);
			pstm.setString(2, firstPassword);
			result = pstm.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return result;
	}

}
