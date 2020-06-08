package com.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	public static int save(String isbn,String title,String author,String subject, String language,String bind, String edition){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO BOOK VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,isbn);
			ps.setString(2,title);
			ps.setString(3,author);
			ps.setString(4,subject);
			ps.setString(5,language);
			ps.setString(6,bind);
			ps.setString(7,edition);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static ResultSet getAll() {
		Connection con=DB.getConnection();
		Statement stmt=null;
		try {
			stmt=con.createStatement();
			String sql = "SELECT * FROM Book";
			return stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getAllISBN() {
		Connection con=DB.getConnection();
		Statement stmt=null;
		List<String> rsList= new ArrayList<String>();
		try {
			stmt=con.createStatement();
			String sql = "SELECT * FROM BOOK";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			     rsList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsList;
	}
}
