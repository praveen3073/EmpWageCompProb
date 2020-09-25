

public class empwageprob {
	static final int IS_FULL_TIME = 1;
	static final int IS_PART_TIME = 2;
	static final int EMP_RATE_PER_HOUR = 20;
	static final int NUM_OF_WORKING_DAYS = 20;
	static final int NUM_OF_WORKING_HOURS = 100;
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation Program");
		System.out.println("Monthly Employee Wage: " + calcMonthlyEmployeeWage());
	}
	public static int calcMonthlyEmployeeWage()
	{
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0;
		for(int day=0, hours=0;day<NUM_OF_WORKING_DAYS && hours<NUM_OF_WORKING_HOURS; day++)
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
			empWage = empHrs * EMP_RATE_PER_HOUR;
			totalEmpWage += empWage;
			System.out.println("Emp Wage: " + empWage);
		}
		return totalEmpWage;
	}
}
