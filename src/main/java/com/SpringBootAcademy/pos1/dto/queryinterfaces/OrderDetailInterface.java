package com.SpringBootAcademy.pos1.dto.queryinterfaces;
import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailInterface {


    String getCustomer_name();
    String  getCustomer_Address();
    ArrayList getContact_number();
    Date getDate();
    Double getTotal();







}
