/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.employee;

import java.util.List;

/**
 *
 * @author vivekdalal
 */
public class EmployeeDirectory {

    private List<Employee> employeeDirectory;

    public List<Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(List<Employee> employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public Employee createEmployee(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        employeeDirectory.add(employee);
        return employee;
    }

}
