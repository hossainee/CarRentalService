package sda.project.admin.service;
import sda.project.admin.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomer();

    void saveCustomer(Customer customer);

    Customer getCustomerById(long id);

    void deleteCustomerById(long id);

}
