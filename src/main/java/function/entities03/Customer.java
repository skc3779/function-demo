package function.entities03;

import java.util.ArrayList;
import java.util.List;

/**
 * 함수 인터페이스 사용
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


    public Customer() {
    }

    public interface ConversionFunction {
        public String call(Customer customer);
    }

    public static class CustomerName implements ConversionFunction {
        public String call(Customer customer) { return customer.name; }
    }


    public static List<String> getEnabledCustomerField(String field) {
        ArrayList<String> outList = new ArrayList<String>();

        for (Customer customer : Customer.allCustomers) {
            if (customer.enabled) {
                if(field.equals("name")) {
                    outList.add(customer.name);
                } else if(field.equals("state")) {
                    outList.add(customer.state);
                } else {
                    throw new IllegalArgumentException("올바르지 않은 필드입니다.");
                }
            }
                outList.add(customer.name);
        }
        return outList;
    }

}
