package khs.main.model.dto;

import java.sql.Date;

public class Visit {
	private Date visitDate;
	private int visitCnt;
	
	public Visit() {
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public int getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(int visitCnt) {
		this.visitCnt = visitCnt;
	}

	@Override
	public String toString() {
		return "Visit [visitDate=" + visitDate + ", visitCnt=" + visitCnt + "]";
	}
	
	


}
