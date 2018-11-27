/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.useraccount;

import business.employee.Employee;
import business.role.Role;
import java.util.Map;

/**
 *
 * @author vivekdalal
 */
public class UserAccountDirectory {

    private Map<String, UserAccount> userAccountDirectory;

    public Map<String, UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(Map<String, UserAccount> userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (Map.Entry<String, UserAccount> entry : userAccountDirectory.entrySet()) {
            UserAccount userAccount = entry.getValue();
            if (username.equalsIgnoreCase(userAccount.getUsername()) && password.equals(userAccount.getPassword())) {
                return userAccount;
            }
        }

        return null;
    }

    public boolean isUserExists(String username) {

        return userAccountDirectory.containsKey(username);
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {

        if (userAccountDirectory.containsKey(username)) {
            //user already exists
            return null;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountDirectory.put(username, userAccount);
        return userAccount;
    }

}
