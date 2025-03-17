package com.SpringBootAcademy.pos1.dto.paginated;


import com.SpringBootAcademy.pos1.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaginatedResponseOrderDetails {
     private List<ResponseOrderDetailsDTO> list;
     private long dataCount;


}
