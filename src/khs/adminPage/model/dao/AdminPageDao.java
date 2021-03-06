package khs.adminPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khs.common.code.BoardSection;
import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.adminPage.model.dto.AdminPage;
import khs.board.model.dto.Board;

public class AdminPageDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	// 어드민게시판 : 회원정보조회 게시판 조회하기 기능
	// 어드민게시판 : 차단된 회원 관리 게시판 조회하기 기능
	public List<AdminPage> AdminPageMember(Connection conn) {
		PreparedStatement pstm = null;
		List<AdminPage> AdminPageMemberBox = new ArrayList<>();
		AdminPage adminPage = null;
		ResultSet rset = null;
		String query = "select * from member order by USER_ID asc";
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				//System.out.println(adminPage);
				adminPage = convertAllToAdminPage(rset);
				AdminPageMemberBox.add(adminPage);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		return AdminPageMemberBox;
	}
	
	
	// 어드민게시판 : 차단된 회원 관리
	// B02으로 변경 / 1일 차단
	public int memberBanGrade01(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update MEMBER set BAN_GRADE = 'B02', BAN_DATE = SYSDATE+1 where USER_ID = ?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}
	
	// 어드민게시판 : 차단된 회원 관리
	// B03으로 변경 / 7일 차단
	public int memberBanGrade02(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update MEMBER set BAN_GRADE = 'B03', BAN_DATE = SYSDATE+7 where USER_ID = ?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}

	// 어드민게시판 : 차단된 회원 관리
	// B04으로 변경 / 영구 차단
	public int memberBanGrade03(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update MEMBER set BAN_GRADE = 'B04', BAN_DATE = '2099/12/30' where USER_ID = ?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}

	// 어드민게시판 : 차단된 회원 관리
	// B01으로 변경 / 차단 해제
	public int memberBanGrade04(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update MEMBER set BAN_GRADE = 'B01', BAN_DATE = SYSDATE-1 where USER_ID = ?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}
	
	
	

	
	public int userGradeLV01(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update MEMBER set GRADE = 'LV01' where USER_ID = ?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}

	public int userGradeLV02(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update MEMBER set GRADE = 'LV02' where USER_ID = ?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}
	
	
	
	
	// 어드민게시판 : 회원정보조회 게시판
	// 어드민게시판 : 차단된 회원 관리 게시판
	private AdminPage convertAllToAdminPage(ResultSet rset) throws SQLException  {
		AdminPage adminPage = new AdminPage();
		adminPage.setUserId(rset.getString("USER_ID"));
		adminPage.setKhCode(rset.getString("KH_CODE"));
		adminPage.setBanGrade(rset.getString("BAN_GRADE"));
		adminPage.setPassword(rset.getString("PASSWORD"));
		adminPage.setEmail(rset.getString("EMAIL"));
		adminPage.setGrade(rset.getString("GRADE"));
		adminPage.setRegDate(rset.getDate("REG_DATE"));
		adminPage.setName(rset.getString("NAME"));
		adminPage.setNickname(rset.getString("NICKNAME"));
		adminPage.setBirthDate(rset.getDate("BIRTH_DATE"));
		adminPage.setBanDate(rset.getDate("BAN_DATE"));
		adminPage.setIsLeave(rset.getInt("IS_LEAVE"));
		adminPage.setVariFile(rset.getString("VARI_FILE"));
		return adminPage;
	}
	
	
	
	// 어드민게시판 : 자유게시판 조회하기 기능
	public List<Board> boardSelect(Connection conn) {
		PreparedStatement pstm = null;
		List<Board> boardSelectBox = new ArrayList<>();
		Board board = null;
		ResultSet rset = null;
		String query = "select * from BOARD order by BD_IDX DESC";
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				//System.out.println(adminPage);
				board = convertAllToBoard(rset);
				boardSelectBox.add(board);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset, pstm);
		}
		return boardSelectBox;
	}
	
	// 어드민게시판 : 자유게시판 블라인드 기능 *******
	public int bdIdxDelete(Connection conn, String bdIdxDelete) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update BOARD set BD_IS_BLIND = 1 where BD_IDX=?"; 
		// 게시글 번호가 ?인 글의 값을 1로 변경하여 조회되지 않도록 하는 쿼리
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bdIdxDelete);
			
			res = pstm.executeUpdate();
			System.out.println(res); //1
			
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}
	
	public int bdIdxRollBack(Connection conn, String bdIdxRollBack) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update BOARD set BD_IS_BLIND = 0 where BD_IDX=?"; 
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bdIdxRollBack);
			
			res = pstm.executeUpdate();
			System.out.println(res); //1
			
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		return res;
	}
	
	
	
	
	// 어드민게시판 : 자유게시판 조회하기 기능
	private Board convertAllToBoard(ResultSet rset) throws SQLException {
		Board board = new Board();
		board.setBdIdx(rset.getString("BD_IDX"));
		board.setUserId(rset.getString("USER_ID"));
		board.setRegDate(rset.getDate("REG_DATE"));
		board.setTitle(rset.getString("TITLE"));
		board.setContent(rset.getString("CONTENT"));
		board.setBdIsDel(rset.getInt("BD_IS_DEL"));
		board.setBdSection(rset.getString("BD_SECTION"));
		board.setBdIsBlind(rset.getInt("BD_IS_BLIND"));
		return board;
	}


	
	
	
	
	
	
}