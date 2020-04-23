package com.cg.mysqljdbc;

import java.sql.*;

public class MetaData 
{
	public static void  main(String[]args) throws SQLException     
	{         
		Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","7347");               
		Statement stmt=myConn.createStatement();         
		DatabaseMetaData dbmd=myConn.getMetaData();       
		System.out.println("DB name"+dbmd.getDatabaseProductName());      
		System.out.println("DB version"+dbmd.getDatabaseProductVersion());  
		System.out.println("DB Driver name"+dbmd.getDriverName());      
		System.out.println("DB Driver Version"+dbmd.getDriverVersion()); 
		System.out.println("===Tables====");         
		String t[]= {"TABLE"};        
		ResultSet rs=dbmd.getTables(null, null,null, t);       
		while(rs.next())       
		{            
			System.out.println(rs.getString("TABLE_NAME"));     
		}              
	}
	
}
