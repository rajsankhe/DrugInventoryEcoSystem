/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_generator_reader;

import analytics.AnalysisHelper;
import common.Constants;
import common.DataStore;
import common.FileDataValidator;
import entities.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author harshalneelkamal
 */
public class GateWay {

    public static final String SEPERATOR = "===============================================================================================";
    public static final String PROBLEM = "PROBLEM ";
    public static final String ORDER = "ORDER";
    public static final String PRODUCT = "PRODUCT";

    public static void main(String args[]) throws IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        try {

            DataReader orderReader = new DataReader((Constants.ORDER_FILE_PATH));
            String[] orderRow;
            DataReader productReader = new DataReader(Constants.PROD_CAT_PATH);
            String[] prodRow;
            Map<Integer, Order> orders = DataStore.getInstance().getOrders();
            Map<Integer, Item> items = DataStore.getInstance().getItems();
            Map<Integer, Product> products = DataStore.getInstance().getProducts();

            while ((prodRow = productReader.getNextRow()) != null) {
                FileDataValidator.checkIfRecordIsValid(prodRow, "PRODUCT");
                Product newProduct = new Product(Integer.parseInt(prodRow[0]), Integer.parseInt(prodRow[1]), Integer.parseInt(prodRow[2]), Integer.parseInt(prodRow[3]));
                products.put(Integer.parseInt(prodRow[0]), newProduct);
            }
            Map<Integer, SalesPerson> salespersonList = DataStore.getInstance().getSalesPerson();
            Map<Integer, Customer> customers = DataStore.getInstance().getCustomers();
            Item item;
            while ((orderRow = orderReader.getNextRow()) != null) {
                //Checking whether the record is valid or no.
                FileDataValidator.checkIfRecordIsValid(orderRow, "ORDER");

                //Calculating Popularity
                int producId = Integer.parseInt(orderRow[2]);
                Product pro = products.get(producId);
                int tempPopularity = pro.getPopularity() + Integer.parseInt(orderRow[3]);
                pro.setPopularity(tempPopularity);
                

                //Adding items in orders
                if (orders.containsKey(Integer.parseInt(orderRow[0]))) {
                    item = new Item(Integer.parseInt(orderRow[1]), Integer.parseInt(orderRow[2]), Integer.parseInt(orderRow[4]), Double.parseDouble(orderRow[6]), Integer.parseInt(orderRow[3]));
                    orders.get(Integer.parseInt(orderRow[0])).getItems().add(item);
                } else {
                    ArrayList<Item> itemsList = new ArrayList<>();
                    item = new Item(Integer.parseInt(orderRow[1]), Integer.parseInt(orderRow[2]), Integer.parseInt(orderRow[4]), Double.parseDouble(orderRow[6]), Integer.parseInt(orderRow[3]));
                    itemsList.add(item);
                    Order order = new Order(Integer.parseInt(orderRow[1]), itemsList, Integer.parseInt(orderRow[5]));
                    orders.put(Integer.parseInt(orderRow[0]), order);
                }
                items.put(Integer.parseInt(orderRow[1]), item);

                // calculating sales person customer parameters
                SalesPerson salesPerson =null;
                if(!salespersonList.containsKey(Integer.parseInt(orderRow[4]))){
                    salesPerson = new SalesPerson(Integer.parseInt(orderRow[4]));    
                }
                else{
                    salesPerson = salespersonList.get(Integer.parseInt(orderRow[4]));
                }
                
                double targetprice = products.get(Integer.parseInt(orderRow[2])).getTarget_price();
                double salesPrice = Double.parseDouble(orderRow[6]);
                double priceWRTTarget = salesPrice - targetprice;
                double totalpriceWRTTarget = priceWRTTarget*Integer.parseInt(orderRow[3]) + salesPerson.getTotalpriceWRTTarget();
                salesPerson.setTotalpriceWRTTarget(totalpriceWRTTarget);
                int totalItemSold = salesPerson.getTotalItemSold() + Integer.parseInt(orderRow[3]);
                salesPerson.setTotalItemSold(totalItemSold);
                salespersonList.put(Integer.parseInt(orderRow[4]), salesPerson);

                // calculating customer parameters
                Customer customer=null;
                if(!customers.containsKey(Integer.parseInt(orderRow[5]))){
                    customer = new Customer(Integer.parseInt(orderRow[5]));    
                }
                else{
                    customer = customers.get(Integer.parseInt(orderRow[5]));
                }
                long totalItemBought = customer.getTotalItemBought() + Integer.parseInt(orderRow[3]);
                double totalPriceOfItemBought = customer.getTotalPriceOfItemBought() + Integer.parseInt(orderRow[3]) * Integer.parseInt(orderRow[6]);
                customer.setTotalItemBought(totalItemBought);
                customer.setTotalPriceOfItemBought(totalPriceOfItemBought);
                customers.put(Integer.parseInt(orderRow[5]), customer);

                //calculate total revenue
                double minPriceOfProduct = products.get(Integer.parseInt(orderRow[2])).getMin_price();
                double revenue = Integer.parseInt(orderRow[6]) - minPriceOfProduct;
                double totalRevenue = DataStore.getInstance().getTotalRevenue() + revenue*Integer.parseInt(orderRow[3]);
                DataStore.getInstance().setTotalRevenue(totalRevenue);
                
                //Calculating Popularity as per revenue
                double tempRevenue= pro.getPopularityAsPerProfit()+ revenue*Integer.parseInt(orderRow[3]);
                pro.setPopularityAsPerProfit(tempRevenue);
            }
            //GateWay gateWay = new GateWay();
            //gateWay.runanalysis();
            runanalysis();
            System.out.println("Analysis completed successfully.");

        } catch (FileNotFoundException fnf) {
            System.out.println("Analysis Failed!");
            System.out.println("Something went wrong. Please check logs.");
            //e.printStackTrace();
            //e.getMessage();
            System.out.print(fnf.getMessage());
        } catch (Exception e) {
            System.out.println("Analysis Failed!");
            System.out.println("Something went wrong. Please check logs.");
            //e.printStackTrace();
            //e.getMessage();
            System.out.print(e.getMessage());

        }
    }
    
    public static void runanalysis() {
        AnalysisHelper analysisHelper = new AnalysisHelper();
        int i = 0;
        System.out.println(SEPERATOR);
        System.out.println(PROBLEM + ++i + " Our top 3 most popular product sorted from high to low.");
        analysisHelper.getThreeMostPopularProducts();
        System.out.println(SEPERATOR);
        System.out.println(PROBLEM + ++i + " Our 3 best customers.");
        analysisHelper.getThreeMostPopularCustomers();
        System.out.println(SEPERATOR);
        System.out.println(PROBLEM + ++i + " Our top 3 best sales people.");
        analysisHelper.getTopThreeSalesPerson();
        System.out.println(SEPERATOR);
        System.out.println(PROBLEM + ++i + " Our total revenue for the year.");
        analysisHelper.getTotalRevenueForTheYear();
    }

}