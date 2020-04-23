package com.cg.mysqljdbc;
import java.sql.*;
public class DataBaseMetaDataExample 
{
	public static void main(String[] args) throws SQLException 
	{
		Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","7347");
		
		Statement stmt =mycon.createStatement();
		
		DatabaseMetaData dbmd= mycon.getMetaData();
		
		System.out.println("DB name "+dbmd.getDatabaseProductName());
		System.out.println("DB version "+dbmd.getDatabaseProductVersion());
		System.out.println("DB Driver name "+dbmd.getDriverName());
		System.out.println("====Tables=====");
		String t[] = {"TABLE"};
		ResultSet rs = dbmd.getTables(null, null, null, t);
		while(rs.next())
		{
			System.out.println(rs.getString("TABLE_NAME"));
		}
	}
}