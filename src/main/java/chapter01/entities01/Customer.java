package chapter01.entities01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seokangchun on 15. 3. 29..
 */
public class Customer {

    public static ArrayList<Customer> allCustomers = new ArrayList<Customer>();

    public Integer id = 0;
    public String name = "";
    public String address = "";
    public String state = "";
    public String primaryContract = "";
    public String domain = "";
    public Boolean enabled = true;

    public Contract contract;
    public ArrayList<Contact> contacts = new ArrayList<Contact>();


    public Customer() {}

    public static List<String> getEnabledCustomerNames() {
        ArrayList<String> outList = new ArrayList<String>();

        for(Customer customer: Customer.allCustomers) {
            if(customer.enabled)
                outList.add(customer.name);
        }
        return outList;
    }

    public static List<String> getEnabledCustomerStates() {
        ArrayList<String> outList = new ArrayList<String>();

        for(Customer customer: Customer.allCustomers) {
            if(customer.enabled)
                outList.add(customer.state);
        }
        return outList;
    }
}
