package khs.myPage.validator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class DeleteCommentForm {
	
	private HttpServletRequest request;
	private Map<String,String> failedMypageAttr = new HashMap<String, String>();
	
	public DeleteCommentForm(HttpServletRequest request) {
		this.request = request;
	}
	
	public boolean test() {
		boolean res = true;
		String msg = null;
		
		String[] cmtIdx = request.getParameterValues("chk_cmt_num");
		
		
		if(cmtIdx==null) {
			msg = "체크된 항목이 없습니다.";
			failedMypageAttr.put("invalidCheckBoxMsg2", msg);
			res = false;
		}
		
		
		if(!res) {
			request.getSession().setAttribute("myPageFailed", failedMypageAttr);
		}else {
			request.getSession().removeAttribute("myPageFailed");
		}
		
		return res;
	}
	
	
}
