package com.SpringBootAcademy.pos1.repo;


import com.SpringBootAcademy.pos1.dto.response.ResponseOrderDetailsDTO;
import com.SpringBootAcademy.pos1.entity.Order;
import com.SpringBootAcademy.pos1.entity.OrderDetails;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {

}
