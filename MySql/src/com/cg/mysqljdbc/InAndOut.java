package com.cg.mysqljdbc;

import java.sql.*;

public class InAndOut 
{
	public static void main(String[] args) throws SQLException 
	{
	     PreparedStatement myStmnt= null;
	     ResultSet myRes = null;

	    	 try 
	    	 {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","7347");
				 String pdept = "HR";
				 myStmnt =myConn.prepareCall("{call greet_the_department(?)}");
				 myStmnt.registerOutParameter(1,100);
			 } 
	    	 catch (SQLException e) 
	    	 {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
	}     
}
