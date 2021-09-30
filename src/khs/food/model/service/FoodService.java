package khs.food.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import khs.common.db.JDBCTemplate;
import khs.food.model.dao.FoodDao;
import khs.food.model.dto.Food;


public class FoodService {

	private FoodDao foodDao = new FoodDao();
	private JDBCTemplate template = JDBCTemplate.getInstance(); 
	private List<Food> foodList = new ArrayList<>();
	
	public List<Food> searchFood(String khCenter) {
		
		String result = null;
		Connection conn = template.getConnection();

		try {
			foodList = foodDao.checkNickName(khCenter, conn);
			template.commit(conn);
		} catch (Exception e) {
			template.rollback(conn);
			throw e;
		} finally {
			template.close(conn);
		}
		return foodList;
		
	}
	
	
}


