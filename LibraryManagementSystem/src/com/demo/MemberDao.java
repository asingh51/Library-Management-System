package com.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDao {

	
	public static int save(String ssn,String name,String cAddress,String hAddress, String PhNo,String CardNo, Boolean isProf){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,ssn);
			ps.setString(2,name);
			ps.setString(3,cAddress);
			ps.setString(4,hAddress);
			ps.setString(5,PhNo);
			ps.setString(6,CardNo);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date date = new java.sql.Date(utilDate.getTime());
			ps.setDate(7, date);
			ps.setBoolean(8, isProf);
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
			String sql = "SELECT * FROM MEMBER";
			return stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getAllMemberId() {
		Connection con=DB.getConnection();
		Statement stmt=null;
		List<String> rsList= new ArrayList<String>();
		try {
			stmt=con.createStatement();
			String sql = "SELECT * FROM MEMBER";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
			     rsList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rsList;
	}
	public static boolean isProf(String selectedItem) {
		Connection con=DB.getConnection();
		Boolean b= false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from MEMBER where SSN=?");
			ps.setString(1,selectedItem);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				if(rs.getBoolean(8))
				{
					b=true;
				}
			}
			    	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	public static void renewMemberShip(String text) {
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE MEMBER set card_date=? where SSN=?");
			Date kini = new Date();
			java.sql.Date renewedDate = new java.sql.Date(kini.getTime() + 4*365l*24l*60l*60l*1000l);
			ps.setDate(1,renewedDate);
			ps.setString(2,text);
			
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
