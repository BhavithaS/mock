package com.dao;
//
import java.sql.*;
import java.util.*;
import java.io.*;//
import java.sql.Connection;

public class DBConnectionManager {

	private static Connection con = null;
	//
	private static Properties props = new Properties();//

	public static Connection getConnection() 
	{
		try {
			FileInputStream fs = null;
			fs = new FileInputStream("database.properties");
			props.load(fs);
			
			Class.forName(props.getProperty("drivername"));
			con = DriverManager.getConnection(props.getProperty("url"),props.getProperty("username"),props.getProperty("password"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	    
 		return con;	
	}
}
