package khs.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.board.model.dto.Board;
import khs.board.model.service.BoardService;
import khs.common.exception.PageNotFoundException;
import khs.common.file.FileDTO;
import khs.common.file.FileUtil;
import khs.common.file.MultiPartParams;
import khs.login.model.dto.Member;
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
		case "board-form":
			boardForm(request,response);
			break;
		case "free-board-detail":
			boardDetail(request,response);
			break;
		case "free-board-comment-input":
			commentInput(request,response);
			break;
		case "free-board-upload":
			uploadPost(request,response);
			break;
		case "free-board-delete":
			deletePost(request,response);
			break;
		case "free-board-update-form":
			updateForm(request,response);
			break;
		case "free-board-update":
			updatePost(request,response);
			break;
		case "free-board-comment-delete":
			deleteComment(request,response);
			break;
		default: throw new PageNotFoundException();
		}
		
	}


    private void deleteComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmtIdx = request.getParameter("cmtIdx");
		String bdIdx = request.getParameter("bdIdx");
		boardService.deleteComment(cmtIdx);
		
		response.sendRedirect("/board/free-board-detail?bd_idx=" + bdIdx);
	}


	private void updatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	FileUtil util = new FileUtil();
    	String bdIdx = request.getParameter("bdIdx");
		String userId = myPageService.getLoginMemberId(request);
		MultiPartParams multiPart = util.fileUpload(request);
		
		Board board = new Board();
		board.setBdIdx(bdIdx);
		board.setUserId(userId);
		board.setTitle(multiPart.getParameter("title"));
		board.setContent(multiPart.getParameter("content"));
		
		
		List<FileDTO> files = multiPart.getFilesInfo();
		
		
		boardService.updatePost(board, files);
		
		request.setAttribute("msg","게시글이 수정되었습니다.");
		request.setAttribute("url", "/board/free-board-main");
		request.getRequestDispatcher("/error/result").forward(request, response);
    	
	}


	private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String bdIdx = request.getParameter("bdIdx");
    	Map<String, Object> datas = boardService.freeBoardDetail(bdIdx);
    	
    	request.setAttribute("datas", datas);
    	request.getRequestDispatcher("/board/board-form").forward(request, response);
	}


	private void deletePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String bdIdx = request.getParameter("bdIdx");
    	
    	boardService.deletePost(bdIdx);
    	
    	request.setAttribute("msg","해당 게시글과, 그 댓글들이 삭제되었습니다.");
		request.setAttribute("url", "/board/free-board-main");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}


	private void uploadPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileUtil util = new FileUtil();
		MultiPartParams multiPart = util.fileUpload(request);
		Member member = (Member) request.getSession().getAttribute("authentication");

		Board board = new Board();
		board.setUserId(member.getUserId());
		board.setTitle(multiPart.getParameter("title"));
		board.setContent(multiPart.getParameter("content"));
		

		List<FileDTO> files = multiPart.getFilesInfo();
		boardService.insertBoard(board, files);
		request.setAttribute("msg","게시글 작성 완료");
		request.setAttribute("url", "/board/free-board-main");
		request.getRequestDispatcher("/error/result").forward(request, response);
		
	}
    
    
    private void boardForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/board-form").forward(request, response);
	}
	


	private void commentInput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Board board = new Board();
		String userId = myPageService.getLoginMemberId(request);
		String bdIdx = request.getParameter("bdIdx");
		String content = request.getParameter("comment-content");
		
		board.setUserId(userId);
		board.setBdIdx(bdIdx);
		board.setCmtContent(content);
		boardService.commentInput(board);
		
		response.sendRedirect("/board/free-board-detail?bd_idx=" + bdIdx);
		
	}


	private void boardDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = myPageService.getLoginMemberId(request);
    	String bdIdx = request.getParameter("bd_idx");
    	Map<String, Object> datas = boardService.freeBoardDetail(bdIdx);
    	
    	List<Board> boardCommentList = boardService.freeBoardDetailComment(bdIdx);
    	
    	Board board = (Board) datas.get("board");
    	if(board.getUserId().equals(userId)) {
    		request.setAttribute("myworks", "1");
    	}
    	
		request.setAttribute("myUserId", myPageService.getLoginMemberId(request));
		request.setAttribute("datas", datas);
		request.setAttribute("boardCommentList", boardCommentList);
		
		request.getRequestDispatcher("/board/free-board-detail").forward(request, response);
		
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
