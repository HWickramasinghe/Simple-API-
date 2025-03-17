package com.SpringBootAcademy.pos1.controller;

import com.SpringBootAcademy.pos1.dto.paginated.PaginatedResponseItemDTO;
import com.SpringBootAcademy.pos1.dto.request.ItemSaveRequestDTO;
import com.SpringBootAcademy.pos1.dto.response.ItemGetResponseDTO;
import com.SpringBootAcademy.pos1.service.ItemService;
import com.SpringBootAcademy.pos1.util.StandardResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.saveItem(itemSaveRequestDTO);
        return new ResponseEntity<>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String itemName) {
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", itemDTOS),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"activeStatus", "page", "size"}
    )
    public ResponseEntity<StandardResponse> getItemByActiveStatus(
            @RequestParam(value = "activeStatus") boolean active,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusWithPaginated(active, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "get-all-item-paginated",
            params = {"page", "size", "active"}
    )
    public ResponseEntity<StandardResponse> getAllItemPaginated(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "active") boolean active
    ) {
        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemByActiveStatusWithPaginated(active, page, size);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", paginatedResponseItemDTO),
                HttpStatus.OK
        );
    }
}
