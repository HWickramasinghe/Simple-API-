package com.SpringBootAcademy.pos1.repo;

import com.SpringBootAcademy.pos1.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

      // Custom query method to find all customers by their active state
      List<Customer> findAllByActiveEquals(boolean activeState);
}
