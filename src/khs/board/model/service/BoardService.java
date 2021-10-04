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
	    	  if(board.getBdSection() != null) {
	    		  boardDao.insertBoard(conn, board, board.getBdSection());
	    	  }else {
	    		  boardDao.insertBoard(conn, board);
	    	  }
	        
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
	 


	public List<Board> hotBoard(Map<String, Integer> pageValues) {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.hotBoard(conn, pageValues);
		} finally {
			template.close(conn);
		}

		return boardList;
	}
	 
	 

	public List<Board> alertBoard(Map<String, Integer> pageValues) {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.alertBoard(conn, pageValues);
		} finally {
			template.close(conn);
		}

		return boardList;
	}
	
	
	
	
	public List<Board> freeBoardMain(Map<String,Integer> pageValues) {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.freeBoardMain(conn, pageValues);
		} finally {
			template.close(conn);
		}

		return boardList;
	}
	
	
	//페이징 처리용 메서드
	public Map<String, Integer> boardPaging(String pageNum, String boardSection, int itemsInPage, int pageBlockCnt) {
		Connection conn = template.getConnection();
		Map<String, Integer> pageValues = new HashMap<String, Integer>();
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*itemsInPage;
		int endRow = ((currentPage-1)*itemsInPage + itemsInPage);
		int totalPageCnt = (int)Math.ceil((double)boardDao.boardTotalCount(conn,boardSection)/itemsInPage);
		int startPageNum = ((currentPage-1)/pageBlockCnt)*pageBlockCnt+1;
		int endPageNum = ((currentPage-1)/pageBlockCnt)*pageBlockCnt+pageBlockCnt;
		int prevFlg = 0;
		int nextFlg = 0;
		
		if(totalPageCnt < endPageNum) {
			endPageNum = totalPageCnt;
			nextFlg = 0;
		} else {
			nextFlg = 1;
		}
		if(startPageNum != 1) {
			prevFlg = 1;
		}
		try {
			pageValues.put("currentPage", currentPage);
			pageValues.put("startRow", startRow);
			pageValues.put("endRow", endRow);
			pageValues.put("totalPageCnt", totalPageCnt);
			pageValues.put("pageBlockCnt", pageBlockCnt);
			pageValues.put("startPageNum", startPageNum);
			pageValues.put("endPageNum", endPageNum);
			pageValues.put("prevFlg", prevFlg);
			pageValues.put("nextFlg", nextFlg);
		} finally {
			template.close(conn);
		}
		return pageValues;
	}
	
	
	public Map<String, Integer> boardPaging(String pageNum, int itemsInPage, int pageBlockCnt,  String userId) {
		Connection conn = template.getConnection();
		Map<String, Integer> pageValues = new HashMap<String, Integer>();
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*itemsInPage;
		int endRow = ((currentPage-1)*itemsInPage + itemsInPage);
		int totalPageCnt = (int)Math.ceil((double)boardDao.myPostTotalCount(conn, userId)/itemsInPage);
		int startPageNum = ((currentPage-1)/pageBlockCnt)*pageBlockCnt+1;
		int endPageNum = ((currentPage-1)/pageBlockCnt)*pageBlockCnt+pageBlockCnt;
		int prevFlg = 0;
		int nextFlg = 0;
		
		if(totalPageCnt < endPageNum) {
			endPageNum = totalPageCnt;
			nextFlg = 0;
		} else {
			nextFlg = 1;
		}
		if(startPageNum != 1) {
			prevFlg = 1;
		}
		try {
			pageValues.put("currentPage", currentPage);
			pageValues.put("startRow", startRow);
			pageValues.put("endRow", endRow);
			pageValues.put("totalPageCnt", totalPageCnt);
			pageValues.put("pageBlockCnt", pageBlockCnt);
			pageValues.put("startPageNum", startPageNum);
			pageValues.put("endPageNum", endPageNum);
			pageValues.put("prevFlg", prevFlg);
			pageValues.put("nextFlg", nextFlg);
		} finally {
			template.close(conn);
		}
		return pageValues;
	}
	
	
	
	public Map<String, Integer> boardPaging(String pageNum, int itemsInPage,  String userId, int pageBlockCnt) {
		Connection conn = template.getConnection();
		Map<String, Integer> pageValues = new HashMap<String, Integer>();
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*itemsInPage;
		int endRow = ((currentPage-1)*itemsInPage + itemsInPage);
		int totalPageCnt = (int)Math.ceil((double)boardDao.myCommentTotalCount(conn, userId)/itemsInPage);
		int startPageNum = ((currentPage-1)/pageBlockCnt)*pageBlockCnt+1;
		int endPageNum = ((currentPage-1)/pageBlockCnt)*pageBlockCnt+pageBlockCnt;
		int prevFlg = 0;
		int nextFlg = 0;
		
		if(totalPageCnt < endPageNum) {
			endPageNum = totalPageCnt;
			nextFlg = 0;
		} else {
			nextFlg = 1;
		}
		if(startPageNum != 1) {
			prevFlg = 1;
		}
		try {
			pageValues.put("currentPage", currentPage);
			pageValues.put("startRow", startRow);
			pageValues.put("endRow", endRow);
			pageValues.put("totalPageCnt", totalPageCnt);
			pageValues.put("pageBlockCnt", pageBlockCnt);
			pageValues.put("startPageNum", startPageNum);
			pageValues.put("endPageNum", endPageNum);
			pageValues.put("prevFlg", prevFlg);
			pageValues.put("nextFlg", nextFlg);
		} finally {
			template.close(conn);
		}
		return pageValues;
	}
	
	

	
	public Map<String, Object> boardDetail(String bdIdx) {
		Connection conn = template.getConnection();
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Board board = boardDao.boardDetail(conn, bdIdx);
			List<FileDTO> files = boardDao.selectFileDTOs(conn, bdIdx);
			res.put("board", board);
			res.put("files", files);
		} finally {
			template.close(conn);
		}

		return res;
	}
	
	
	public List<Board> boardDetailComment(String bdIdx) {
		Connection conn = template.getConnection();
		List<Board> boardList = null;
		
		try {
			boardList = boardDao.boardDetailComment(conn, bdIdx);
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
