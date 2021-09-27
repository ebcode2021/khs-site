package khs.join.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import khs.common.db.JDBCTemplate;
import khs.common.encrypt.Encrypter;
import khs.common.exception.DataAccessException;
import khs.join.model.dto.Member;

public class JoinDao {

	// 템플릿 불러오기, 코드 및 연결절차 간소화
	JDBCTemplate template = JDBCTemplate.getInstance();
	Encrypter encrypter = new Encrypter();

	public int insertMember(Member newMember, Connection conn) {

		PreparedStatement pstm = null;
		int resultInt = 0;
		
		
		try {
			String query = "INSERT INTO MEMBER (USER_ID, PASSWORD, EMAIL, NAME, " + "NICKNAME, BIRTH_DATE, KH_CODE, VARI_FILE)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, newMember.getUserId());
			pstm.setString(2, Encrypter.convertToSHA256(newMember.getPassword()));
			pstm.setString(3, newMember.getEmail());

			pstm.setString(4, newMember.getName());
			pstm.setString(5, newMember.getNickname());
			pstm.setDate(6, newMember.getBirthDate());
			pstm.setString(7, newMember.getKhCenter());
			pstm.setString(8, newMember.getVariFile());

			// DQL을 통해 성공여부를 반환받음, 성공시 UPDATE행갯수, 실패시 0
			resultInt = pstm.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		return resultInt;
	}

	public String checkNickName(String nickName, Connection conn) {

		PreparedStatement pstm = null;
		String result = null;
		ResultSet rset = null;

		try {
			String query = "SELECT NICKNAME FROM MEMBER WHERE NICKNAME = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, nickName);
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

	public String checkId(String userId, Connection conn) {

		PreparedStatement pstm = null;
		String result = null;
		ResultSet rset = null;

		try {
			String query = "SELECT USER_ID FROM MEMBER WHERE USER_ID = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			// 4. DQL을 통해 성공여부를 반환받음, 성공시 값 반환
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

	public String checkEmail(String email, Connection conn) {
		
		PreparedStatement pstm = null;
		String result = null;
		ResultSet rset = null;

		try {
			String query = "SELECT EMAIL FROM MEMBER WHERE EMAIL = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, email);
			// 4. DQL을 통해 성공여부를 반환받음, 성공시 값 반환
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
	
}
