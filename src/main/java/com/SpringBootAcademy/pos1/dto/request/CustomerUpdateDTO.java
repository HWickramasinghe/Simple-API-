package com.SpringBootAcademy.pos1.dto.request;

import java.util.ArrayList;

public class CustomerUpdateDTO {
                                           //args
                                           //no args
                                           //getter    setter      gettr and setter
                                           //ToString
    private int customerId;
    private String customer_name;
    private String customer_Address;
    private double customer_salary;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerId, String customer_name, String customer_Address, double customer_salary) {
        this.customerId = customerId;
        this.customer_name = customer_name;
        this.customer_Address = customer_Address;
        this.customer_salary = customer_salary;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public double getCustomer_salary() {
        return customer_salary;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    public void setCustomer_salary(double customer_salary) {
        this.customer_salary = customer_salary;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId=" + customerId +
                ", customer_name='" + customer_name + '\'' +
                ", customer_Address='" + customer_Address + '\'' +
                ", customer_salary=" + customer_salary +
                '}';
    }

    public ArrayList getContact_number() {

        return null;
    }

    public String getNic() {
        return null;
    }
}


