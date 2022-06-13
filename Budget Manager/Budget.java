import java.util.ArrayList;
import java.util.Scanner;
public class Budget {
	public double paycheck;
	static Scanner sc = new Scanner(System.in);
	ArrayList<Budget> group;
	public String groupName;
	public int numberOfGroups;
	public double percentage;
	double calculation;
	Budget (double paycheck, String name, double group_percentage){
	this.paycheck = paycheck;
	this.groupName = name;
	this.percentage = group_percentage;
	this.calculation = Calculation(this.paycheck, this.percentage);
	}
	
	double Calculation(double paycheck, double percentage) {
		double calculation = paycheck * (percentage / 100);
		int temp = (int)calculation * 100;
		return calculation = (double)temp / 100;
		
		
	}
	public static double change (double total_percentage, double group_number, ArrayList<Budget> groups) {
		String group_name;
		while (total_percentage > 100) {
			System.out.println("Your total percentage is over 100% (" + (total_percentage) + "%)");
			System.out.print("Please enter the group you would like to change!: ");
			group_name = sc.next().toUpperCase();
			for (int b = 0; b < group_number; b++){
			if (group_name.compareTo(groups.get(b).groupName) == 0) {
				System.out.print("What would would you like to change the percentage to?: ");
				double percentage = sc.nextDouble();
				total_percentage = total_percentage - (groups.get(b).percentage - percentage);
				groups.get(b).percentage = percentage;
				
			}
			}
		}
		return total_percentage;
		
	}
}
