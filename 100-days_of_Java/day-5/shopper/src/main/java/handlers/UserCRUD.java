package shopper.src.main.java.handlers;

import java.util.Scanner;

import shopper.src.main.java.Database.DB;
import shopper.src.main.java.models.User;
import shopper.src.main.java.stores.UserStore;

public class UserCRUD {

    private final UserStore userStore;
    private final Scanner scanner;

    public UserCRUD(Scanner scanner) {
        this.userStore = UserStore.getInstance();
        this.scanner = scanner;
    }

    public void getUserInfo() {
        System.out.print("\n Enter user ID:");
        scanner.nextLine();
        String userID = scanner.nextLine();
        if (userStore.userExist(userID)) {
            User user = userStore.getUser(userID);
            System.out.println(user.toJson());
        }
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
        System.out.println(user.toJson());

        System.out.print("\nDo you want to save (temp) this user? yes/no. default is yes: ");
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

    public void deleteUser() {
    System.out.print("Enter user ID: ");
    scanner.nextLine();
        String userId = scanner.nextLine();
        
        if (userStore.removeUser(userId)) {
            System.out.println("\bUser deleted successfully.");
            return;
        } else {
            System.out.println("User not found.");
            return;
        }
    }

    public void listAllUsers() {
        userStore.showUsers();
        return;
    }

    public void deleteAllUsers() {
        System.out.print("\n This removes users from cache but does not remove from DB,\n\t continue ? yes/no: default: no");
        scanner.nextLine();
        String choice = scanner.nextLine();
        if (choice.equals("yes")){
            userStore.removeAllUsers();
            return;
        }
        return;
    }

    public void saveToDB() {
        System.out.println("\nSave changes to DB ? yes/no: default: yes");
        scanner.nextLine();
        String choice = scanner.nextLine();
        if (choice.isBlank() || choice.equals("yes")) {
            DB.save(userStore.getStore());
            return;
        }
        return;
    }
}
