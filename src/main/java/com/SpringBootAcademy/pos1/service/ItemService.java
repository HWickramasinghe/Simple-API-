package com.SpringBootAcademy.pos1.service;

import com.SpringBootAcademy.pos1.dto.paginated.PaginatedResponseItemDTO;
import com.SpringBootAcademy.pos1.dto.request.ItemSaveRequestDTO;
import com.SpringBootAcademy.pos1.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService  {
    String  saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusBymapstruct(String itemName);

    List<ItemGetResponseDTO> getItemByActiveStatus(boolean active);

    PaginatedResponseItemDTO getItemByActiveStatusWithPagimated(boolean active, int page, int size);

    PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean active, int page, int size);

    PaginatedResponseItemDTO getAllItemsPaginated(int page, int size, boolean active);
}
