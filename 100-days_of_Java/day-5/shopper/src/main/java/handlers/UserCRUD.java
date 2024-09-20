package shopper.src.main.java.handlers;

import java.util.Scanner;

import shopper.src.main.java.models.User;
import shopper.src.main.java.stores.UserStore;

public class UserCRUD {

    private final UserStore userStore;
    private final Scanner scanner;

    public UserCRUD(Scanner scanner) {
        this.userStore = UserStore.getInstance();
        this.scanner = scanner;
    }
    
    public void createUser() {
        System.out.print("Enter <email> <password>: ");
        scanner.nextLine();
        String userCred = scanner.nextLine();
        String[] userCredList = userCred.split(" ");
        String emailString = userCredList[0];
        String passwordString = userCredList[1];
        User user = new User(emailString, passwordString);
        
        System.out.print("\n");
        user.toJson();

        System.out.print("\nDo you want to save this user? yes/no. default is yes: ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.isEmpty() || choice.equals("yes")) {
            user.save();
        } else if (choice.equals("no")) {
            System.out.println("\nUser was not saved");
            return;
        }
    }

    public void updateUser() {
        System.out.print("Enter <userId> <fieldName> <value>: ");
        scanner.nextLine();
        String updateFields = scanner.nextLine();
        String[] updateFieldList = updateFields.split(" ");

        if (updateFieldList.length != 3) {
            System.out.println("\nincorrect number of input parameters, please try again!");
            return;
        } 

        String userId = updateFieldList[0];
        String fieldName = updateFieldList[1];
        String fieldValue = updateFieldList[2];

        if (userStore.userExist(userId)) {
            User user = userStore.getUser(userId);

            switch (fieldName) {
                case "firstName":
                    user.setFirstName(fieldValue);
                    break;
                case "lastName":
                    user.setLastName(fieldValue);
                    break;
                case "email":
                    user.setEmail(fieldValue);
                default:
                    System.out.println("\nCan't update the specified field, only firstName, lastName and email");
                    return;
            }
            user.save();
            user.toJson();
            System.out.println("\nUser updated successfully.");

        } else {
            System.out.println("\nNo user found for this ID " + userId);
            return;
        }
    }

    // public void readUser() {
    //     System.out.print("Enter user ID: ");
    //     String userId = scanner.nextLine();
        
    //     userStore.getUser(userId).ifPresentOrElse(
    //         user -> System.out.println(user.toJson()),
    //         () -> System.out.println("User not found.")
    //     );
    // }

    public void deleteUser() {
    System.out.print("Enter user ID: ");
    scanner.nextLine();
        String userId = scanner.nextLine();
        
        if (userStore.removeUser(userId)) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}
