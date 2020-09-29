import java.util.*;

interface EmployeeWage {
	public static int calcMonthlyEmployeeWage(Company comp) {
		return 0;
	}
}
public class empwageprob implements EmployeeWage{
	static final int IS_FULL_TIME = 1;
	static final int IS_PART_TIME = 2;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.print("Enter number of companies to add: ");
		int numberOfCompanies = in.nextInt();
		in.nextLine();
		ArrayList<Company> companyList = new ArrayList<Company>();
		for(int i = 0; i<numberOfCompanies; i++)
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
			companyList.add(comp);
		}
		System.out.print("Enter the company name to query: ");
		String queryCompanyName = in.nextLine();
		getTotalWageForCompany(queryCompanyName, companyList);
		in.close();
	}
	public static int calcMonthlyEmployeeWage(Company comp)
	{
		int dailyEmpHrs = 0;
		int dailyEmpWage = 0;
		int totalEmpWage = 0;
		for(int day=1, hours=0;day<=comp.TOTAL_MONTHLY_WORKING_DAYS && hours<comp.TOTAL_MONTHLY_WORKING_HOURS; day++)
		{
			int empCheck = (int) Math.floor(Math.random()*10)%3;
			switch(empCheck)
			{
				case IS_PART_TIME: 
					dailyEmpHrs = 4;
					break;
				case IS_FULL_TIME:
					dailyEmpHrs = 8;
					break;
				default:
					dailyEmpHrs = 0;
			}
			hours += dailyEmpHrs;
			dailyEmpWage = dailyEmpHrs * comp.EMP_RATE_PER_HOUR;
			totalEmpWage += dailyEmpWage;
			System.out.println("Day: " + day + ", Hours worked: " + dailyEmpHrs + ", Employee wage: " + dailyEmpWage);
			comp.dailyWageList.add(dailyEmpWage);
		}
		return totalEmpWage;
	}
	public static void getTotalWageForCompany(String queryCompanyName, ArrayList<Company> companyList)
	{
		for(int i=0; i<companyList.size(); i++)
		{
			if(companyList.get(i).companyName.equals(queryCompanyName))
			{
				System.out.println("The total employee wage for " + queryCompanyName + " is : " + companyList.get(i).totalEmpWage);
				return;
			}
		}
		System.out.println("Company doesn't exist");
	}
}
