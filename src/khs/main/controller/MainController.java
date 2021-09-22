package khs.main.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			request.getRequestDispatcher("/main/main").forward(request, response);
			System.out.println("coccco");
			break;
		case "myPage" :
			myPage(request,response);
			break;
		case "board" :
			board(request,response);
			break;
		case "restaurant" :
			restaurant(request,response);
			break;
		case "study" :
			study(request,response);
			break;
		case "question" :
			question(request,response);
			break;
		default : throw new PageNotFoundException();
		}
	}

	private void myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/myPage");
		
	}

	private void board(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/board");
		
	}

	private void restaurant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/restaurant");
		
	}

	private void study(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/study");
		
	}

	private void question(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("/question");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
