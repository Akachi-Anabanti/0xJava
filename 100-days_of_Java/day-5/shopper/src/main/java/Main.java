package shopper.src.main.java;

import java.util.Scanner;

import shopper.src.main.java.handlers.UserCRUD;


public class Main {
    private final Scanner scanner;
    private final UserCRUD userCRUD;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.userCRUD = new UserCRUD(scanner);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the User Management System!");
        new Main().start();
        System.out.println("Thank you for your time, see you soon!");
    }

    private void start() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 0:
                    userCRUD.listAllUsers();
                    break;
                case 1:
                    userCRUD.createUser();
                    break;
                case 2:
                    userCRUD.updateUser();
                    break;
                case 3:
                    userCRUD.deleteUser();
                    break;
                case 4:
                    userCRUD.deleteAllUsers();
                    break;
                case 5:
                    userCRUD.getUserInfo();
                    break;
                case 10:
                    userCRUD.saveToDB();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Please enter a valid response");
                    continue;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- User Management System ---");
        System.out.println("0: List all users");
        System.out.println("1: Create a User");
        System.out.println("2: Update a User Info");
        System.out.println("3: Delete a user");
        System.out.println("4: Delete all users");
        System.out.println("5: Get a User Detail");
        System.out.println("10: Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please try again.");
            scanner.next(); // Consume the invalid input
        }
        return scanner.nextInt();
    }
}