package khs.myPage.model.service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import khs.board.model.dao.BoardDao;
import khs.board.model.dto.Board;
import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.common.file.FileDTO;
import khs.login.model.dto.Member;
import khs.myPage.model.dao.MyPageDao;
import khs.myPage.model.dto.MyPage;
import khs.myPage.model.dto.ProfileImage;

public class MyPageService {
	private BoardDao boardDao = new BoardDao();
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
	
	
	
	
	public String nicknameDuplicatedTest(String newNickname) {
		Connection conn = template.getConnection();
		String result = null;
		
		try {
			result = myPageDao.nicknameDuplicatedTest(conn, newNickname);
		} finally {
			template.close(conn);
		}
		
		return result;
		
	}
	
	
	
	
	
	public List<Board> selectMyPost(String userId) {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.selectMyPost(conn, userId);
		} finally {
			template.close(conn);
		}

		return boardList;
	}

	
	
	public int deleteMyPost(String[] bdIdx) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = boardDao.deleteMyPost(conn, bdIdx);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}
	
	
	
	public List<Board> selectMyComment(String userId) {
		Connection conn = template.getConnection();
		List<Board> commentList = null;
		
		try {
			commentList = boardDao.selectMyComment(conn, userId);
		} finally {
			template.close(conn);
		}

		return commentList;
	}
	
	
	
	
	public int deleteMyComment(String userId, String[] cmtIdx) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = boardDao.deleteMyComment(conn, userId, cmtIdx);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}

	
	
	public int deleteAccount(String userId) {
		Connection conn = template.getConnection();
		int res = 0;
		
		try {
			res = myPageDao.deleteAccount(conn, userId);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		
		return res;
		
	}
	
	
	
	public void profileImageUpload(String userId, FileDTO fileDTO) {
		Connection conn = template.getConnection();
		
		try {
			//myPageDao.profileImageUploadMember(conn, userId, fileDTO);
			myPageDao.profileImageUpload(conn, userId, fileDTO);
			
			template.commit(conn);
		} catch(DataAccessException e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		
		
		
	}


	public ProfileImage profileImageDownload(String userId) {
		Connection conn = template.getConnection();
		ProfileImage profileImage = null;
		try {
			profileImage = myPageDao.profileImageDownload(conn, userId);
		} finally {
			template.close(conn);
		}
		
		return profileImage;
	}
	

	
	
	public int profileImageDelete(String userId) {
		int res = 0;
		Connection conn = template.getConnection();
		try {
			res = myPageDao.profileImageDelete(conn, userId);
			
			template.commit(conn);
		} catch(DataAccessException e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}
	
	



	
	
	
	public String getLoginMemberId(HttpServletRequest request) {
		Member member = (Member)request.getSession().getAttribute("authentication");
		String userId = member.getUserId();
		return userId;
	}



















	













	





	
	

	
	
}
