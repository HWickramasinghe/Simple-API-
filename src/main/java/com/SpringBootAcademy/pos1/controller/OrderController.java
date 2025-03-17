package com.SpringBootAcademy.pos1.controller;

import com.SpringBootAcademy.pos1.dto.paginated.PaginatedResponseOrderDetails;
import com.SpringBootAcademy.pos1.dto.request.ItemSaveRequestDTO;
import com.SpringBootAcademy.pos1.dto.request.RequestOrderSaveDTO;
import com.SpringBootAcademy.pos1.service.OrderService;
import com.SpringBootAcademy.pos1.util.StandardResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin

public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String id  = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<>(
                new StandardResponse(201, id+"item successfully save", id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path =  {"/get-order-detils"}
    )

    public ResponseEntity<StandardResponse>getAllOrderDetails(
            @RequestParam(value = "stateTyope") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size

    ){

        PaginatedResponseOrderDetails p = null;

        if(stateType.equalsIgnoreCase("active")|stateType.equalsIgnoreCase("inactive")){

            boolean status = stateType.equalsIgnoreCase("active")?true:false;
            p  = orderService.getAllOrdersDetails(status,page,size);



        }


        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"sucess",p),
                HttpStatus.OK
        );





    }

}
