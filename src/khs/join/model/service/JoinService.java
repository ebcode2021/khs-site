package khs.join.model.service;

import java.sql.Connection;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import khs.common.db.JDBCTemplate;
import khs.common.http.HttpConnector;
import khs.common.mail.MailSender;
import khs.join.model.dao.JoinDao;
import khs.join.model.dto.Member;

public class JoinService {

	private JoinDao joinDao = new JoinDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

	// ----------DB 활용 Service---------------
	public int insertMember(Member newMember) {

		Connection conn = template.getConnection();
		int IsSuccess = 0;

		try {
			IsSuccess = joinDao.insertMember(newMember, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return IsSuccess;
	}

	public String checkNickName(String nickName) {

		String result = null;
		Connection conn = template.getConnection();

		try {
			result = joinDao.checkNickName(nickName, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}

	public String checkId(String userId) {

		String result = null;
		Connection conn = template.getConnection();

		try {
			result = joinDao.checkId(userId, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}

	public String checkEmail(String email) {
		
		String result = null;
		Connection conn = template.getConnection();

		try {
			result = joinDao.checkEmail(email, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
	}
	
	// ----------DB 활용하지 않는 Service---------------

	public String sendVarificationEmail(HttpServletRequest request) {		
		
		// 1. Parameter를 통해 Email 가져옴, 빈 값 처리
		String email = (String) request.getParameter("userEmail");
		System.out.println("발송하려는 이메일 주소는  : " + email);
		if (email == "") {
			return "mailSendFailed";
		}
		// 2. Email 중복 검사 
		if(this.checkEmail(email) != null) {
			return "mailExist";
		}

		// 3. 난수 생성 및 저장
		int randomCode = this.makeRandom7Code();
		request.getSession().setAttribute("email-code", randomCode);

		// 4. 시간 생성 및 저장
		java.util.Date date = new java.util.Date();
		long variTime = date.getTime();
		request.getSession().setAttribute("email-time", variTime);

		// 5. Common의 공통모듈을 통해 메일 발송 및 성공 처리
		MailSender mailSender = new MailSender();
		HttpConnector conn = new HttpConnector();
		String response = conn
				.get("http://localhost:9090/mail?mailTemplate=join-varification-mail&variCode=" + randomCode);
		mailSender.sendEmail(email, "인증 코드 발송", response);
		return "mailSendSuccess";
	}

	public String checkVarificationEmail(HttpServletRequest request, String variCode) {

		// 1. 현재 시각 추출
		java.util.Date date = new java.util.Date();
		long currentTime = date.getTime();
		
		System.out.println("입력한 variCode : " + variCode);
		
		// 2. session 객체에 저장된 인증 코드 및 당시 시각 추출
		if(variCode == "") {
			return "invalid";
		}
		// 3. 정규표현식을 통해 int 파싱 전 문자열 체크 
		if(!(Pattern.compile("[0-9]{7}").matcher(variCode.trim()).matches())) {
			return "invalid";
		}
		// 4. 코드를 발급받은 적이 있는 지 체크 
		if(request.getSession().getAttribute("email-code") == null) {
			return "invalid";
		}
		
		int intVariCode = Integer.parseInt(variCode);
		System.out.println(intVariCode);
		int originCode = (int) request.getSession().getAttribute("email-code");
		long outTime = (long) request.getSession().getAttribute("email-time") + 300000;
		// 5분, 300000ms
		
		// 5. 인증 기한 검증
		if (currentTime > outTime) {
			return "timeout";
		}
		// 6. 코드 검증
		if (originCode == intVariCode) {
			return "valid";
		} else {
			return "invalid";
		}
		
	}
	
	public int makeRandom7Code() {

		int randomCode = 0; 

		while ( (Math.log10(randomCode) + 1) < 7) {
			randomCode = (int) (Math.random() * 10000000);
		}
		
		return randomCode;
	}
	

}
