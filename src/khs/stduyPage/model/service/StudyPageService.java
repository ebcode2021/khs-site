package khs.stduyPage.model.service;

import java.sql.Connection;
import java.util.List;

import khs.common.db.JDBCTemplate;
import khs.stduyPage.model.dao.StudyPageDao;
import khs.stduyPage.model.dto.BoardStudy;

public class StudyPageService {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();

	private StudyPageDao studyPageDao = new StudyPageDao();
	
	public List<BoardStudy> checkNickName() {

		List<BoardStudy> result = null;
		Connection conn = template.getConnection();

		try {
			result = studyPageDao.studyDatas(conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn); // 에러 발생 경우 다 롤백 시킴
			throw e;
		} finally {
			template.close(conn); // 오류가 생겼을 때 데이터베이스에서 바로 커밋하는 것을 방지
		}
		return result;
	}
	
	
	
}
