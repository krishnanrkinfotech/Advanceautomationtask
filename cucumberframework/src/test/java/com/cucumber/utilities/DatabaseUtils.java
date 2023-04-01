package com.cucumber.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseUtils {
	public static ResultSet data(String email, String password) throws ClassNotFoundException, SQLException 
	 { 

	 // Accessing driver from the JAR file
	 Class.forName("com.mysql.cj.jdbc.Driver"); 

	 // Creating a variable for the connection called "con"
	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");

	 // after localhost:3306 is where you will put the name of the database
	 // jdbc:mysql://localhost:3606/testdb ---> this is a database
	 // root is a database user and password too

	 // our query below
	 PreparedStatement statement = con.prepareStatement("SELECT email, password FROM login");

	 // creating variable to execute query
	 ResultSet result = statement.executeQuery(); 

	 // store all the rows data into one variable
	 ArrayList<String> sqlData = new ArrayList<String>(); 

	 while(result.next())
	 {
	   sqlData.add(email= result.getString("email"));
	   sqlData.add(password = result.getString("password")); 
	   break;
	 } 
	 return result;
	 
	
	 } 
	
	

}

