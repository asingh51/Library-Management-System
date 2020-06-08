package com.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffDao {

	
	public static int save(String ssn,String name,String Type){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO STAFF VALUES (?, ?, ?)");
			ps.setString(1,ssn);
			ps.setString(2,name);
			ps.setString(3,Type);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static List<String> getAllStaddId() {
		Connection con=DB.getConnection();
		Statement stmt=null;
		List<String> rsList= new ArrayList<String>();
		try {
			stmt=con.createStatement();
			String sql = "SELECT * FROM STAFF";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			     rsList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsList;
	}
	
	public static ResultSet getAll() {
		Connection con=DB.getConnection();
		Statement stmt=null;
		try {
			stmt=con.createStatement();
			String sql = "SELECT * FROM STAFF";
			return stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
