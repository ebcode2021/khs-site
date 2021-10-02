package khs.adminPage.model.service;

import java.sql.Connection;
import java.util.List;

import khs.common.db.JDBCTemplate;
import khs.adminPage.model.dao.AdminPageDao;
import khs.adminPage.model.dto.AdminPage;
import khs.board.model.dto.Board;



public class AdminPageService {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	private AdminPageDao adminPageDao = new AdminPageDao(); 
	
	
	// 어드민게시판 : 회원정보조회 게시판
	// 어드민게시판 : 차단된 회원 관리 게시판
	public List<AdminPage> adminPageService(){
		List<AdminPage> result = null;
		Connection conn = template.getConnection();
		try {
			result = adminPageDao.AdminPageMember(conn);
			template.commit(conn); 
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}
	
	
	// 관리자게시판 : 자유게시판 조회
	public List<Board> adminPageBoardService(){
		List<Board> result = null;
		Connection conn = template.getConnection();
		try {
			result = adminPageDao.boardSelect(conn);
			template.commit(conn); 
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}
	
	
	// 관리자게시판 : 게시글 블라인드 처리 *******
	public int boardBlind(String bdIdx) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = adminPageDao.boardBlind(conn, bdIdx);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}

	// 관리자게시판 : 회원 차단등급 변경
	public int memberBanGrade01(String userId) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = adminPageDao.memberBanGrade01(conn, userId);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}


	public int memberBanGrade02(String userId) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = adminPageDao.memberBanGrade02(conn, userId);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}


	public int memberBanGrade03(String userId) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = adminPageDao.memberBanGrade03(conn, userId);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}


	public int memberBanGrade04(String userId) {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = adminPageDao.memberBanGrade04(conn, userId);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}
	
	
	
	
	
}