package testjdbcjava.tasks;

import java.util.Scanner;

public class TraineeDriver {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("------------: Welcome To Trainee Management Service :-----------");
		System.out.println("===============================================================");
		
		boolean flag = true;
		while(flag) {
			System.out.println("Menu Details:");
			System.out.println("Press 1 to register a trainee.");
			System.out.println("Press 2 to update a trainee.");
			System.out.println("Press 3 to delete a trainee.");
			System.out.println("Press 4 to fetchAll trainee.");
			System.out.println("Press 5 to close the application.");
			System.out.println("-------------------");
			
			//creating the object of the TraineeService Class to access the class and properties.
			TraineeService trService = new TraineeService();
			
			System.out.print("Enter a Choice: ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				int res = trService.register();
				if(res != 0) {
					System.out.println("Trainee registered successfully..!");
				} else {
					System.out.println("Trainee not registered...");
				}
				break;
				
			case 2:
				int uRes = trService.update();
				if(uRes != 0) {
					System.out.println("Trainee data updated...");
				} else {
					System.out.println("Trainee data not updated.");
				}
				break;
				
			case 3:
				int dRes = trService.remove();
				if(dRes != 0) {
					System.out.println("Trainee data deleted...");
				} else {
					System.out.println("Trainee data not deleted.");
				}
				break;
				
			case 4:
				System.out.println("Press 1 to display data by name: ");
				System.out.println("Press 2 to display data by age: ");
				int option = scanner.nextInt();
				if(option == 1) {
					trService.getByName();
				} else {
					trService.getByAge();
				}
				break;
				
			case 5:
				boolean exitRes = trService.exit();
				if(exitRes) {
					System.out.println("Application Closed Successfully. Thank You...💌");
				} else {
					System.out.println("Application Not Closed..!");
				}
				flag = false;
				scanner.close();
				break;
			default:
				System.out.println("Enter a valid choice, to proceed!");
			}
		}
	}
}
