package khs.search.controlloer;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.encrypt.Encrypter;
import khs.common.exception.PageNotFoundException;
import khs.common.http.HttpConnector;
import khs.common.mail.MailSender;
import khs.join.controller.JoinController;
import khs.join.model.service.JoinService;
import khs.search.model.dto.Member;
import khs.search.model.service.SearchService;

@WebServlet("/search/*")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SearchService searchService = new SearchService();   
	private Member member = new Member();
    private JoinService joinService = new JoinService();
    
    
    public SearchController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. URI 분리 작업 
				String[] uriArr = request.getRequestURI().split("/");
				switch (uriArr[uriArr.length-1]) {
				case "search-form" : 
					// joinForm.jsp로 forwarding
					searchForm(request, response);
					break; 
				case "password-form" : 
					// joinForm.jsp로 forwarding
					passwordForm(request, response);
					break; 	
				case "searchId-Method" : 
					searchIdMethod(request, response);
					break; 
				case "searchPassword-Method" : 
					searchPasswordMethod(request, response);
					break; 	
				case "checkPassword-Method" : 
					checkPasswordMethod(request, response);
					break; 
				case "confirm-password" : 
					confirmPassword(request, response); 
				default: 
					throw new PageNotFoundException();
				}
	}

	private void confirmPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = Encrypter.convertToSHA256(request.getParameter("password"));
		String firstPassword = (String) request.getSession().getAttribute("checkPasswordIsUnique");
		int res = searchService.changePassword(password, firstPassword);
		
		if(res == 0) {
			
		} else {
			
		}
		
		response.setContentType("text/html; charset=UTF-8"); 
		response.getWriter().println("<script>alert('비밀번호 변경이 완료되었습니다'); location.href='"+ "/login" +"';</script>"); 
		response.getWriter().close();
	}

	private void checkPasswordMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = Encrypter.convertToSHA256(request.getParameter("password"));
		String firstPassword = (String) request.getSession().getAttribute("checkPasswordIsUnique");
		
		boolean turefalse = (password.equals(firstPassword));
		
		if(turefalse) {
			response.getWriter().print("invalid");
			return; 
		} else {
			response.getWriter().print("valid");
			return; 
		}
		
		
	}

	private void searchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/search/search-form").forward(request, response);
		
	}

	
	private void passwordForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.getRequestDispatcher("/search/searchPassword-form").forward(request, response);
		
	}

	private void searchIdMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		member.setName(request.getParameter("name"));
		Date sqlDate = Date.valueOf(request.getParameter("birth"));
		member.setBirthDate(sqlDate);
		member.setEmail(request.getParameter("email"));
		
		String userId = searchService.searchUserId(member);
		
		System.out.println(userId);
		
		if(userId == null) {
			 response.setContentType("text/html; charset=UTF-8"); 
			 response.getWriter().println("<script>alert('이름, 생년월일, 혹은 이메일이 잘못되었습니다. 다시 입력하세요'); location.href='"+ "/search/search-form" +"';</script>"); 
			 response.getWriter().close();
			return;
		} else {
			// 이메일 발송이 완료되었다는 alert와 함께 로그인 페이지로 redirect 
			MailSender mailSender = new MailSender();
			HttpConnector conn = new HttpConnector();
			String responses = conn
					.get("http://localhost:9090/mail?mailTemplate=search_Id_Mail&userId=" + userId);
			mailSender.sendEmail(member.getEmail(), "아이디 발송", responses);
			
			response.setContentType("text/html; charset=UTF-8"); 
			response.getWriter().println("<script>alert('입력하신 이메일로 아이디가 전송되었습니다'); location.href='"+ "/login" +"';</script>"); 
			response.getWriter().close();
			return; 
		}
		
		
	}

	private void searchPasswordMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userPassword = searchService.searchUserPassword(userId);
		System.out.println(userPassword);
		request.getSession().setAttribute("checkPasswordIsUnique", userPassword);
		
		response.sendRedirect("/search/password-form");
	}

}
