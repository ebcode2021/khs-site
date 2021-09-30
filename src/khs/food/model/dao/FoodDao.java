package khs.food.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.food.model.dto.Food;

public class FoodDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();

	public List<Food> checkNickName(String khCenter, Connection conn) {

		PreparedStatement pstm = null;
		ResultSet rset = null;	
		Food food = new Food(); 
		List<Food> foodList = new ArrayList<>();
		
		
		try {
			// qeury문 실행 결과 필요 
			String query = "SELECT * FROM LECTURE L"
					+ " JOIN BOARD_RESTAURANT B ON "
					+ " (L.KH_CENTER = B.KH_CENTER) " 
					+" WHERE L.KH_CENTER = ? AND KH_CODE = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, khCenter);
			pstm.setString(2, "JAVA001");
			// 4. DQL을 통해 성공여부를 반환받음, 성공시 값 반환
			System.out.println(query);
			rset = pstm.executeQuery();
		
			// 이 반환되는 값이 특정 List에 들어가야 함 
			while (rset.next()) {
				food = this.convertAllToFood(rset);
				System.out.println("3. Dao단 진입(joinDao), foodDTO를 전달받음" +  food.toString());
				foodList.add(food);
			}
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		return foodList;
	}

	// 쿼리문으로 받아오는 속성 수 보다 아래 함수에서 저장하는 속성들이 더 많아지면, 오류남
	private Food convertAllToFood(ResultSet rset) throws SQLException {
		Food food = new Food();
		
		food.setHpIdx(rset.getString("HP_IDX"));
		food.setKhCenter(rset.getString("KH_CENTER"));
		food.setStImg(rset.getString("ST_IMG"));
		food.setStName(rset.getString("ST_NAME"));
		food.setStMenu(rset.getString("ST_MENU"));
		food.setStDescription(rset.getString("ST_DESCRIPTION"));
		food.setHipIsDel(rset.getInt("HIP_IS_DEL"));
	
		return food;
	}

}
