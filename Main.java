import java.util.ArrayList;
import java.util.Scanner;
public class Main extends Budget{
	
	Main(double paycheck, String name, double group_percentage) {
		super(paycheck, name, group_percentage);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.print("Welcome to the Income Budget Calculator!\nWhat was the amount of your last paycheck: ");
		Scanner scanner = new Scanner(System.in);
		double paycheck = scanner.nextDouble();
		ArrayList <Budget> groups = new ArrayList<Budget>();
		Budget user;

		double total_percentage = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("How many groups do you want: ");
		int group_number = sc.nextInt();
		for (int a = 0; a < group_number; a++) {
			System.out.print("What is the name of Group " + (a + 1) + ": ");
			String group_name = scanner.next().toUpperCase();
			System.out.print("What is the percentage that you want to put in this group?: ");
			double percentage = scanner.nextDouble();
			
			total_percentage = total_percentage + percentage;
			user = new Budget(paycheck, group_name, percentage);
			groups.add(user);
			if (total_percentage > 100) {
				total_percentage = change(total_percentage, groups.size(), groups);	
			}
			
			
			
		}
	
		double leftover_calculation = paycheck * ((100-total_percentage) / 100);
		int temp = (int)leftover_calculation * 100;
		leftover_calculation = (double)temp / 100;
		print(groups, group_number, leftover_calculation, paycheck);

	}
	
	static void print (ArrayList<Budget> groups, double group_number, double leftover_calculation, double paycheck) {
		for (int a = 0; a < group_number; a++) {
			System.out.println("The amount you need to save for Group: " + groups.get(a).groupName + "(%" + groups.get(a).percentage + ") is: $" + groups.get(a).Calculation(paycheck, groups.get(a).percentage));
			System.out.println("The amount that is left over is: $" + leftover_calculation);
		
		}
	}
}