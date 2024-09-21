package shopper.src.main.java.stores;

import java.util.HashMap;
import java.util.Map;

import shopper.src.main.java.models.User;

public class UserStore {
    /**
     * Using the Singleton design pattern
     * this ensures that only one instance of UserStoer exist
     * and it provides a public interface to access that instance
     */
    private static UserStore instance = new UserStore();
    private final Map<String, User> userMap;

    private UserStore () {
        userMap = new HashMap<String, User>();
    }

    public static UserStore getInstance(){
        return instance;
    }

    // add user to the HashMap
    public void saveUser(User user) {
        userMap.put(user.getId(), user);
        System.out.println("\nUser saved with ID: " + user.getId());
    }
    // remove user from HashMap
    public boolean removeUser(String id) {
        User rmvdUser = userMap.remove(id);
        if (rmvdUser != null) {
            return true;
        }
        return false;
    }

    public void removeAllUsers() {
        userMap.clear();
    }

    public int getUserCount() {
        return userMap.size();
    }

    public void showUsers(){
        
        if (userMap.size() == 0) {
            System.out.println("\nThere are no users yet!");
            return;
        }
        System.out.printf("\b\t\tTotal user count %d\n", getUserCount());
        int i = 0;
         for (Map.Entry<String, User> user: userMap.entrySet()) {
            System.out.printf("\t%d -> ID: %s Email: %s\n", i++, user.getKey(), user.getValue().getEmail());
         }
    }

    public boolean userExist(String Id) {
        return userMap.containsKey(Id);
    }

    public User getUser(String Id) {
        if (userExist(Id)) {
            return userMap.get(Id);
        }
        return null;
    }

    public Map<String, User> getStore() {
        return userMap;
    }
}
