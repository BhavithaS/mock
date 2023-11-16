/*Test your application by invoking the service methods from the UserInterface class. 
You are free to write your own code in the main method to invoke the business methods 
to check its correctness. UserInterface class is not taken for evaluation. 
*/
package com.client;

import java.util.Scanner;

import com.service.LaptopService;

public class UserInterface {
	public static void main(String[] args) {
		LaptopService ppService = new LaptopService();
		boolean recordsInserted = false;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the number of laptop service records");
		int num=sc.nextInt();
		String s[]=new String[num];
		System.out.println("Enter the laptop service details");
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			s[i]=sc.nextLine();
		}
			recordsInserted = ppService.addServiceList(s);
			if (recordsInserted)
				System.out.println("Read valid laptop service records and updated it to the database");
			else
				System.out.println("Failed to add records to the database");
			sc.close();
	}
}
	 	  	  		    	  	      	      	 	