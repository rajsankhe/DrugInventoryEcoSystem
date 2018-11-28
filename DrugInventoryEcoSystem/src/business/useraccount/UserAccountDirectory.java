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

    private Map<String, UserAccount> userAccountList;

    public Map<String, UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void setUserAccountList(Map<String, UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }

    public UserAccount authenticateUser(String username, String password) {
        for (Map.Entry<String, UserAccount> entry : userAccountList.entrySet()) {
            UserAccount userAccount = entry.getValue();
            if (username.equalsIgnoreCase(userAccount.getUsername()) && password.equals(userAccount.getPassword())) {
                return userAccount;
            }
        }

        return null;
    }

    public boolean isUserExists(String username) {

        return userAccountList.containsKey(username);
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role) {

        if (userAccountList.containsKey(username)) {
            //user already exists
            return null;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountList.put(username, userAccount);
        return userAccount;
    }

}
