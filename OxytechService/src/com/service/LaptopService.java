package com.service;
import java.util.ArrayList;
import java.util.List;

import com.dao.LaptopDAO;
import com.model.Laptop;
import com.util.ApplicationUtil;

public class LaptopService {

	public static List <Laptop> buildServiceList(List <String> serviceRecords) {

		List <Laptop> objectList = new ArrayList<Laptop>();
		for(String service : serviceRecords) {
			String[] part = service.split(":");
			Laptop laptop = new Laptop();
			laptop.setHardwareId(part[0]);
			laptop.setLaptopName(part[1]);
			laptop.setReceivedDate(ApplicationUtil.stringToDateConverter(part[2]));
			laptop.setRootIssue(part[3]);
			laptop.setIssueIntensity(part[4]);
			laptop.setBillAmount(calculateBillAmount(laptop.getRootIssue(), laptop.getIssueIntensity()));
			objectList.add(laptop);
		}
		
		return objectList;
	}

	public boolean addServiceList(String[] input)	{

		// FILL THE CODE HERE
		ApplicationUtil applicationUtil = new ApplicationUtil();
		List<String> stringList = applicationUtil.extractDetails(input);
		List<Laptop> laptopObjs = buildServiceList(stringList);
		LaptopDAO dao = new LaptopDAO();
		int insertedLaps = dao.insertServiceList(laptopObjs);
		if(insertedLaps== laptopObjs.size()) {
			return true;
		}
		
		return false;
	}
	
	public static double calculateBillAmount(String rootIssue,String issueIntensity)
	{
		double billAmount = 0.0;
		switch (rootIssue.toLowerCase()){
		case "software": {
			billAmount += 2000;
			break;
		}
		case "display" :{
			billAmount += 5000;
			break;
		}
		case "keyboard" :{
			billAmount += 1000;
			break;
		}
		case "sound" :{
			billAmount += 800;
			break;
		}
		case "key" :{
			billAmount += 500;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + rootIssue);
		}
		
		switch (issueIntensity.toLowerCase()) {
		case "low" :{
			billAmount *= 0.95;
			break;
		}
		case "mid" :{
			billAmount *= 1.05;
			break;
		}
		case "high" :{
			billAmount *= 1.1;
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + issueIntensity);
		}
		
		return billAmount;
	}

}

