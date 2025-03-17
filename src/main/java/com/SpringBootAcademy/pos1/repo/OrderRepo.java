package com.SpringBootAcademy.pos1.repo;
import com.SpringBootAcademy.pos1.dto.queryinterfaces.OrderDetailInterface;
import com.SpringBootAcademy.pos1.dto.response.ResponseOrderDetailsDTO;
import com.SpringBootAcademy.pos1.entity.Item;
import com.SpringBootAcademy.pos1.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories

public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT c.customer_name as customerName, c.customer_address as customerAddress, c.contact_number as contactNumbers, o.order_date as orederDate, o.total as total " +
            "FROM customer c " +
            "JOIN orders o ON c.customer_id = o.customer_id " +
            "WHERE o.active_state = ?1", nativeQuery = true)
    List<OrderDetailInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value = "SELECT COUNT(*) " +
            "FROM customer c, orders o " +
            "WHERE o.active_state = ?1 AND c.customer_id = o.customer_id", nativeQuery = true)
    long countAllOrderDetails(boolean status);

    long countAllDetails(boolean status);
}



