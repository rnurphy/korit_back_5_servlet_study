package com.study.servlet_study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.config.DBConnectionMgr;
import com.study.servlet_study.entity.Author;

public class DBConnectionTestMain {
	public static void main(String[] args) {
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		// finally { freeConnection() } 대비해서 전역으로 다 변수 빼주기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "select * from author_tb where author_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "");
			
			rs = pstmt.executeQuery();	// Ctrl + Enter
			
			List<Author> authorList = new ArrayList<>();
			
			while(rs.next()) {
				authorList.add(Author.builder()
						.authorId(rs.getInt(1))
						.authorName(rs.getString(2))
						.build());
			}
			
			authorList.forEach(author -> System.out.println(author));
			
//			while(rs.next()) {	// row(행) 검사
//				System.out.println("id: " + rs.getInt(1));		// column(열) 검사
//				System.out.println("name: " + rs.getString(2));
//			}
			
//			System.out.println(connection.getSchema());
		} catch (Exception e) {	// getConnection에서 자동완성할때 Exception e 자동으로 생성
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
	}

}
