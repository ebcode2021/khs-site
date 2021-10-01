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
	
	
	
	
	
	
	
	
	
}