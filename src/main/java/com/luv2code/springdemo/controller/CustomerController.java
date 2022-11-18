package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    //inject the Dao
    @Autowired
    private CustomerDAO customerService;


    @GetMapping ("list")
    public String listCustomers(Model model){
        //get customer from the dao

        //add the customer to the model
        List<Customer> theCustomers = customerService.getCustomer();
        model.addAttribute("customers", theCustomers);


        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Customer theCustomer = new Customer();

        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer")Customer theCustomer){

        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("customerId")int theId, Model theModel){

        //get customer from the service
        Customer theCustomer = customerService.getCustomer(theId);

        //set the customer as a model attribute to pre populate the form.

        theModel.addAttribute("customer",theCustomer);

        // send over to our form




        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        customerService.deleteCustomer(theId);
        return  "redirect:/customer/list";
    }
}






