package com.SpringBootAcademy.pos1.service;

import com.SpringBootAcademy.pos1.dto.paginated.PaginatedResponseOrderDetails;
import com.SpringBootAcademy.pos1.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetails getAllOrdersDetails(boolean status, int page, int size);
}
