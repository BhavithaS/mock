package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import com.exception.InvalidLaptopException;
import com.util.ApplicationUtil;
import com.model.Laptop;

public class LaptopDAO {
	public static Connection connection= null;

	public int insertServiceList(List<Laptop> serviceList)  {
		int rows = 0;
		try {
			connection = DBConnectionManager.getConnection();
			String query = "INSERT INTO LAPTOP(HARDWARE_ID,LAPTOP_NAME,RECEIVED_DATE,ROOT_ISSUE,ISSUE_INTENSITY,BILL_AMOUNT) VALUES(?,?,?,?,?,?)";
			
			for(Laptop laptop : serviceList) {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, laptop.getHardwareId());
				preparedStatement.setString(2, laptop.getLaptopName());
				preparedStatement.setDate(3, ApplicationUtil.utilToSqlDateConverter(laptop.getReceivedDate()));
				preparedStatement.setString(4, laptop.getRootIssue());
				preparedStatement.setString(5, laptop.getIssueIntensity());
				preparedStatement.setDouble(6, laptop.getBillAmount());
				rows += preparedStatement.executeUpdate();
				preparedStatement.close();		
			
			connection.close();
			
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rows;
        
	}
}
	 	  	  		    	  	      	      	 	