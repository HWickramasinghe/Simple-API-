package com.SpringBootAcademy.pos1.service.impl;
import com.SpringBootAcademy.pos1.dto.CustomerDTO;
import com.SpringBootAcademy.pos1.dto.paginated.PaginatedResponseOrderDetails;
import com.SpringBootAcademy.pos1.dto.queryinterfaces.OrderDetailInterface;
import com.SpringBootAcademy.pos1.dto.request.RequestOrderSaveDTO;
import com.SpringBootAcademy.pos1.dto.response.ResponseOrderDetailsDTO;
import com.SpringBootAcademy.pos1.entity.Order;
import com.SpringBootAcademy.pos1.entity.OrderDetails;
import com.SpringBootAcademy.pos1.repo.CustomerRepo;
import com.SpringBootAcademy.pos1.repo.ItemRepo;
import com.SpringBootAcademy.pos1.repo.OrderDetailRepo;
import com.SpringBootAcademy.pos1.repo.OrderRepo;
import com.SpringBootAcademy.pos1.service.OrderService;
import com.SpringBootAcademy.pos1.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(

                customerRepo.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );

        orderRepo.save(order);
        if (orderRepo.existsById(order.getOrderId())) {

            // Correct mapping using ModelMapper
            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(),
                            new TypeToken<List<OrderDetails>>() {
                            }.getType()
                    );
            for (int i = 0; i < orderDetails.size(); ++i) {
                // Associate the order with the order detail
                orderDetails.get(i).setOrders(order);// Fetch the item from the repository and set it to the order detail
                orderDetails.get(i).setItems(
                        itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems())
                );
            }

// Save all order details if the list is not empty
            if (orderDetails.size() > 0) {
                orderDetailRepo.saveAll(orderDetails);
            }
        }
        return "saved";
    }

    @Override
    public PaginatedResponseOrderDetails getAllOrdersDetails(boolean status, int page, int size) {

        List<OrderDetailInterface> orderDetailsDTOS = orderRepo.getAllOrderDetails(status, PageRequest.of(page, size));


        List<ResponseOrderDetailsDTO> list =new ArrayList<>();
        for(OrderDetailInterface o : orderDetailsDTOS){
            ResponseOrderDetailsDTO r = new ResponseOrderDetailsDTO(


                    o.getCustomer_name(),
                    o.getContact_number(),
                    o.getCustomer_Address(),
                    o.getDate(),
                    o.getTotal()

            );

            list.add(r);

        }

        PaginatedResponseOrderDetails paginatedResponseOrderDetails = new PaginatedResponseOrderDetails(

                list,
                orderRepo.countAllDetails(status)

        );


        return paginatedResponseOrderDetails;

    }    }

//transactional annotaion eka damma