package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerService  {
    public List<Customer> getCustomer();
    public void saveCustomer(Customer thCustomer);
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);

}
