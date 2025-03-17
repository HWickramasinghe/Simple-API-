package com.SpringBootAcademy.pos1.dto.request;

import com.SpringBootAcademy.pos1.entity.Customer;
import com.SpringBootAcademy.pos1.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestOrderSaveDTO {

    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetailsSave> orderDetails;





}
