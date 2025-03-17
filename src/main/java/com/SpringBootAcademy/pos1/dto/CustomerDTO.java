package com.SpringBootAcademy.pos1.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

public class CustomerDTO {


    private int customerId;
    private String customer_name;
    private String customer_Address;
    private double customer_salary;
    private ArrayList contact_number ;
    private String nic;
    private boolean active;

    public CustomerDTO(int customerId, String customer_name, String customer_address, double customer_salary, ArrayList contact_number, String nic) {
    }

    public CustomerDTO(int customerId, String customer_name, String customer_Address, double customer_salary, ArrayList contact_number, String nic, boolean active) {
        this.customerId = customerId;
        this.customer_name = customer_name;
        this.customer_Address = customer_Address;
        this.customer_salary = customer_salary;
        this.contact_number = contact_number;
        this.nic = nic;
        this.active = active;
    }

    public CustomerDTO() {

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_Address() {
        return customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        this.customer_Address = customer_Address;
    }

    public double getCustomer_salary() {
        return customer_salary;
    }

    public void setCustomer_salary(double customer_salary) {
        this.customer_salary = customer_salary;
    }

    public ArrayList getContact_number() {
        return contact_number;
    }

    public void setContact_number(ArrayList contact_number) {
        this.contact_number = contact_number;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", customer_name='" + customer_name + '\'' +
                ", customer_Address='" + customer_Address + '\'' +
                ", customer_salary=" + customer_salary +
                ", contact_number=" + contact_number +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }
}
