/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.employee.EmployeeDirectory;
import business.role.Role;
import business.useraccount.UserAccountDirectory;
import java.util.List;

/**
 *
 * @author vivekdalal
 */
public abstract class Organization {

    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter = 0;
    private OrganizationType organizationType;

    public Organization(String name, OrganizationType type) {
        this.name = name;
        this.organizationType = type;
        //left
        //workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.organizationID = counter;
        ++counter;
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

//    public WorkQueue getWorkQueue() {
//        return workQueue;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setWorkQueue(WorkQueue workQueue) {
//        this.workQueue = workQueue;
//    }
    public OrganizationType getType() {
        return organizationType;
    }

    public void setType(OrganizationType type) {
        this.organizationType = type;
    }

    @Override
    public String toString() {
        return name;
    }
}
