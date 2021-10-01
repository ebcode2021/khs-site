package khs.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.board.model.dto.Board;
import khs.board.model.service.BoardService;
import khs.common.exception.PageNotFoundException;
import khs.myPage.model.service.MyPageService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardService boardService = new BoardService();
	MyPageService myPageService = new MyPageService();
	
    public BoardController() {
        super();
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		
		case "free-board-main":
			boardMain(request,response);
			break;
		case "free-board-form":
			boardForm(request,response);
			break;
		case "free-board-upload":
			upload(request,response);
			break;
		case "free-board-detail":
			boardDetail(request,response);
			break;
		case "free-board-comment-input":
			commentInput(request,response);
			break;
		default: throw new PageNotFoundException();
		}
		
	}



    private void commentInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Board board = new Board();
		String userId = myPageService.getLoginMemberId(request);
		String bdIdx = request.getParameter("bdIdx");
		String content = request.getParameter("comment-content");
		
		
		request.getRequestDispatcher("/board/free-board-detail").forward(request, response);
	}


	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	String bdIdx = request.getParameter("bd_idx");
    	Board board = boardService.freeBoardDetail(bdIdx);
    	List<Board> boardCommentList = boardService.freeBoardDetailComment(bdIdx);
				
		request.setAttribute("board", board);
		request.setAttribute("boardCommentList", boardCommentList);
		
		request.getRequestDispatcher("/board/free-board-detail").forward(request, response);
		
	}


	private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	private void boardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/board-form").forward(request, response);;
	}
	
	
	
	
	private void boardMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> boardList = boardService.freeBoardMain();
		
		request.setAttribute("boardList", boardList);
		
		
		request.getRequestDispatcher("/board/free-board-main").forward(request, response);;
	}

	
	
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
