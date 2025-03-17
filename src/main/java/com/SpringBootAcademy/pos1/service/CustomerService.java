package com.SpringBootAcademy.pos1.service;

import com.SpringBootAcademy.pos1.dto.CustomerDTO;
import com.SpringBootAcademy.pos1.dto.request.CustomerUpdateDTO;
import java.util.List;

public interface CustomerService {

    // Method to save a customer
    String saveCustomer(CustomerDTO customerDTO);

    // Method to update a customer
    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    // Method to get a customer by ID
    CustomerDTO getCustomerById(int customerId);

    // Method to get all customers
    List<CustomerDTO> getAllCustomer();

    // Method to delete a customer by ID
    String deleteCustomer(int customerId);

    // Method to get all customers by their active state
    List<CustomerDTO> getAllCustomersByActiveState(boolean activeState);
}
