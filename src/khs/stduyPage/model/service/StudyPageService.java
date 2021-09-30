package khs.stduyPage.model.service;

import khs.common.db.JDBCTemplate;
import khs.stduyPage.model.dao.StudyPageDao;

public class StudyPageService {
	
	private StudyPageDao studyPageDao = new StudyPageDao(); 
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	
}