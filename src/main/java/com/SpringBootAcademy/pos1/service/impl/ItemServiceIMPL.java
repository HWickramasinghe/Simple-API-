package com.SpringBootAcademy.pos1.service.impl;

import com.SpringBootAcademy.pos1.dto.paginated.PaginatedResponseItemDTO;
import com.SpringBootAcademy.pos1.dto.request.ItemSaveRequestDTO;
import com.SpringBootAcademy.pos1.dto.response.ItemGetResponseDTO;
import com.SpringBootAcademy.pos1.entity.Item;
import com.SpringBootAcademy.pos1.exception.NotFoundException;
import com.SpringBootAcademy.pos1.repo.ItemRepo;
import com.SpringBootAcademy.pos1.service.ItemService;
import com.SpringBootAcademy.pos1.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        // Convert ItemSaveRequestDTO to Item entity
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);

        // Step 1: Check if the item already exists using item ID
        if (itemRepo.existsById(item.getItemId())) {
            // Step 2: If exists, throw DuplicateKeyException
            throw new DuplicateKeyException("Item with ID " + item.getItemId() + " already exists.");
        }

        // Step 3: Save the item if it does not exist
        itemRepo.save(item);

        // Step 4: Return success message
        return item.getItemName() + " saved successfully.";
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean activeStatus = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, activeStatus);

        if (!items.isEmpty()) {
            return modelMapper.map(items, new TypeToken<List<ItemGetResponseDTO>>() {}.getType());
        } else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusBymapstruct(String itemName) {
        boolean activeStatus = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, activeStatus);

        if (!items.isEmpty()) {
            return itemMapper.entityListToDtoList(items);
        } else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByActiveStatus(boolean active) {
        List<Item> items = itemRepo.findAllByActiveStateEquals(active);

        if (!items.isEmpty()) {
            return itemMapper.entityListToDtoList(items);
        } else {
            throw new NotFoundException("No active items found with the given status.");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusWithPagimated(boolean active, int page, int size) {
        return null;
    }

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean active, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(active, PageRequest.of(page, size));

        if (items.getSize() < 1) {
            throw new NotFoundException("No items found.");
        }

        return new PaginatedResponseItemDTO(itemMapper.ListDTOPage(items), 2);
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsPaginated(int page, int size, boolean active) {
        Page<Item> getAllItemsByPaginated = itemRepo.findAllByActiveStateEquals(active, PageRequest.of(page, size));

        return new PaginatedResponseItemDTO(
                itemMapper.pageToList(getAllItemsByPaginated),
                itemRepo.countAllByActiveStateEquals(active)
        );
    }
}
