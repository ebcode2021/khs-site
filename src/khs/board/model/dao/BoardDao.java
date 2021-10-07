package khs.board.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import khs.board.model.dto.Board;
import khs.common.code.BoardSection;
import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.common.file.FileDTO;


public class BoardDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	
	//hot게시판 목록 불러오기
	public List<Board> hotBoard(Connection conn, Map<String, Integer> pageValues) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = "select rnum, B.* from("
						+ "select rownum rnum, A.* from("
						+ "select * from board inner join member using(user_id) "
						+ "where bd_is_del=0 AND bd_is_blind=0 AND bd_section='HOT' "
						+ "order by to_number(bd_idx) desc) A)B "
						+ "where ? < rnum and rnum <= ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, pageValues.get("startRow"));
			pstm.setInt(2, pageValues.get("endRow"));
			rset = pstm.executeQuery();

			while(rset.next()) {
				board = convertAllToFreeBoardMain(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	// 공지사항 목록 불러오기
	public List<Board> alertBoard(Connection conn, Map<String, Integer> pageValues) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = "select rnum, B.* from ("  
				+ "select rownum rnum, A.* from ("  
				+ "select * from board inner join member using(user_id) "
				+ "where bd_is_del=0 AND bd_is_blind=0 AND bd_section='ALERT' "
				+ "order by to_number(bd_idx) desc) A)B "  
				+ "where ? < rnum and rnum <= ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, pageValues.get("startRow"));
			pstm.setInt(2, pageValues.get("endRow"));
			rset = pstm.executeQuery();

			while(rset.next()) {
				board = convertAllToFreeBoardMain(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	public List<Board> freeBoardMain(Connection conn, Map<String, Integer> pageValues) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = "select rnum, B.* from ("
				 + "select rownum rnum, A.* from ("
				 + "select * from board "
				 + "inner join member using(user_id) where bd_is_del=0 AND bd_is_blind=0 AND bd_section='FREE' "
				 + "order by to_number(bd_idx) desc) A )B "
				 + "where ? < rnum and rnum <= ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, pageValues.get("startRow"));
			pstm.setInt(2, pageValues.get("endRow"));
			rset = pstm.executeQuery();

			while(rset.next()) {
				board = convertAllToFreeBoardMain(rset);
				boardList.add(board);
			}
			
			

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	public int boardTotalCount(Connection conn, String boardSection) {
		PreparedStatement pstm = null;
		ResultSet rset = null;

		String query = "select count(*) from board where bd_section = ? and bd_is_del=0 and bd_is_blind=0";
		int totalCnt = 0;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, boardSection);
			rset = pstm.executeQuery();
			if(rset.next()) {
				totalCnt = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return totalCnt;
	}
	
	
	public int myPostTotalCount(Connection conn, String userId) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select count(*) from board where user_id = ? AND bd_is_del=0";
		int totalCnt = 0;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			if(rset.next()) {
				totalCnt = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return totalCnt;
	}
	
	public int myCommentTotalCount(Connection conn, String userId) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select count(*) from board_comment where user_id = ? AND cmt_is_del=0";
		int totalCnt = 0;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			if(rset.next()) {
				totalCnt = rset.getInt("count(*)");
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return totalCnt;
	}
	
	
	
	// 게시글 상세보기
	public Board boardDetail(Connection conn, String bdIdx) {
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
	
	
	
	
	
public List<FileDTO> selectFileDTOs(Connection conn, String bdIdx) {
		
		String sql = "select fl_idx, bd_idx, origin_file_name, rename_file_name,"
						+ " save_path, reg_date from board_file"
						+ " where bd_idx = ? and file_is_del = 0";
		PreparedStatement pstm = null;
		ResultSet rset = null;
		List<FileDTO> files = new ArrayList<FileDTO>();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bdIdx);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				FileDTO file = new FileDTO();
				file.setFlIdx(rset.getString("fl_idx"));
				file.setTypeIdx(rset.getString("bd_idx"));
				file.setOriginFileName(rset.getString("origin_file_name"));
				file.setRenameFileName(rset.getString("rename_file_name"));
				file.setSavePath(rset.getString("save_path"));
				file.setRegDate(rset.getDate("reg_date"));
				
				files.add(file);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return files;
	}

	
	
	
	
	public List<Board> boardDetailComment(Connection conn, String bdIdx) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = "select * from board_comment inner join member using(user_id) where cmt_is_del=0 AND bd_idx=? order by cmt_idx";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, bdIdx);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				board = convertAllToFreeBoardDetailComment(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	
	

	public List<Board> selectMyPost(Connection conn, String userId,  Map<String, Integer> pageValues) {
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = 	"select rnum, B.* from ("
						+ "select rownum rnum, A.* from ("
						+ "select * from board where user_id = ? AND bd_is_del=0 "
						+ "order by to_number(bd_idx) desc) A)B "
						+ "where ? < rnum and rnum <= ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setInt(2, pageValues.get("startRow"));
			pstm.setInt(3, pageValues.get("endRow"));
			rset = pstm.executeQuery();

			while(rset.next()) {
				board = convertAllToBoard(rset);
				boardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return boardList;
	}
	
	
	

	public int deleteMyPost(Connection conn, String[] bdIdx) {
		CallableStatement cstm = null;
		int res = 0;
		String query = "{call SP_POST_DELETE(?)}";
		try {
			cstm = conn.prepareCall(query);
			for (String str : bdIdx) {
				cstm.setString(1, str);
				res = cstm.executeUpdate();
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(cstm);
		}
		
		return res;
	}
	

	
	
	
	public List<Board> selectMyComment(Connection conn, String userId, Map<String, Integer> pageValues) {
		List<Board> commentList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = 	"select rnum, B.* from ("
						+ "select rownum rnum, A.* from ("
						+ "select cmt_idx, bd_idx, C.user_id, title, cmt_content, cmt_reg_date, bd_section, cmt_is_del"
						+ " from board B inner join board_comment C using(bd_idx) where C.user_id = ?"
						+ " AND cmt_is_del=0 order by to_number(cmt_idx) desc) A) B"
						+ " where ? < rnum and rnum <= ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setInt(2, pageValues.get("startRow"));
			pstm.setInt(3, pageValues.get("endRow"));
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				board = convertAllToComment(rset);
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
	
	
	
	public int commentInput(Connection conn, Board board) {
		PreparedStatement pstm = null;
		int res = 0;
		String query = "insert into board_comment (cmt_idx, bd_idx, user_id, cmt_content)"
				+ " values(BD_CMT_IDX_INCREASE.NEXTVAL, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, board.getBdIdx());
			pstm.setString(2, board.getUserId());
			pstm.setString(3, board.getCmtContent());
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
		
	}
	
	
	
	public int insertBoard(Connection conn, Board board) {
		  int res = 0;
	      String query = "insert into board(bd_idx,user_id,"
	            + "title,content) values("
	            + "bd_post_idx_increase.nextval,?,?,?)";
	      
	      PreparedStatement pstm = null;
	      
	      try {
	         
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, board.getUserId());
	         pstm.setString(2, board.getTitle());
	         pstm.setString(3, board.getContent());
	         res = pstm.executeUpdate();
	         
	      } catch (SQLException e) {
	         throw new DataAccessException(e);
	      }finally {
	         template.close(pstm);
	      }
	      return res;
	   }
	

	public int insertBoard(Connection conn, Board board, String section) {
		  int res = 0;
	      String query = "insert into board(bd_idx,user_id,"
	            + "title,content,bd_section) values("
	            + "bd_post_idx_increase.nextval,?,?,?,?)";
	      
	      PreparedStatement pstm = null;
	      
	      try {
	         
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, board.getUserId());
	         pstm.setString(2, board.getTitle());
	         pstm.setString(3, board.getContent());
	         pstm.setString(4, board.getBdSection());
	         res = pstm.executeUpdate();
	         
	      } catch (SQLException e) {
	         throw new DataAccessException(e);
	      }finally {
	         template.close(pstm);
	      }
	      return res;
	   }
	
	
	
	public int insertFile(Connection conn, FileDTO fileDTO) {
		int res = 0;
		String query = "insert into board_file (fl_idx,bd_idx,"
	            + "origin_file_name,rename_file_name,save_path)"
	            + "values(file_idx_increase.nextval, bd_post_idx_increase.currval,?,?,?)";
	      
	      PreparedStatement pstm = null;
	      
	      try {
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, fileDTO.getOriginFileName());
	         pstm.setString(2, fileDTO.getRenameFileName());
	         pstm.setString(3, fileDTO.getSavePath());
	         
	         res =  pstm.executeUpdate();
	      } catch (SQLException e) {
	         throw new DataAccessException(e);
	      }finally {
	         template.close(pstm);
	      }
	      return res;
		
	}
	
	
	public int deletePost(Connection conn, String bdIdx) {
		int res = 0;
		CallableStatement cstm = null;
		String query = "{call SP_POST_DELETE(?)}";
		try {
			cstm = conn.prepareCall(query);
			cstm.setString(1, bdIdx);
			res = cstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(cstm);
		}
		return res;
	}
	
	
	public int updatePost(Connection conn, Board board) {
		int res = 0;
		CallableStatement cstm = null;
		String query = "{call SP_POST_UPDATE(?,?,?,?)}";
		
		try {
			cstm = conn.prepareCall(query);
			cstm.setString(1, board.getBdIdx());
			cstm.setString(2, board.getUserId());
			cstm.setString(3, board.getTitle());
			cstm.setString(4, board.getContent());
			res = cstm.executeUpdate();

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(cstm);
		}
		return res;
	}

	
	public int updateFile(Connection conn, FileDTO fileDTO, String bdIdx) {
		int res = 0;
		String query = "insert into board_file (fl_idx,bd_idx,"
	            + "origin_file_name,rename_file_name,save_path)"
	            + "values(file_idx_increase.nextval, ?,?,?,?)";
	      
	      PreparedStatement pstm = null;
	      
	      try {
	         pstm = conn.prepareStatement(query);
	         pstm.setString(1, bdIdx);
	         pstm.setString(2, fileDTO.getOriginFileName());
	         pstm.setString(3, fileDTO.getRenameFileName());
	         pstm.setString(4, fileDTO.getSavePath());
	         
	         res =  pstm.executeUpdate();
	      } catch (SQLException e) {
	         throw new DataAccessException(e);
	      }finally {
	         template.close(pstm);
	      }
		return res;
	}
	
	
	
	public int deleteComment(Connection conn, String cmtIdx) {
		PreparedStatement pstm = null;
		int res = 0;
		String query = "update board_comment set cmt_is_del=1 where cmt_idx = ?";
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, cmtIdx);
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		return res;
	}



	public List<Board> alertBoardToMain(Connection conn) {
		List<Board> alertBoardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = "select * from (select * from board inner join member using(user_id)" 
						+" where bd_is_del=0 AND bd_is_blind=0 AND bd_section='ALERT'"
						+" order by to_number(bd_idx) desc)"
						+" where rownum<4";
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();

			while(rset.next()) {
				board = convertAllToMain(rset);
				alertBoardList.add(board);
			}

		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return alertBoardList;
	}


	public List<Board> hotBoardToMain(Connection conn) {
		List<Board> hotBoardList = new ArrayList<Board>();
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Board board = null;
		String query = "select * from (select * from board inner join member using(user_id)" 
						+" where bd_is_del=0 AND bd_is_blind=0 AND bd_section='HOT'"
						+" order by to_number(bd_idx) desc)"
						+" where rownum<4";
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();

			while(rset.next()) {
				board = convertAllToMain(rset);
				hotBoardList.add(board);
			}
			System.out.println(hotBoardList);
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return hotBoardList;
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
		board.setBdSection(rset.getString("bd_section"));
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
	
	//메인페이지에서 필요한 board 정보
	private Board convertAllToMain(ResultSet rset) throws SQLException {
		Board board = new Board();
		board.setBdIdx(rset.getString("BD_IDX"));
		board.setUserId(rset.getString("USER_ID"));
		board.setRegDate(rset.getDate("REG_DATE"));
		board.setTitle(rset.getString("TITLE"));
		board.setBdSection(rset.getString("bd_section"));
		board.setBdIsDel(rset.getInt("BD_IS_DEL"));
		board.setBdIsBlind(rset.getInt("BD_IS_BLIND"));
		board.setNickName(rset.getString("NICKNAME"));
		return board;
	}




	
}
