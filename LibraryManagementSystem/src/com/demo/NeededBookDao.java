package com.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NeededBookDao {
	public static int save(String isbn,String booksNeeded){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO BOOKS_NEEDED VALUES (?, ?)");
			ps.setString(1,isbn);
			ps.setString(2,booksNeeded);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static List<ResultSet> getAll() {
		Connection con=DB.getConnection();
		Statement stmt=null;
		List<ResultSet> rsList= new ArrayList<ResultSet>();
		try {
			stmt=con.createStatement();
			String sql = "SELECT * FROM BOOKS_NEEDED";
			ResultSet rs = stmt.executeQuery(sql);
			  //STEP 5: Extract data from result set
			while(rs.next()){
			     //Retrieve by column name
//			     int id  = rs.getInt("id");
//			     int age = rs.getInt("age");
//			     String first = rs.getString("first");
//			     String last = rs.getString("last");
			     rsList.add(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rsList;
	}
}
