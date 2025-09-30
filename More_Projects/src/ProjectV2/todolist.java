package ProjectV2;
import java.util.Scanner;
public class todolist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] tasks = new String[100];
		int taskCount = 0;
		while (true) {
			System.out.println("-- Task TO DO LIST --");
			System.out.println("1. Add Task");
			System.out.println("2. View Tasks");
			System.out.println("3. Exit");
			System.out.print("Choose a option: ");
			int choice = sc.nextInt();
			sc.nextLine(); // Consume newline
			// start of the task
			if (choice == 1 ) {
				System.out.print("Enter task: ");
				String task = sc.nextLine();
				System.out.println("Task added: " + task);
				tasks[taskCount] = task;
				taskCount++;
				// if u want to view your task u can view it
			} else if (choice == 2) {
				System.out.println("-- Your Task --");
				for (int i = 0; i < taskCount; i++) {
					System.out.println((i + 1) + ". " + tasks[i]);
					
				}
				} else if (choice == 3) {
					System.out.println("Exiting...");
					break;
				} else {
					System.out.println("Invalid option. Please try again.");
				}
			}
		}
	}
// end of the task
