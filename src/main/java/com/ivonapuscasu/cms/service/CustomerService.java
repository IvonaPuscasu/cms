//service layer for Customer Management Application
package com.ivonapuscasu.cms.service;

import com.ivonapuscasu.cms.dao.CustomerDAO;
import com.ivonapuscasu.cms.exception.CustomerNotFoundException;
import com.ivonapuscasu.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

//    private int customerIsCount = 1;
//    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCustomer (Customer customer) {
//        customer.setCustomerId(customerIsCount);
//        customerList.add(customer);
//        customerIsCount++;
        return customerDAO.save(customer);
//        return customer;
    }

    public List<Customer> getCustomerList() {

        return customerDAO.findAll();

        //return customerList;
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerDAO.findById(customerId);

        if (!optionalCustomer.isPresent())
            throw new CustomerNotFoundException("Customer Record is not available ...");
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {

        customer.setCustomerId(customerId);
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if (c.getCustomerId() == customerId) {
//                        c.setCustomerFirstName(customer.getCustomerFirstName());
//                        c.setCustomerLastName(customer.getCustomerLastName());
//                        c.setCustomerEmail(customer.getCustomerEmail());
//                    }
//                });
//        return customerList
//                .stream()
//                .filter(c -> c.getCustomerId() == customerId)
//                .findFirst()
//                .get();

        return customerDAO.save(customer);
    }

    public void deleteCustomer(int customerId) {
//        customerList
//                .stream()
//                .forEach(c -> {
//                    if (c.getCustomerId() == customerId) {
//                        customerList.remove(c);
//                    }
//                });
        customerDAO.deleteById(customerId);
    }
}
