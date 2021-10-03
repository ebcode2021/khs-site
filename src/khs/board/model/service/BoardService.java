package khs.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import khs.board.model.dao.BoardDao;
import khs.board.model.dto.Board;
import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.common.file.FileDTO;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	 public void insertBoard(Board board, List<FileDTO> files) {
	      Connection conn = template.getConnection();
	      
	      try {
	         boardDao.insertBoard(conn, board);
	         for (FileDTO fileDTO : files) {
	            boardDao.insertFile(conn,fileDTO);
	         }
	         template.commit(conn);
	      } catch (DataAccessException e) {
	         template.rollback(conn);
	         throw e;
	      }finally {
	         template.close(conn);
	      }
	   }
	
	
	
	public List<Board> freeBoardMain() {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.freeBoardMain(conn);
		} finally {
			template.close(conn);
		}

		return boardList;
	}
	
	
	public Map<String, Object> freeBoardDetail(String bdIdx) {
		Connection conn = template.getConnection();
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Board board = boardDao.freeBoardDetail(conn, bdIdx);
			List<FileDTO> files = boardDao.selectFileDTOs(conn, bdIdx);
			res.put("board", board);
			res.put("files", files);
		} finally {
			template.close(conn);
		}

		return res;
	}
	
	
	public List<Board> freeBoardDetailComment(String bdIdx) {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.freeBoardDetailComment(conn, bdIdx);
		} finally {
			template.close(conn);
		}

		return boardList;
	}


	public int commentInput(Board board) {
		int res = 0;
		Connection conn = template.getConnection();
		
		try {
			res = boardDao.commentInput(conn, board);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		
		return res;
	}


	public int deletePost(String bdIdx) {
		int res = 0;
		Connection conn = template.getConnection();
		
		try {
			res = boardDao.deletePost(conn, bdIdx);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}



	public void updatePost(Board board, List<FileDTO> files) {
		Connection conn = template.getConnection();
		String bdIdx = board.getBdIdx();
	      
	      try {
	         boardDao.updatePost(conn, board);
	         for (FileDTO fileDTO : files) {
	            boardDao.updateFile(conn,fileDTO,bdIdx);
	         }
	         template.commit(conn);
	      } catch (DataAccessException e) {
	         template.rollback(conn);
	         throw e;
	      }finally {
	         template.close(conn);
	      }
	}



	public int deleteComment(String cmtIdx) {
		int res = 0;
		Connection conn = template.getConnection();
		
		try {
			res = boardDao.deleteComment(conn, cmtIdx);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return res;
	}


	public List<Board> alertBoardToMain() {
		Connection conn = template.getConnection();
		List<Board> alertBoardList = null;
		
		try {
			alertBoardList = boardDao.alertBoardToMain(conn);
		} finally {
			template.close(conn);
		}

		return alertBoardList;
	}



	public List<Board> hotBoardToMain() {
		Connection conn = template.getConnection();
		List<Board> hotBoardList = null;
		
		try {
			hotBoardList = boardDao.hotBoardToMain(conn);
		} finally {
			template.close(conn);
		}

		return hotBoardList;
	}
	

	

	

	
	
}
