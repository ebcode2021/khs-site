package khs.myPage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import khs.common.code.MemberGrade;
import khs.common.db.JDBCTemplate;
import khs.common.exception.DataAccessException;
import khs.common.file.FileDTO;
import khs.myPage.model.dto.MyPage;
import khs.myPage.model.dto.ProfileImage;

public class MyPageDao {
	private JDBCTemplate template = JDBCTemplate.getInstance();

	public MyPage selectMyPage(Connection conn, String userId) {
		MyPage myPage = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		String query = "select * from member" + 
				" inner join lecture using(kh_code)" + 
				" inner join instructor using(instr_idx)" + 
				" where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				myPage = convertAllToMyPage(rset);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return myPage;
	}
	
	
	
	public int updateDetail(Connection conn, MyPage myPage) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update member set email=?, nickname=? where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, myPage.getEmail());
			pstm.setString(2, myPage.getNickName());
			pstm.setString(3, myPage.getUserId());
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	
		return res;
	}
	
	
	
	public int changePassword(Connection conn, String userId, String newPassword) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update member set password=? where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, newPassword);
			pstm.setString(2, userId);
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	
		return res;
	}
	
	
	public String nicknameDuplicatedTest(Connection conn, String newNickname) {
		PreparedStatement pstm = null; 
		String result = null;
		ResultSet rset = null; 
			
		try {
			String query = "SELECT NICKNAME FROM MEMBER WHERE NICKNAME = ?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, newNickname);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				result = rset.getString(1);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		return result;
	}


	
	public int deleteAccount(Connection conn, String userId) {
		int res = 0;
		PreparedStatement pstm = null;
		String query = "update member set is_leave=1 where user_id = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
	
		return res;
	}
	
	
	/*
	 * 
	 * public int profileImageUploadMember(Connection conn, String userId, FileDTO
	 * fileDTO) { int res = 0; String query =
	 * "update member set profile_image_idx=file_idx_increase.nextval where user_id = ?"
	 * ; PreparedStatement pstm = null;
	 * 
	 * try { pstm = conn.prepareStatement(query); pstm.setString(1, userId); res =
	 * pstm.executeUpdate();
	 * 
	 * }catch (SQLException e){ throw new DataAccessException(e); } finally {
	 * template.close(pstm); }
	 * 
	 * return res; }
	 * 
	 */
	
	
	
	public int profileImageUpload(Connection conn, String userId, FileDTO fileDTO) {
		
		int res = 0;
		String query = "insert into profile_image (PR_FL_IDX, USER_ID, ORIGIN_FILE_NAME, RENAME_FILE_NAME, SAVE_PATH)"
				+ " values(pr_file_idx_increase.nextval, ?, ?, ?, ?)";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			pstm.setString(2, fileDTO.getOriginFileName());
			pstm.setString(3, fileDTO.getRenameFileName());
			pstm.setString(4, fileDTO.getSavePath());
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
	}
	
	
	public ProfileImage profileImageDownload(Connection conn, String userId) {
		ProfileImage profileImage = null;
		String query = "select * from profile_image where user_id = ? and file_is_del = 0";
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			rset = pstm.executeQuery();
			
			if(rset.next()) {
				profileImage = convertAllToProfileImage(rset);
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e);
		} finally {
			template.close(rset, pstm);
		}
		
		return profileImage;
	}
	
	

	public int profileImageUpload(Connection conn, String userId) {
		int res = 0;
		String query = "update member set is_leave=1 where user_id = ?";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		
		return res;
	}

	
	
	public int profileImageDelete(Connection conn, String userId) {
		int res = 0;
		String query = "update profile_image set file_is_del=1 where user_id = ? and file_is_del=0";
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setString(1, userId);
			
			res = pstm.executeUpdate();
			
		}catch (SQLException e){
			throw new DataAccessException(e);
		} finally {
			template.close(pstm);
		}
		return res;
	}






	

	

	


	private ProfileImage convertAllToProfileImage(ResultSet rset) throws SQLException {
		ProfileImage profileImage = new ProfileImage();
		
		profileImage.setPrFlIdx(rset.getString("pr_fl_idx"));
		profileImage.setUserId(rset.getString("user_id"));
		profileImage.setOriginFileName(rset.getString("origin_file_name"));
		profileImage.setRenameFileName(rset.getString("rename_file_name"));
		profileImage.setSavePath(rset.getString("save_path"));
		profileImage.setFileIsDel(rset.getInt("file_is_del"));
		
		
		return profileImage;
	}



	//쿼리문으로 받아오는 속성 수 보다 아래 함수에서 저장하는 속성들이 더 많아지면, 오류남
	private MyPage convertAllToMyPage(ResultSet rset) throws SQLException {
		MyPage myPage = new MyPage();
		myPage.setUserId(rset.getString("user_id"));
		myPage.setKhCode(rset.getString("kh_code"));
		myPage.setBanGrade(rset.getString("ban_grade"));
		myPage.setPassword(rset.getString("password"));
		myPage.setEmail(rset.getString("email"));
		myPage.setGrade(MemberGrade.valueOf(rset.getString("grade")).GRADE);
		myPage.setRegDate(rset.getDate("reg_date"));
		myPage.setName(rset.getString("name"));
		myPage.setNickName(rset.getString("nickname"));
		myPage.setBirthDate(rset.getDate("birth_date"));
		myPage.setIsLeave(rset.getInt("is_leave"));

		myPage.setKhCenter(rset.getString("kh_center"));
		myPage.setVariFile(rset.getString("vari_file"));
		myPage.setClassName(rset.getString("class_name"));
		myPage.setStartDate(rset.getDate("start_date"));
		myPage.setFinalDate(rset.getDate("final_date"));
		myPage.setInstrName(rset.getString("instr_name"));

		return myPage;
	}



	
















	

}
