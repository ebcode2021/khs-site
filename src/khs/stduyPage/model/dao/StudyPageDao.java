package khs.stduyPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.stduyPage.model.dto.BoardStudy;

public class StudyPageDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();

	//2
	public List<BoardStudy> studyDatas(Connection conn) {
		PreparedStatement pstm = null;
		List<BoardStudy> studyDataBox = new ArrayList<>();
		
		ResultSet rset = null;
		
		BoardStudy boardStudy = new BoardStudy();
		
		String query = "select * from board_study order by ST_IDX asc";

		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				System.out.println(boardStudy);
				boardStudy = convertAllToBoardStudy(rset);
				// convertAllToBoardStudy 규격에 맞는 상자
				studyDataBox.add(boardStudy);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
		return studyDataBox;
		
	}

	
	//1
	private BoardStudy convertAllToBoardStudy(ResultSet rset) throws SQLException {
		BoardStudy boardStudy = new BoardStudy();
		boardStudy.setStIdx(rset.getString("ST_IDX"));
		boardStudy.setStLanguage(rset.getString("ST_LANGUAGE"));
		boardStudy.setStTitle(rset.getString("ST_TITLE"));
		boardStudy.setStTilteImg(rset.getString("ST_TITLE_IMG"));
		boardStudy.setStDescription(rset.getString("ST_DESCRIPTION"));
		boardStudy.setStStieLink(rset.getString("ST_SITE_LINK"));
		boardStudy.setStIsDel(rset.getInt("ST_IS_DEL"));
		return boardStudy;
	}
	
	
	
}