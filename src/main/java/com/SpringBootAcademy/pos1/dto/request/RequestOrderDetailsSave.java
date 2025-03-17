package com.SpringBootAcademy.pos1.dto.request;


import com.SpringBootAcademy.pos1.entity.Item;
import com.SpringBootAcademy.pos1.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestOrderDetailsSave {

    private int orderId;
    private String itemName;
    private double Qty;
    private Double amount;
    private int  orders;
    private int items;
}
