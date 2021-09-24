package khs.myPage.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import khs.myPage.model.dto.MyPage;
import khs.myPage.model.service.MyPageService;

public class ChangeMypageForm {
	
	private HttpServletRequest request;
	private MyPageService myPageService = new MyPageService();
	private Map<String,String> failedMypageAttr = new HashMap<String, String>();
	
	public ChangeMypageForm(HttpServletRequest request) {
		this.request = request;
	}
	
	public boolean test() {
		boolean res = true;
		boolean validEmail = true;
		String msg = null;
		String newEmail = request.getParameter("newEmail");
		String newNickname = request.getParameter("newNickname");
		
		String emailRegEx = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		validEmail = Pattern.matches(emailRegEx, newEmail);
		MyPage myPage = myPageService.nicknameDuplicatedTest(newNickname);
		
		if(!validEmail) {
			msg = "이메일 형식이 잘못되었습니다.";
			failedMypageAttr.put("invalidEmailMsg", msg);
			res = false;
		}
		
		
		if(myPage != null) {
			msg = "중복된 닉네임입니다.";
			failedMypageAttr.put("DuplicatedMsg", msg);
			res = false;
		}
		
		
		
		
		if(!res) {
			failedMypageAttr.put("duplicated", newNickname);
			failedMypageAttr.put("invalidEmail", newEmail);
			request.getSession().setAttribute("changeMypageFailed", failedMypageAttr);
		}else {
			request.getSession().removeAttribute("changeMypageFailed");
		}
		
		return res;
	}
	




}
