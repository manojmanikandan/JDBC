package com.cg.mysqljdbc;

import java.sql.*;

public class Employee 
{
	public static void main(String args[]) throws SQLException
	{
		PreparedStatement mystmnt= null;
		ResultSet myRes= null;
		
			try 
			{
				Connection mycon= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","7347");
				Statement mystmt= mycon.createStatement();
				mystmnt = mycon.prepareStatement("select * from employees where salary >? or  department=? or email=?");
				mystmnt.setDouble(1,33000);
				mystmnt.setString(2,"Engineering");
				String pdept= "HR";
				int increaseAmount=10000;
				
				System.out.println("Salaries before\n");
				showSalaries(mycon, pdept);
				
				mystmnt =mycon.prepareCall("{call increase_salaries_fot_department(?,?)}");
				
				//set the parameters
				
				mystmnt.setString(1, pdept);
				mystmnt.setDouble(2, increaseAmount);
				
				//call Stores Procedures
				System.out.println("\n calling increased stored procedure. increase_salaries_fot_department(' "+ pdept + " '," + increaseAmount + ")");
				mystmnt.execute();
				System.out.println("Finished calling stored procedure");
				
				
				System.out.println("\n\n Salaries AFTER\n");
				showSalaries(mycon, pdept);
				
			
				
			} 
			catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			finally
			{
				if(myRes != null)
				{
					myRes.close();
				}
				if(mystmnt != null)
				{
					mystmnt.close();
				}
			}
			
	
	}
	private static void display(ResultSet myRes) throws SQLException
	{
		while(myRes.next())
		{
			String lastName = myRes.getString("last_name");
			String firstName = myRes.getString("first_name");
			double salary = myRes.getDouble("salary");
			String department = myRes.getString("department");
			
			System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, salary, department);
		}
	}
	private static void showSalaries(Connection mycon, String pdept) 
	{
		
		PreparedStatement mystmt= null;
		ResultSet myRs= null;
		try
		{
			
			mystmt = mycon.prepareStatement("select * from employees where department=?");
			mystmt.setString(1, pdept);
			
			myRs = mystmt.executeQuery();
			
			while (myRs.next())
			{
				String lastName = myRs.getString("last_name");
				String firstName = myRs.getString("first_name");
				double salary = myRs.getDouble("salary");
				String department = myRs.getString("department");
				
				System.out.printf("%s, %s, %s, %.2f\n", lastName, firstName, salary, department);
			}
		 }
		 catch(Exception exc)
		 {
			 exc.printStackTrace();
		 }
		 finally
		 {
			 close(mystmt, myRs);
		 }
	}
	private static void close(PreparedStatement mystmt, ResultSet myRs)
	{
		
		
	}
}
