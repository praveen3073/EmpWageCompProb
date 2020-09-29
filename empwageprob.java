import java.util.*;

public class empwageprob {
	static final int IS_FULL_TIME = 1;
	static final int IS_PART_TIME = 2;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.print("Enter number of companies to add: ");
		int numberOfCompanies = in.nextInt();
		in.nextLine();
		while(numberOfCompanies--!=0)
		{
			Company comp = new Company();
			System.out.print("Enter company name: ");
			comp.companyName = in.nextLine();
			System.out.print("Enter total monthly working hours: ");
			comp.TOTAL_MONTHLY_WORKING_HOURS = in.nextInt();
			in.nextLine();
			System.out.print("Enter total monthly working days: ");
			comp.TOTAL_MONTHLY_WORKING_DAYS = in.nextInt();
			in.nextLine();
			System.out.print("Enter wage rate per hour: ");
			comp.EMP_RATE_PER_HOUR = in.nextInt();
			in.nextLine();
			comp.totalEmpWage = calcMonthlyEmployeeWage(comp);
			System.out.println("Monthly Employee Wage For Company " + comp.companyName +" : "+ comp.totalEmpWage);
		}
	}
	public static int calcMonthlyEmployeeWage(Company comp)
	{
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0;
		for(int day=1, hours=0;day<=comp.TOTAL_MONTHLY_WORKING_DAYS && hours<comp.TOTAL_MONTHLY_WORKING_HOURS; day++)
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
			hours += empHrs;
			empWage = empHrs * comp.EMP_RATE_PER_HOUR;
			totalEmpWage += empWage;
			System.out.println("Day: " + day + ", Hours worked: " + empHrs + ", Employee wage: " + empWage);
		}
		return totalEmpWage;
	}
}
