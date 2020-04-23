package com.cg.mysqljdbc;

import java.sql.*;

public class JdbcDriver 
{
	public static void main(String args[])
	{
		try 
		{
			Connection mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","7347");
			Statement stmt= mycon.createStatement();
			String sql= "insert into books(BookNum,BookName,AuthorName) values(241,'java','hamlin')";
			stmt.executeUpdate(sql);
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				System.out.println(rs.getString("BookName")+" "+rs.getString("AuthorName"));
			}
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
