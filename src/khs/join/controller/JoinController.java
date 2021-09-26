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
		 
		 System.out.println("3. joinMethod 진입 ( joinController)");
		
		 Member member = new Member();
		 member = (Member) request.getAttribute("joinCompleteMember");
		 
//		 // 1. FileUtil을 통해 Multipart 파싱, MultipartParams로 재구성 
//		 FileUtil fileUtil = new FileUtil();
//		 MultiPartParams multiPartParams = fileUtil.fileUpload(request);
//		 
//		 System.out.println("4. FileUtil 업로드 ( joinController)");
//		 
//		 //2. 파싱된 데이터 중 파일이 아닌 데이터 추출 
//		 String userId = multiPartParams.getParameterValues("userId")[0];	 
//		 String password = multiPartParams.getParameterValues("password")[0];
//		 String email = multiPartParams.getParameterValues("email")[0];
//		 String name = multiPartParams.getParameterValues("name")[0];
//		 String birth = multiPartParams.getParameterValues("birth")[0];
//		 String nickname = multiPartParams.getParameterValues("nickName")[0];
//		 String selectKH = multiPartParams.getParameterValues("selectKH")[0];
//		 
//		 
//		 
//		 System.out.println("파일의 경로는 : " + variFile); 
//		 System.out.println("sqlDate 변환 결과는 : " + sqlDate);
//		 
//		
//		 //4. 모든 Parameter 값을 memeberDTO에 삽입 
//		 Member newMember = new Member();
//		 newMember.setUserId(userId);
//		 newMember.setPassword(password);
//		 newMember.setEmail(email);
//		 newMember.setName(name);
//		 newMember.setNickname(nickname);
//		 newMember.setBirthDate(sqlDate);
//		 newMember.setKhCenter(selectKH);
//		 newMember.setVariFile(variFile);
		 
		 System.out.println("memberDTO의 결과는 : " + member);
		 //5. Service 단으로 전송, insert 실행  
		 joinService.insertMember(member);
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
