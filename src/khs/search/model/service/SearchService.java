package khs.search.model.service;

import java.sql.Connection;

import khs.common.db.JDBCTemplate;
import khs.search.model.dao.SearchDao;
import khs.search.model.dto.Member;


public class SearchService {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	private SearchDao searchDao = new SearchDao();
	
	public String searchUserId(Member member) {
		
		String result = null;
		Connection conn = template.getConnection();

		try {
			result = searchDao.searchUserId(member, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}

	public String searchUserPassword(String userId) {
		
		String result = null;
		Connection conn = template.getConnection();

		try {
			result = searchDao.searchUserPassword(userId, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}

	public int changePassword(String password, String firstPassword) {
		
		int result = 0;
		Connection conn = template.getConnection();

		try {
			result = searchDao.changePassword(password, firstPassword, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}

}
