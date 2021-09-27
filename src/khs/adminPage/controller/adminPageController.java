package khs.adminPage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adminPage")
public class adminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adminPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		// 관리자 메인 페이지로 접속
		case "index": 
			index(request,response);
			break;
		// 회원정보조회 페이지로 접속
		case "accountInfo": 
			accountInfo(request,response);
			break;
		// 차단된 회원 관리 페이지로 접속
		case "memberBlock":
			memberBlock(request,response);
			break;
		// 자유게시판 관리 페이지로 접속
		case "freeChart":
			freeChart(request,response);
			break;
		default: 
			break;
		}
	}

	// 관리자 메인 페이지로 접속
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adminPage/adminPage-index").forward(request, response);
	}

	// 회원정보조회 페이지로 접속
	private void accountInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adminPage/adminPage-accountInfo").forward(request, response);
	}

	// 차단된 회원 관리 페이지로 접속
	protected void memberBlock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adminPage/adminPage-memberBlock").forward(request, response);
	}
	
	// 자유게시판 관리 페이지로 접속
	protected void freeChart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adminPage/adminPage-freeChart").forward(request, response);
	}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
