/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import Business.Abstract.User;

/**
 *
 * @author harshalneelkamal
 */
public class Customer extends User implements Comparable<Customer> {

    public Customer(String password, String userName) {
        super(password, userName, "CUSTOMER");
    }

    //Overriding method from User Absract class to verify a customer by checking the password
    @Override
    public boolean verify(String password) {
        if (password.equals(getPassword())) {
            return true;
        }
        return false;
    }

    //implementing the compareTo method from the Comparable interface to compare the custom objects based on their username
    @Override
    public int compareTo(Customer o) {
        return o.getUserName().compareTo(this.getUserName());
    }

}
