package com.SpringBootAcademy.pos1.dto.paginated;


import com.SpringBootAcademy.pos1.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

 //paginated krnna nm list ekakk wenn onee

public class PaginatedResponseItemDTO {
    List<ItemGetResponseDTO> list;
    private long dataCount;
}
