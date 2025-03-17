package com.SpringBootAcademy.pos1.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor   //manual krnn na lombok use krlakrnne
@NoArgsConstructor
@Data

public class ResponseOrderDetailsDTO {
    //need from customer
    private String customer_name;
    private String customer_Address;
    private ArrayList contact_number ;


    //order

    private Date date;
    private Double total;


    public ResponseOrderDetailsDTO(String customer_name, ArrayList contact_number, String customer_address, Date date, Double total) {
    }
}
