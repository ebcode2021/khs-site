package khs.join.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.code.ErrorCode;
import khs.common.exception.HandlableException;
import khs.common.exception.PageNotFoundException;
import khs.common.file.FileDTO;
import khs.common.file.FileUtil;
import khs.common.file.MultiPartParams;
import khs.common.http.HttpConnector;
import khs.common.mail.MailSender;
import khs.join.model.dto.Member;
import khs.join.model.service.JoinService;

@WebServlet("/join/*")
public class JoinController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private JoinService joinService = new JoinService();
	
    public JoinController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. URI 분리 작업 
		String[] uriArr = request.getRequestURI().split("/");
		switch (uriArr[uriArr.length-1]) {
		case "join-form" : 
			// joinForm.jsp로 forwarding
			joinForm(request, response);
			break;   
		case "join-Method" :
			System.out.println("2. joinMethod 점검 ( joinController)");
			// joinMethod 실행
			join(request, response);
			break; 
		case "join-checkId" :
			// id 중복검사 실행 
			checkId(request, response);
			break; 
		case "join-send-Vari-Email" :
			// email 인증 코드 보내기 
			joinSendVariEmail(request, response); 
			break; 
		case "join-VariCode" :
			// email 인증 코드 검사 실행 
			checkVariCode(request,response);
			break;
		case "join-VariNickName" : 
			// nickName 중복검사 실행 
			checkNickName(request,response);
			break; 
		default: 
			throw new PageNotFoundException();
		}
	}

	private void joinForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/join/join-form").forward(request, response);
		
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 //filter에서 완성한 MemberDTO 추출 
		 Member member = new Member();
		 member = (Member) request.getAttribute("joinCompleteMember");
	
		 String kakaoCode = (String) request.getSession().getAttribute("kakaoCode");
		 member.setKakaoCode(kakaoCode);
		 //join
		 joinService.insertMember(member);
		 
		 //이메일 발송
		 MailSender mailSender = new MailSender();
		 HttpConnector conn = new HttpConnector();
		 String Emailresponse = conn.get("http://localhost:9090/mail?mailTemplate=welcome-mail");
		 mailSender.sendEmail(member.getEmail(), "가입 축하 메일 발송", Emailresponse);
		 
		 //가입 축하메일 발송에 관한 알람이 필요 
		 
		 //로그인 페이지로 redirect 
		 response.setContentType("text/html; charset=UTF-8"); 
		 response.getWriter().println("<script>alert('회원 가입이 완료되어 가입 축하 메일이 전송되었습니다'); location.href='"+ "/login" +"';</script>"); 
		 response.getWriter().close();
		 
	}
	
	private void checkId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("checkId");
		String result = joinService.checkId(userId);
		
		if (result != null) {
			response.getWriter().print("invalid");
		} else {
			response.getWriter().print("valid");
		}
	}
	
	private void joinSendVariEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String result = joinService.sendVarificationEmail(request);
		response.getWriter().print(result);
	}
	
	private void checkVariCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String variCode = request.getParameter("variCode");
		
		String result = joinService.checkVarificationEmail(request, variCode); 
		response.getWriter().print(result);
	}
	
	
	private void checkNickName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nickName = request.getParameter("nickName");
		String result = joinService.checkNickName(nickName);

		if (result != null) {
			response.getWriter().print("invalid");
		} else {
			response.getWriter().print("valid");
		}
		 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
