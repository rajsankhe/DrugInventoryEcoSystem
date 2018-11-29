/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.employee.Employee;
import business.role.Role;
import business.role.SystemAdminRole;
import business.useraccount.UserAccount;

/**
 *
 * @author vivekdalal
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("BROCODERS");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", "admin@brocoders.com", employee, new SystemAdminRole(Role.RoleType.Admin));

        return system;
    }
}
