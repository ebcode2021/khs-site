package khs.main.model.service;

import java.sql.Connection;
import java.sql.Date;

import khs.common.db.JDBCTemplate;
import khs.main.model.dao.VisitDao;

public class VisitService {

	private VisitDao visitDao = new VisitDao();
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public int getTodayVisitCnt() {
		Connection conn = template.getConnection();
		int res=0;
		
		try {
			res = visitDao.getTodayVisitCnt(conn);
		}finally {
			template.close(conn);
		}
		return res;
	}

	public int getTotalVisitCnt() {
		Connection conn = template.getConnection();
		int res = 0;
		try {
			res = visitDao.getAllVisitCnt(conn);
		}finally {
			template.close(conn);
		}
		return res;
	}
	}
