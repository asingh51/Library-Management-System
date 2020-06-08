package com.demo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ValueListDao {
	public static Map<String, Integer> fetchAll()
	{
		Map valueList= new HashMap<>();
		try {
			Connection con=DB.getConnection();
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from VALUELIST");  
			while(rs.next())  
			{
				valueList.put(rs.getString(1), Integer.parseInt(rs.getString(2)));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valueList;
		
	}
}
