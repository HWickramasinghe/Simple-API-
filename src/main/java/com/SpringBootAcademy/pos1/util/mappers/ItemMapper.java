package com.SpringBootAcademy.pos1.util.mappers;

import com.SpringBootAcademy.pos1.dto.request.ItemSaveRequestDTO;
import com.SpringBootAcademy.pos1.dto.response.ItemGetResponseDTO;
import com.SpringBootAcademy.pos1.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    // Converts a list of Item entities to a list of ItemGetResponseDTOs
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

    // Converts a single Item entity to ItemGetResponseDTO
    ItemGetResponseDTO entityToDto(Item item);

    // Converts an ItemSaveRequestDTO to an Item entity
    Item dtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);

    // Converts a Page of Item entities to a list of ItemGetResponseDTOs
    List<ItemGetResponseDTO> entityPageToDtoList(Page<Item> items);

    List<ItemGetResponseDTO> ListDTOPage(Page<Item> items);

    List<ItemGetResponseDTO> pageToList(Page<Item> getAllItemsByPaginated);
}

