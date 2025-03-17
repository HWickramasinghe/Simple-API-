package com.SpringBootAcademy.pos1.controller;

import com.SpringBootAcademy.pos1.dto.CustomerDTO;
import com.SpringBootAcademy.pos1.dto.request.CustomerUpdateDTO;
import com.SpringBootAcademy.pos1.service.CustomerService;
import com.SpringBootAcademy.pos1.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin // Allows cross-origin requests
public class CustomerController {

    @Autowired
    private CustomerService customerService; // Injecting the service instance

    /**
     * Endpoint to save a customer
     */
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        String message = customerService.saveCustomer(customerDTO); // Save customer
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer Saved Successfully", message),
                HttpStatus.CREATED
        );
    }

    /**
     * Endpoint to update a customer
     */
    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        String message = customerService.updateCustomer(customerUpdateDTO); // Update customer
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer Updated Successfully", message),
                HttpStatus.OK
        );
    }

    /**
     * Endpoint to get a customer by ID
     */
    @GetMapping(path = "/get-by-id", params = "id")
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId); // Get customer by ID
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer Retrieved Successfully", customerDTO),
                HttpStatus.OK
        );
    }

    /**
     * Endpoint to get all customers
     */
    @GetMapping(path = "/get-all-customers")
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomer(); // Get all customers
        return new ResponseEntity<>(
                new StandardResponse(200, "All Customers Retrieved Successfully", allCustomers),
                HttpStatus.OK
        );
    }

    /**
     * Endpoint to delete a customer by ID
     */
    @DeleteMapping(path = "/delete-customer/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id") int customerId) {
        String message = customerService.deleteCustomer(customerId); // Delete customer
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer Deleted Successfully", message),
                HttpStatus.OK
        );
    }

    /**
     * Endpoint to get all customers by active state
     */
    @GetMapping(path = "/get-all-customers-by-active-state/{status}")
    public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState); // Get customers by active state
        return new ResponseEntity<>(
                new StandardResponse(200, "Customers Retrieved Successfully", allCustomers),
                HttpStatus.OK
        );
    }
}
