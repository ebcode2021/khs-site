package khs.myPage.model.service;

import java.security.MessageDigest;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import khs.common.db.JDBCTemplate;
import khs.login.model.dto.Member;
import khs.myPage.model.dao.MyPageDao;
import khs.myPage.model.dto.MyPage;

public class MyPageService {
	
	private MyPageDao myPageDao = new MyPageDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	
	public MyPage selectMyPage(String userId) {
		Connection conn = template.getConnection();
		MyPage myPage = null;
		
		try {
			myPage = myPageDao.selectMyPage(conn, userId);
		} finally {
			template.close(conn);
		}
		
		
		return myPage;
	}
	
	
	
	

	public int updateDetail(MyPage myPage) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = myPageDao.updateDetail(conn, myPage);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}





	public int changePassword(String userId, String newPassword) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = myPageDao.changePassword(conn, userId, newPassword);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}
	
	
	
	
	public MyPage nicknameDuplicatedTest(String newNickname) {
		Connection conn = template.getConnection();
		MyPage myPage = null;
		
		try {
			myPage = myPageDao.nicknameDuplicatedTest(conn, newNickname);
		} finally {
			template.close(conn);
		}
		
		return myPage;
		
	}
	
	
	
	public String getLoginMemberId(HttpServletRequest request) {
		Member member = (Member)request.getSession().getAttribute("authentication");
		String userId = member.getUserId();
		return userId;
	}
	
	

	
	
}
