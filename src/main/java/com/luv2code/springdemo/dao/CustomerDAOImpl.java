package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //need to inject the session factory
    @Autowired

   private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Customer> getCustomer() {
        List<Customer> customers;
        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create a query and ger the result
        Query<Customer> theQuery= session.createQuery("from Customer order by lastName", Customer.class);

        customers= theQuery.getResultList();



        return customers;
    }


    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {

        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, theId);
        return customer;
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Customer customer =session.get(Customer.class, theId);
        session.delete(customer);
    }

}
