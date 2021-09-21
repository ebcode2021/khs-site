package khs.join.model.service;

import java.sql.Connection;
import java.util.Date;

import khs.common.db.JDBCTemplate;
import khs.common.http.HttpConnector;
import khs.common.mail.MailSender;
import khs.join.model.dao.JoinDao;
import khs.join.model.dto.Member;

public class JoinService {

	// *****Service단 기능*****
	
	//1. DAO단의 Connection 가져오기 
	//   에러 발생, 혹은 서비스 실행 시 rollback을 통한 transaction관리를 위해 
	// 	 Connection을 Service단으로 가져와서, 관련기능인 commit과 rollback을 사용해야한다. 
	
	//2. SQLexcaption에 대한 예외처리 (rollback)
	// 	 SQLException 발생 시, DAO단에서 처리하는 코드를 삭제하고, 에러를 넘겨서 Service단에서 잡게 만든다. 
	//   그러면 코드가 줄고, rollback을 적용할 수 있게 된다. 
	
	//3. 연결에 대한 Close처리 
	//	 SQL의 connection을 Service단에서 관리하므로, 반드시 닫아주어야 한다. 
	
	private JoinDao joinDao = new JoinDao(); 
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
	
	//----------회원가입 기능 Service---------------
	public int insertMember(Member newMember) {
		
		Connection conn = template.getConnection();
		int IsSuccess = 0;
		
		try {
			IsSuccess = joinDao.insertMember(newMember, conn);
			template.commit(conn);
		} catch(Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return IsSuccess;
	}
	
	//----------회원가입 인증 메일 전송 및 코드 확인 Service--------------- 
	public void sendVarificationEmail(String email, int randomCode) {
		
		System.out.println("3. 메일 전송 메서드 진입 완료 및 sendEmail 객채생성 ");
		MailSender mailSender = new MailSender();
		
		System.out.println("4. HttpConnector를 불러, bodyMessage 작성");
		HttpConnector conn = new HttpConnector(); 
		String response =
		conn.get("http://localhost:9090/mail?mailTemplate=join-varification-mail&variCode=" + randomCode);
		
		System.out.println("5. 완성된 url을 통해 Email 발송");
		mailSender.sendEmail(email, "인증 코드 발송", response);
		
		
	}
	
	public void checkVarificationEmail(String email) {
		
		// 인증버튼을 누르면, request객체의 sessionScope에 있는 parameter를 꺼냄 
		
		// 인증코드와 날짜를 비교 
		
		// 정해진 3 값중 하나를 돌려보냄 ( write로 text에 ) 
	}

	public Object searchById(String userId) {
		return null;
	}
	
	
	
}
