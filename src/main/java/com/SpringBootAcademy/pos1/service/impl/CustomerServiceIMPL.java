package com.SpringBootAcademy.pos1.service.impl;
import com.SpringBootAcademy.pos1.dto.CustomerDTO;
import com.SpringBootAcademy.pos1.dto.request.CustomerUpdateDTO;
import com.SpringBootAcademy.pos1.entity.Customer;
import com.SpringBootAcademy.pos1.exception.NotFoundException;
import com.SpringBootAcademy.pos1.repo.CustomerRepo;
import com.SpringBootAcademy.pos1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        // If customerId is not provided and auto-generated, don't check for existing ID
        Optional<Customer> existingCustomer = customerRepo.findById(customerDTO.getCustomerId());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("Customer with ID " + customerDTO.getCustomerId() + " already exists.");
        }

        // Create a new customer entity from the DTO
        Customer customer = new Customer(
                customerDTO.getCustomerId(), // Check if this should be auto-generated or provided in DTO
                customerDTO.getCustomer_Address(),
                customerDTO.getCustomer_name(),
                customerDTO.getCustomer_salary(),
                customerDTO.getContact_number(),
                customerDTO.getNic(),
                true // Assuming active state as true by default, adjust if needed
        );

        // Save the customer to the database
        customerRepo.save(customer);

        // Return a success message with the customer's name
        return "Customer saved successfully: " + customer.getCustomer_name();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        // Get customer by ID
        Optional<Customer> optionalCustomer = customerRepo.findById(customerUpdateDTO.getCustomerId());

        // Check if customer exists
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setCustomer_name(customerUpdateDTO.getCustomer_name());
            customer.setCustomer_Address(customerUpdateDTO.getCustomer_Address());
            customer.setCustomer_salary(customerUpdateDTO.getCustomer_salary());
            customer.setContact_number(customerUpdateDTO.getContact_number());
            customer.setNic(customerUpdateDTO.getNic());

            // Save updated customer
            customerRepo.save(customer);

            // Return success message
            return "Customer updated successfully: " + customerUpdateDTO.getCustomer_name();
        } else {
            // Throw an exception if customer not found
            throw new NotFoundException("Customer not found with ID: " + customerUpdateDTO.getCustomerId());
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        // Fetch customer by ID
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);

        // Check if customer exists and return the DTO
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomer_name(),
                    customer.getCustomer_Address(),
                    customer.getCustomer_salary(),
                    customer.getContact_number(),
                    customer.getNic()
            );
        } else {
            // Throw exception if customer not found
            throw new NotFoundException("Customer not found with ID: " + customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        // Get all customers
        List<Customer> customers = customerRepo.findAll();

        if (!customers.isEmpty()) {
            List<CustomerDTO> customerDTOList = new ArrayList<>();
            for (Customer customer : customers) {
                // Convert each entity to DTO
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomer_name(),
                        customer.getCustomer_Address(),
                        customer.getCustomer_salary(),
                        customer.getContact_number(),
                        customer.getNic()
                );
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        } else {
            throw new NotFoundException("No customers found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        // Check if customer exists before deleting
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer deleted successfully with ID: " + customerId;
        } else {
            throw new NotFoundException("Customer not found with ID: " + customerId);
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        // Get all customers by active state
        List<Customer> customers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomer_name(),
                    customer.getCustomer_Address(),
                    customer.getCustomer_salary(),
                    customer.getContact_number(),
                    customer.getNic()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
