package khs.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.board.model.dto.Board;
import khs.board.model.service.BoardService;
import khs.common.exception.PageNotFoundException;

@WebServlet("/main/*")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MainController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] uriArr = request.getRequestURI().split("/");
		switch(uriArr[uriArr.length-1]) {
		case "main" :
			main(request,response);
			break;
		case "logout" :
			logout(request,response);
			break;
		case "popup" :
			popup(request,response);
			break;
		default : throw new PageNotFoundException();
		}
	}

	private void popup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/main/popup").forward(request, response);
		
	}

	private void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService boardService = new BoardService();
		List<Board> alertList = boardService.alertBoardToMain();
		request.setAttribute("alertList", alertList);
		
		List<Board> hotList = boardService.hotBoardToMain();
		request.setAttribute("hotList", hotList);
		
		request.getRequestDispatcher("/main/main").forward(request, response);
		
	}

	

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().getAttribute("authentication");
		request.getSession().removeAttribute("authentication");
		response.sendRedirect("/login");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
