package khs.main.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;

public class VisitDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public int getTodayVisitCnt(Connection conn) {
		//오늘 날짜 구하기
		Calendar cal = new GregorianCalendar();
		Date date = new Date(cal.getTimeInMillis());
		
		PreparedStatement pstm = null;
		int res = 0;
		// 테이블 명 : visited 칼럼이름 : visit_date, visit_count
		int todayCnt = 0;
		String query = "select visit_count from visited where substr(to_char(visit_date),1,9)=to_date(?,'yy/MM/dd')";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setDate(1, date);
			res = pstm.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(pstm);
		}
		
		if(res==0) {//만약 검색된 결과가 없다면(==오늘 날짜 컬럼이 없다면) 만들어주고 1명 리턴
			createTodayVisitCnt(conn);
			System.out.println("todayCnt의 값은" + todayCnt);
			return (todayCnt+1);
		}else {//검색된 결과가 있다면 그대로 넘겨주기
			setTodayVisitCnt(conn);
			System.out.println("검색된 결과가 있습니다.");
			return (todayCnt+1);
		}
	}
	
	public int setTodayVisitCnt(Connection conn) {
		int res =0;
		CallableStatement cstm = null;
	
		String pro = "{call VISIT_TODAY(to_date(sysdate,'yy/MM/dd'))}";
		
		try {
			cstm = conn.prepareCall(pro);
			res = cstm.executeUpdate();
		}catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(cstm);
		}
		return res;
	}
	
	public void createTodayVisitCnt(Connection conn) {
		CallableStatement cstm = null;
		String query ="{call VISIT_TODAY_CREATE}";
		
		try {
			cstm = conn.prepareCall(query);
			cstm.execute();
			
		}catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(cstm);
		}
	}
	
	public int getAllVisitCnt(Connection conn) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		int res = 0;
		String query ="select sum(visit_count) from visited";
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			while(rset.next()) {
				res+= rset.getInt(1);
			}
		}catch (SQLException e) {
			throw new DataAccessException(e);
		}finally {
			template.close(rset,pstm);
		}
		return res;
	}

}
