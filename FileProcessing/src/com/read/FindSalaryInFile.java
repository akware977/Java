package com.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * @auther - Akshay Ware
 * Class used to read files and search specific string in files
 * can find Max value 
 * 
 * */
public class FindSalaryInFile {

	public static void main(String[] args) {
		
		try {
			findSal();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void findSal() throws FileNotFoundException {
		
		Scanner scanFile = new Scanner(new File("Employee.txt"));
		NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter salary: ");
		int salary = scan.nextInt();
		if(salary < 100)
			System.out.println("The salary must be bigger than 100");
		else 
			if(salary > 900)
		{
			System.out.println("There is no employee has this salary.");					
		}
		int MaxSal = 0;	
		while(scanFile.hasNextLine())
		{
			String code = scanFile.next();
			String nextLine = scanFile.nextLine();
			
			int sal = Integer.parseInt(nextLine.substring(nextLine.lastIndexOf(" ")-3, nextLine.lastIndexOf(" ")));
			if(MaxSal<sal)
				MaxSal = sal;
			if(sal == salary) {
			    System.out.println(code + " "+  fmt.format(sal));			    		   
			}
		}	
		System.out.println("MaxSal is :" +MaxSal);
	}
	
}
