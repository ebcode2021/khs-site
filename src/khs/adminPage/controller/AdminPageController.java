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
	
	// 커밋테스트 - 나중에 지우기
       
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
			
		case "bdIdxDelete":
			bdIdxDelete(request,response);
			break; 
		case "bdIdxRollBack":
			bdIdxRollBack(request,response);
			break;
			
		case "memberBanGrade01":
			memberBanGrade01(request,response);
			break;
		case "memberBanGrade02":
			memberBanGrade02(request,response);
			break;
		case "memberBanGrade03":
			memberBanGrade03(request,response);
			break;
		case "memberBanGrade04":
			memberBanGrade04(request,response);
			break;
			
		case "userGradeLV01":
			userGradeLV01(request,response);
			break;
		case "userGradeLV02":
			userGradeLV02(request,response);
			break;
			
			
		case "logout":
			logout(request,response);
			break;
		default: response.setStatus(404);
			break;
		}
	}

	
	
	


	private void userGradeLV01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		String userId = request.getParameter("userGradeLV01");
		System.out.println(userId);
		System.out.println("userGradeLV01");
		adminPageService.userGradeLV01(userId);
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-accountInfo").forward(request, response);
	}

	private void userGradeLV02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException   {
		String userId = request.getParameter("userGradeLV02");
		System.out.println(userId);
		System.out.println("userGradeLV02");
		adminPageService.userGradeLV02(userId);
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-accountInfo").forward(request, response);
	}
	
	
	
	

	private void memberBanGrade04(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userId = request.getParameter("userId04");
		System.out.println(userId);
		System.out.println("정지해제");
		adminPageService.memberBanGrade04(userId);
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-memberBlock").forward(request, response);
	}

	private void memberBanGrade03(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userId = request.getParameter("userId03");
		System.out.println(userId);
		System.out.println("영구정지");
		adminPageService.memberBanGrade03(userId);
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-memberBlock").forward(request, response);
	}

	private void memberBanGrade02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userId = request.getParameter("userId02");
		System.out.println(userId);
		System.out.println("7일정지");
		adminPageService.memberBanGrade02(userId);
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-memberBlock").forward(request, response);
	}

	// 맴버 밴등급 관리
	private void memberBanGrade01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userId = request.getParameter("userId01");
		System.out.println(userId);
		System.out.println("1일정지");
		adminPageService.memberBanGrade01(userId);
		List<AdminPage> list = adminPageService.adminPageService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-memberBlock").forward(request, response);
	}

	
	
	
	
	// 자유게시판 블라인드 처리  
	private void bdIdxDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bdIdxDelete = request.getParameter("bdIdxDelete");
		System.out.println(bdIdxDelete);
		adminPageService.bdIdxDelete(bdIdxDelete);
		List<Board> list = adminPageService.adminPageBoardService();
		request.setAttribute("adminPageList", list);
		request.getRequestDispatcher("/adminPage/adminPage-freeChart").forward(request, response);
	}
	
	
	
	// 자유게시판 블라인드 해제
	private void bdIdxRollBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String bdIdxRollBack = request.getParameter("bdIdxRollBack");
		System.out.println(bdIdxRollBack);
		adminPageService.bdIdxRollBack(bdIdxRollBack);
		List<Board> list = adminPageService.adminPageBoardService();
		request.setAttribute("adminPageList", list);
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