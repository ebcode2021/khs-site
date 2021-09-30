package khs.food.model.service;

import java.sql.Connection;
import khs.common.db.JDBCTemplate;
import khs.food.model.dao.FoodDao;


public class FoodService {

	private FoodDao foodDao = new FoodDao();
	private JDBCTemplate template = JDBCTemplate.getInstance(); 
	
	public String searchFood(String khCenter) {
		
		String result = null;
		Connection conn = template.getConnection();

		try {
			result = foodDao.checkNickName(khCenter, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return result;
		
	}
	
	
}


