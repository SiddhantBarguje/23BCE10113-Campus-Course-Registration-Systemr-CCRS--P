package edu.ccrm.cli;

import edu.ccrm.service.CCRMService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CCRMService service = CCRMService.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nCampus Course & Records Manager (CCRM)");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Enroll Student");
            System.out.println("4. Record Marks");
            System.out.println("5. Generate Transcript");
            System.out.println("6. Import/Export Data");
            System.out.println("7. Backup Data");
            System.out.println("0. Exit");
            int choice = -1;
            while (true) {
                System.out.print("Select option: ");
                String input = scanner.nextLine();
                try {
                    choice = Integer.parseInt(input.trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
            switch (choice) {
                case 1:
                    service.studentMenu(scanner);
                    break;
                case 2:
                    service.courseMenu(scanner);
                    break;
                case 3:
                    service.enrollMenu(scanner);
                    break;
                case 4:
                    service.recordMarksMenu(scanner);
                    break;
                case 5:
                    service.transcriptMenu(scanner);
                    break;
                case 6:
                    service.importExportMenu(scanner);
                    break;
                case 7:
                    service.backupMenu(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
        System.out.println("Exiting CCRM. Goodbye!");
    }
}
