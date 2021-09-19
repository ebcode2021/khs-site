package khs.login.model.service;

import khs.common.db.JDBCTemplate;
import khs.login.model.dao.MemberDao;

public class MemberService {

	private MemberDao memberDao = new MemberDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

}
