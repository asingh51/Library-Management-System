package com.demo;
import java.sql.*;

public class InLibraryBookDao {
	public static int save(String isbn,String canRent,String noOfCopies,String rentedCopies, String bookDesc){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO BOOK_IN_LIBRARY VALUES (?, ?, ?, ?, ?)");
			ps.setString(1,isbn);
			ps.setString(2,canRent);
			ps.setString(3,noOfCopies);
			ps.setString(4,rentedCopies);
			ps.setString(5,bookDesc);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
}
