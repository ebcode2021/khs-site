package khs.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.adminPage.model.dto.AdminPage;
import khs.adminPage.model.service.AdminPageService;
import khs.board.model.dto.Board;

@WebServlet("/adminPage/*")
public class AdminPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminPageService adminPageService = new AdminPageService();
	
	
       
    public AdminPageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		// 관리자 메인 페이지로 접속 (테스트)
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
		case "boardBlindData":
			boardBlindData(request,response);
			break;
		case "logout":
			logout(request,response);
			break;
		default: response.setStatus(404);
			break;
		}
	}

	
	
	
	
	// 자유게시판 블라인드 처리  *******
	private void boardBlindData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bdIdx = request.getParameter("bdIdx");
		// jsp에서 값(bdIdx)을 받아음
		
		adminPageService.boardBlind(bdIdx);
		// jsp에서 받아온 bdIdx을 dao까지 가져가 수정을 시킴
		
		// 그럼 지금은 쿼리 수정이 완료된 상태
		request.getRequestDispatcher("/adminPage/adminPage-freeChart").forward(request, response);
	}
	
	
	
	
	

	// 관리자 메인 페이지로 접속
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/adminPage/adminPage-index").forward(request, response);
	}

	
	// 회원정보조회 페이지로 접속
	private void accountInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list); //list
		request.getRequestDispatcher("/adminPage/adminPage-accountInfo").forward(request, response);
	}

	
	// 차단된 회원 관리 페이지로 접속
	protected void memberBlock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-memberBlock").forward(request, response);
	}
	
	// 자유게시판 관리 페이지로 접속
	protected void freeChart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Board> list = adminPageService.adminPageBoardService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-freeChart").forward(request, response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().getAttribute("authentication");
		request.getSession().removeAttribute("authentication");
		request.setAttribute("msg", "로그아웃 되었습니다.");
		request.setAttribute("url", "/login");
		request.getRequestDispatcher("/error/result").forward(request, response);
	}
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}