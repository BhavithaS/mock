package com.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.exception.InvalidLaptopException;

public class ApplicationUtil {

	public static List<String> extractDetails(String[] input) {
	    List<String> stringList = new ArrayList<String>();
	    
	    for(String s: input) {
	    	String[] parts = s.split(":");
	    	try {
	    		if(validateLaptopName(parts[1])) {
		    		for(String p:parts) {
		    			stringList.add(s);
		    		}
		    	}
	    	}catch(InvalidLaptopException e) {
	    		System.out.println("Application Util catch block");
	    	}	
	    }
	   	 return stringList;
	}

	public static boolean validateLaptopName(String laptopName) throws InvalidLaptopException{
		String[] laps = {"Apple","Dell","HP","Lenovo","Acer"};
		List<String> laptopsAvailable = Arrays.asList(laps);
		if(laptopsAvailable.contains(laptopName)){
			return true;
		}else {
			throw new InvalidLaptopException("Invalid laptop");
		}
	}

	public static java.util.Date stringToDateConverter(String stringDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date = formatter.parse(stringDate);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
	java.sql.Date date = new java.sql.Date(utDate.getTime());
	return date;
	}	 
	 	  	  		    	  	      	      	 	

}