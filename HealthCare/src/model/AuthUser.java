package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnection;

public class AuthUser {
 	public static boolean auth(String username, String password) {
	try {
		Connection con = DBConnection.connect();
		if (con == null) {
			
			
		}
		// create a prepared statement
		String query = "SELECT * FROM users where username='"+username+"' and password='"+password+"'";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
	
	   	preparedStmt.execute();
//execute the statement
		  ResultSet rs = preparedStmt.executeQuery(query);
		 
		  if(rs.next()) {
			  con.close();
			  return true;
		  }
		  con.close();
		  
		  
	} catch (Exception e) {
				
				System.err.println(e.getMessage());
			}
		return false;
	}
	

}
