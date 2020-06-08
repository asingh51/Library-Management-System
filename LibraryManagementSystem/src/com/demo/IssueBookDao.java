package com.demo;
import java.sql.*;
import java.util.Date;

import javax.swing.JTextField;

public class IssueBookDao {

	
	public static int save(String issueId,String memberssn,String staffssn,String isbn,  int dUE_PERIOD, int gRACE_PERIOD, int cHECK_OUT_PERIOD, String bookStatus){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO ISSUE_BOOK VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,issueId);
			ps.setString(2,memberssn);
			ps.setString(3,staffssn);
			ps.setString(4,isbn);
			ps.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			Date kini = new Date();
			java.sql.Date returnDate = new java.sql.Date(kini.getTime() + cHECK_OUT_PERIOD*24l*60l*60l*1000l);
			java.sql.Date noticeDate = new java.sql.Date(kini.getTime() + (cHECK_OUT_PERIOD+gRACE_PERIOD)*24l*60l*60l*1000l);
		    java.sql.Date dueDate = new java.sql.Date(kini.getTime() + (cHECK_OUT_PERIOD+gRACE_PERIOD+dUE_PERIOD)*24l*60l*60l*1000l);
		    ps.setDate(6, returnDate);
		    ps.setDate(7, noticeDate);
		    ps.setDate(8, dueDate);
		    ps.setString(9, bookStatus);
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
			String sql = "SELECT * FROM ISSUE_BOOK";
			return stmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void returnBook(String text) {
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("UPDATE ISSUE_BOOK set status='Returned' where ISSUE_ID=?");
			ps.setString(1,text);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ResultSet getAllVerbalinfoFromIssueId(String string) {
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select b.isbn, ib.issue_date, count(*) as number_of_copies, datediff(ib.due_date,\r\n" + 
					"ib.issue_date) as no_of_days, b.author, b.title, lm.ssn, lm.name from issue_book as ib,\r\n" + 
					"member as lm, book as b where b.isbn=ib.isbn\r\n" + 
					"and lm.ssn=ib.member_ssn and ib.issue_id=?");
			ps.setString(1,string);
			ResultSet rs= ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet getIssueBooksInfolastDates(String date1, String date2) {
		
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT b.isbn, ib.issue_date, datediff(ib.due_date,ib.issue_date) as no_of_days, b.author, b.subject FROM LBS.ISSUE_BOOK as ib, LBS.book as b,LBS.member as m where ib.ISSUE_DATE between ? and ? and b.isbn=ib.isbn and m.ssn=ib.member_ssn;");
			ps.setString(1,date1);
			ps.setString(2,date2);
			ResultSet rs= ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
