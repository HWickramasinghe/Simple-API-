package com.SpringBootAcademy.pos1.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders") // Changed table name to "orders"
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    //one to many relation ship ekakk meke  hadenne

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;   // order ekat adalwa customer id ekakk thiynwa kiyla feild ekak hadenwa
                                //customer eke customer order eke customert samna wen onee

    @Column(name = "order_date" , columnDefinition = "DATETIME")
    private Date date;


    @Column(name = "total" , nullable = false)
    private Double total;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;

    public Order(Customer customer, Date date, Double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;

    }
}
