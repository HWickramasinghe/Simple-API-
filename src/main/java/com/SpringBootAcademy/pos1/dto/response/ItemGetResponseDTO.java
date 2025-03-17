package com.SpringBootAcademy.pos1.dto.response;


import com.SpringBootAcademy.pos1.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemGetResponseDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;
    private double SupplierPrice;
    private double SellingPrice;


}
