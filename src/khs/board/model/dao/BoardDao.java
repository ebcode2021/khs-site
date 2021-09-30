package khs.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khs.board.model.dto.Board;
import khs.common.code.BoardSection;
import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;


public class BoardDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	public List<Board> freeBoardMain(Connection conn) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;

		String query = "select * from board inner join member using(user_id) where bd_is_del=0 order by to_number(bd_idx) desc";
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();

			while(rset.next()) {
				Board board = convertAllToFreeBoardMain(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	public Board freeBoardDetail(Connection conn, String bdIdx) {
		Board board = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		String query = "select * from board inner join member using(user_id) where bd_is_del=0 AND bd_idx=?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bdIdx);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				board = convertAllToFreeBoardDetail(rset);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return board;
	}
	
	
	
	
	public List<Board> freeBoardDetailComment(Connection conn, String bdIdx) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;

		String query = "select * from board_comment inner join member using(user_id) where cmt_is_del=0 AND bd_idx=?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bdIdx);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				Board board = convertAllToFreeBoardDetailComment(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	
	

	public List<Board> selectMyPost(Connection conn, String userId) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;

		String query = "select * from board where user_id = ? AND bd_is_del=0 AND bd_is_blind=0 order by to_number(bd_idx) desc";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();

			while(rset.next()) {
				Board board = convertAllToBoard(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	

	public int deleteMyPost(Connection conn, String userId, String[] bdIdx) {
		PreparedStatement pstm = null;
		int res = 0;
		String query = "update board set bd_is_del=1 where user_id = ? and bd_idx=?";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			
			for (String str : bdIdx) {
				pstm.setString(2, str);
				res = pstm.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
	}
	
	
	
	public List<Board> selectMyComment(Connection conn, String userId) {
		List<Board> commentList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		String query = "select cmt_idx, bd_idx, C.user_id, title, cmt_content, cmt_reg_date, bd_section, cmt_is_del"
				+ " from board B inner join board_comment C using(bd_idx) where C.user_id = ?"
				+ " AND cmt_is_del=0 order by to_number(cmt_idx) desc";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			rset.toString();

			while(rset.next()) {
				Board board = convertAllToComment(rset);
				commentList.add(board);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return commentList;
	}
	
	

	public int deleteMyComment(Connection conn, String userId, String[] cmtIdx) {
		PreparedStatement pstm = null;
		int res = 0;
		String query = "update board_comment set cmt_is_del=1 where user_id = ? and cmt_idx = ?";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			
			for (String str : cmtIdx) {
				pstm.setString(2, str);
				res = pstm.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
	}

	
	
	//쿼리문으로 받아오는 속성 수 보다 아래 함수에서 저장하는 속성들이 더 많아지면, 오류남
	
	private Board convertAllToBoard(ResultSet rset) throws SQLException {
		Board board = new Board();
		
		board.setBdIdx(rset.getString("BD_IDX"));
		board.setUserId(rset.getString("USER_ID"));
		board.setRegDate(rset.getDate("REG_DATE"));
		board.setTitle(rset.getString("TITLE"));
		board.setContent(rset.getString("CONTENT"));
		board.setBdIsDel(rset.getInt("BD_IS_DEL"));
		board.setBdSection(BoardSection.valueOf(rset.getString("BD_SECTION")).section);
		board.setBdIsBlind(rset.getInt("BD_IS_BLIND"));

		return board;
	}
	
	private Board convertAllToComment(ResultSet rset) throws SQLException {
		Board board = new Board();
		
		board.setCmtIdx(rset.getString("cmt_idx"));
		board.setBdIdx(rset.getString("bd_idx"));
		board.setUserId(rset.getString("user_id"));
		board.setTitle(rset.getString("title"));
		board.setCmtContent(rset.getString("cmt_content"));
		board.setCmtRegDate(rset.getDate("cmt_reg_date"));
		board.setBdSection(BoardSection.valueOf(rset.getString("BD_SECTION")).section);
		board.setCmtIsDel(rset.getInt("cmt_is_del"));
		return board;
	}
	
	
	private Board convertAllToFreeBoardMain(ResultSet rset) throws SQLException {
		Board board = new Board();
		
		board.setBdIdx(rset.getString("BD_IDX"));
		board.setNickName(rset.getString("nickname"));
		board.setUserId(rset.getString("USER_ID"));
		board.setRegDate(rset.getDate("REG_DATE"));
		board.setTitle(rset.getString("TITLE"));

		return board;
	}
	

	private Board convertAllToFreeBoardDetail(ResultSet rset) throws SQLException {
		Board board = new Board();
		
		board.setBdIdx(rset.getString("BD_IDX"));
		board.setNickName(rset.getString("nickname"));
		board.setUserId(rset.getString("USER_ID"));
		board.setRegDate(rset.getDate("REG_DATE"));
		board.setTitle(rset.getString("TITLE"));
		board.setContent(rset.getString("content"));

		return board;
	}
	
	
	private Board convertAllToFreeBoardDetailComment(ResultSet rset) throws SQLException {
		Board board = new Board();
		board.setCmtIdx(rset.getString("cmt_idx"));
		board.setBdIdx(rset.getString("bd_idx"));
		board.setUserId(rset.getString("user_id"));
		board.setNickName(rset.getString("nickname"));
		board.setCmtContent(rset.getString("cmt_content"));
		board.setCmtRegDate(rset.getDate("cmt_reg_date"));
		return board;
	}
	




	



	

}
