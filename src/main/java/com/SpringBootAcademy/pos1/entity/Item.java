package com.SpringBootAcademy.pos1.entity;

import com.SpringBootAcademy.pos1.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item ")
@AllArgsConstructor   //manual krnn na lombok use krlakrnne
@NoArgsConstructor
@Getter
@Setter
@ToString



public class Item {
    @Id
    @Column(name = "item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)     //id eka auto genarate wenn daanne
    private int itemId;

    @Column(name= "item_name", length = 100,nullable = false)
    private String itemName;


    @Enumerated(EnumType.STRING )
    @Column(name= "measure_type", length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;


    @Column(name = "balance_qty" , length = 100 , nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price" , length = 100 , nullable = false)
    private double SupplierPrice;

    @Column(name = "selling_price" , length = 100 , nullable = false)
    private double SellingPrice;

    @Column(name = "active_value",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    //counstuctors tika ema hadnne naaa mekee (ewa hadnn thama lombok use krnne )

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> items;


}
