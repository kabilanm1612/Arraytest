package test;


import java.util.Scanner;

public class Employee {
//Declaration Part
	static int no;
	static String[] name;
	static Scanner sc = new Scanner(System.in);
	static int[] worktime;
	static int[] actWorkHours;
	static int[] otSalary;
	static int[] overTime;

	public Employee() { // Array Initialization
		System.out.println("Enter  Number Of Employees\n\n");
		no = sc.nextInt();
		name = new String[no];
		worktime = new int[no];
		actWorkHours = new int[no];
		otSalary = new int[no];
		overTime=new int[no];
		for(int i=0;i<no;i++) {
			overTime[i]=0;
			otSalary[i]=0;
		}

	}
//Method Calling
	public static void main(String[] args) {
		Employee mng = new Employee();
		mng.empName();
		mng.wrkHrs();
		mng.calculateSalary();
		mng.showSalary();

	}

	//Method for Salary Calculation
	private void calculateSalary() 
	{
		for(int i=0;i<no;i++) 
		{
			if(overTime[i]>0) 
			{
				otSalary[i]=(overTime[i]*150);
			}
			
		}
	
		
	}
//method For WorkHours Calculation
	private void wrkHrs() 
	{
		System.out.println("Enter Work Hours \n \n");
		for(int i=0;i<no;i++) 
		{
			System.out.println("Enter WorkHour For Employee "+(i+1));
			worktime[i]=sc.nextInt();
			if(worktime[i]<=60 && worktime[i]>=40) 
			{
				actWorkHours[i]=40;
				overTime[i]=worktime[i]-40;
			}
			else if(worktime[i]>60) 
			{
				actWorkHours[i]=40;
				overTime[i]=20;
			}
			else {
				actWorkHours[i]=worktime[i];
			}
			
		}

	}
//method for Display the salary
	private void showSalary()
	{
		System.out.println("No\tWorkhour\tSalary\tOT\tName");
		for(int i=0;i<no;i++) 
		{
			System.out.println((i+1)+"\t"+actWorkHours[i]+"\t\t"+((actWorkHours[i]*100)+otSalary[i])+"\t"+overTime[i]+"\t"+name[i]);
		}
		
		
	}
//method for reading the employee name
	private void empName() {
		for (int i = 0; i < no; i++) {
			System.out.println("Enter  Name "+(i+1));
			name[i] = sc.next();
		}

	}

}