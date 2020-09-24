import java.util.*;

public class empwageprob {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		final int IS_FULL_TIME = 1;
		final int IS_PART_TIME = 2;
		final int EMP_RATE_PER_HOUR = 20;
		final int NUM_OF_WORKING_DAYS = 20;
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0;
		for(int day=0;day<NUM_OF_WORKING_DAYS; day++)
		{
			int empCheck = (int) Math.floor(Math.random()*10)%3;
			switch(empCheck)
			{
				case IS_PART_TIME: 
					empHrs = 4;
					break;
				case IS_FULL_TIME:
					empHrs = 8;
					break;
				default:
					empHrs = 0;
			}
			empWage = empHrs * EMP_RATE_PER_HOUR;
			totalEmpWage += empWage;
			System.out.println("Emp Wage: " + empWage);
		}
		System.out.println("Total Emp Wage: "+totalEmpWage);
	}
}
