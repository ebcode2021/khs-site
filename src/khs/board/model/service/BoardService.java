package khs.board.model.service;

import java.sql.Connection;
import java.util.List;

import khs.board.model.dao.BoardDao;
import khs.board.model.dto.Board;
import khs.common.db.JDBCTemplate;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	
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
	
	
	public Board freeBoardDetail(String bdIdx) {
		Connection conn = template.getConnection();
		Board board = null;
		
		try {
			board = boardDao.freeBoardDetail(conn, bdIdx);
		} finally {
			template.close(conn);
		}

		return board;
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
	
	
	
	
}
