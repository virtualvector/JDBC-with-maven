package com.socgen.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
			//Load the jdbc driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the connection
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/socGenDetails?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","");
			
			// Write the query to execute
			//String qryFetch = "select user_ID, user_Name from userDetails where user_ID = 1";
			
			//Create the Statement
			//java.sql.Statement stmt = dbCon.createStatement();
			
			//execute the query and get the results in a ResultSet object
			//ResultSet rs = stmt.executeQuery(qryFetch);
			
			//Traverse through the resutset
//			while(rs.next()) {
//				System.out.print("ID: " + rs.getInt("user_ID"));
//				System.out.println("Name: " + rs.getString("user_Name"));
////				System.out.println(", Address: " + rs.getString("user_Address"));
//			}
			
			
			
			//Code for inserting through java code:
		
			
			//Create the Scanner
			Scanner scan = new Scanner(System.in);
			
			//Get the values
			System.out.println("Enter your Name");
			String userName =  scan.nextLine();
			
			System.out.println("Enter your Address");
			String userAddress =  scan.nextLine();
					
			// Write the query to insert
			String insertQry = "insert into userDetails(user_Name, user_Address) values ('" + userName +"', "
			+ "'" + userAddress + "')";
			
			//Create the Statement
			java.sql.Statement stmt = dbCon.createStatement();
			
			//Execute the query
			if(stmt.executeUpdate(insertQry) > 0) {
				System.out.println("Account created successfully...");
			}
			else
				System.out.println("Some issues while creating the account, please try again later...");
			
			
			
			

			// Write the query to execute
			String qryFetch = "select user_Address, user_Name from userDetails";
			
			//Create the Statement
			java.sql.Statement stmt1 = dbCon.createStatement();
			
			//execute the query and get the results in a ResultSet object
			ResultSet rs = stmt1.executeQuery(qryFetch);
			
			//Traverse through the resutset
			while(rs.next()) {
				
				System.out.println("Name: " + rs.getString("user_Name"));
				System.out.println(", Address: " + rs.getString("user_Address"));
		}
			
			
			
			//Close the connection
			dbCon.close();
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Driver not configured..." + e.getMessage());
		} catch (SQLException e) {
			
			System.out.println("Unable to connect to db:socGenDetails" + e.getMessage());
		}

    }
}
