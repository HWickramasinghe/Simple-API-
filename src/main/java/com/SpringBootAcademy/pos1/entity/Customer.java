package com.SpringBootAcademy.pos1.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;


@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name ="json",typeClass=JsonType.class)
})
public class Customer {

    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)     //id eka auto genarate wenn daanne
    private int customerId;

    @Column(name= "customer_name", length = 255,nullable = false)
    private String customer_name;

    @Column(name="customer_address",length = 255)
    private String customer_Address;

    @Column(name = "customer_salary")
    private double customer_salary;

    @Column(name = "Contact_Number",columnDefinition = "json")
    private ArrayList contact_number ;

    @Column(name = "nic")
    private String nic;


    @Column(name = "active_value",columnDefinition = "TINYINT default 1")
    private boolean active;

    @OneToMany(mappedBy="customer")
    private Set<Order> items;    // eka customer kenkkat orders godk thiynne puluwan one to many relationship


    public Customer() {
    }

    public Customer(int customerId, String customer_name, String customer_Address, double customer_salary, ArrayList contact_number, String nic, boolean active) {
        this.customerId = customerId;
        this.customer_name = customer_name;
        this.customer_Address = customer_Address;
        this.customer_salary = customer_salary;
        this.contact_number = contact_number;
        this.nic = nic;
        this.active = active;
    }

    public Customer(int customerId, String customer_name, String customer_address, double customer_salary, ArrayList contact_number, String nic) {
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

    public ArrayList getContact_number() {
        return contact_number;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
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

    public void setContact_number(ArrayList contact_number) {
        this.contact_number = contact_number;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
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


