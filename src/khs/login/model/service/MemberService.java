package khs.login.model.service;

import java.sql.Connection;

import khs.common.db.JDBCTemplate;
import khs.login.model.dao.MemberDao;
import khs.login.model.dto.Member;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public Member memberAuthenticate(String userId, String password) {
		Connection conn = template.getConnection();
		Member member = null;
		
		try {
			member = memberDao.memberAuthenticate(userId, password,conn);
		}finally {
			template.close(conn);
		}
		return member;
	}

	

	
}
