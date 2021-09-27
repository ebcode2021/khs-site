package khs.login.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.login.model.dto.Member;

public class MemberDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Member memberAuthenticate(String userId, String password, Connection conn) {
		Member member = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select * from member inner join lecture using(kh_code)"+
						" where user_id =? and password = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, password);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				member = convertAllToMember(rset);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		
		return member;
		
	}

	private Member convertAllToMember(ResultSet rset) throws SQLException {
		Member member = new Member();
		member.setUserId(rset.getString("user_Id"));
		member.setPassword(rset.getString("password"));
		member.setEmail(rset.getString("email"));
		member.setGrade(rset.getString("grade"));
		member.setRegDate(rset.getDate("reg_date"));
		member.setName(rset.getString("name"));
		member.setNickname(rset.getString("nickname"));
		member.setBirthDate(rset.getDate("birth_date"));
		member.setIsLeave(rset.getInt("is_leave"));
		member.setFinalDate(rset.getDate("start_date"));
		member.setStartDate(rset.getDate("start_date"));
		return member;
	}

	


}
