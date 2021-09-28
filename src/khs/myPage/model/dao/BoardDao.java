package khs.myPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.myPage.model.dto.Board;


public class BoardDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

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
