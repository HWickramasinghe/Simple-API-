package com.SpringBootAcademy.pos1.dto.request;


import com.SpringBootAcademy.pos1.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor   //manual krnn na lombok use krlakrnne
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double SupplierPrice;
    private double SellingPrice;




}
