/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.employee.EmployeeDirectory;
import business.role.Role;
import business.useraccount.UserAccountDirectory;
import business.workqueue.WorkQueue;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    //left
    //use UUID
    private int organizationID;
    //private static int counter = 0;
    private OrganizationType organizationType;

    public Organization(String name, int id) {
        this.name = name;
        //left
        workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.organizationID = id;
        //++counter;
    }

    public enum OrganizationType {
        Admin("Admin Organization"),//Common for all
        Manager("Manager Organization"), //Chemist
        Worker("Worker Organization"), //Chemist
        Coordinator("Coordinator Organization"), //Supplier
        Approver("Approver Organization"), //Supplier
        Validator("Validator Organization"), //Legal
        Transporter("Transporter Organization"), //Transport
        Producer("Producer Organization"); //Manufacturer

        private String value;

        private OrganizationType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    //left
    public abstract List<Role> getSupportedRole();

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return name;
    }

}
