/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

import common.DataStore;
import entities.Customer;
import entities.Product;
import entities.SalesPerson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class AnalysisHelper {
    public static final String SEPERATOR  = "-----------------------------------------------------------------------------------------------";

    public void getThreeMostPopularProducts() {
        Map<Integer, Product> products = DataStore.getInstance().getProducts();
        List<Product> productList = new ArrayList(products.values());
        productList.sort((o1,o2)->o2.getPopularity() - o1.getPopularity());
        System.out.println("Product Id\tPopularity");
        for (int i = 0; i < 3; i++) {
            System.out.println(productList.get(i).getId()+"\t\t"+productList.get(i).getPopularity());
        }
    }

    public void getThreeMostPopularCustomers() {

        Map<Integer, Customer> customers = DataStore.getInstance().getCustomers();
        List<Customer> customerList = new ArrayList(customers.values());
        customerList.sort((o1, o2) -> (int) (o2.getTotalItemBought() - o1.getTotalItemBought()));
        System.out.println("Top 3 most popular Customers as per Total items bought.");
        System.out.println("Customer Id\tPopularity");
        for (int i = 0; i < 3; i++) {
            System.out.println(customerList.get(i).getId()+"\t\t"+customerList.get(i).getTotalItemBought());
        }
        customerList.sort((o1,o2) -> (int) (o2.getTotalPriceOfItemBought() - o1.getTotalPriceOfItemBought()));
        System.out.println(SEPERATOR);
        System.out.println("Top 3 most popular Customers as per total price of items bought.");
        System.out.println("Customer Id\tPopularity");
        for (int i = 0; i < 3; i++) {
            System.out.println(customerList.get(i).getId()+"\t\t"+customerList.get(i).getTotalPriceOfItemBought());
        }
    }
    public void getTopThreeSalesPerson() {

        Map<Integer, SalesPerson> salesPerson = DataStore.getInstance().getSalesPerson();
        List<SalesPerson> salesList = new ArrayList(salesPerson.values());
        salesList.sort((o1,o2) ->  (int) (o2.getTotalpriceWRTTarget()- o1.getTotalpriceWRTTarget()));
        System.out.println("Top 3 most popular Salesperson as per crossing target price.");
        System.out.println("Sales Person Id\tPopularity");
        for (int i = 0; i < 3; i++) {
            System.out.println(salesList.get(i).getId()+"\t\t"+salesList.get(i).getTotalpriceWRTTarget());
        }
        salesList.sort((o1,o2) ->  (int) (o2.getTotalItemSold()- o1.getTotalItemSold()));
        System.out.println(SEPERATOR);
        System.out.println("Top 3 most popular SalesPerson as per items sold.");
        System.out.println("Sales Person Id\tPopularity");
        for (int i = 0; i < 3; i++) {
            System.out.println(salesList.get(i).getId()+"\t\t"+salesList.get(i).getTotalItemSold());
        }
    }
    
    public void getTotalRevenueForTheYear(){
        System.out.println("Revenue = "+DataStore.getInstance().getTotalRevenue());
        
    }
}
