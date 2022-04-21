package com.devendrabrain.OrderManagement.controller;

import com.devendrabrain.OrderManagement.bo.OrderBO;
import com.devendrabrain.OrderManagement.constant.ApiName;
import com.devendrabrain.OrderManagement.dto.OrderDTO;
import com.devendrabrain.OrderManagement.service.OrderService;
import com.devendrabrain.OrderManagement.transformer.OrderTransformer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/OrderMgr")
public class OrderController {

    // Loogin details
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @GetMapping("/findAll")
    public List<OrderDTO> finaAll() {

        MDC.put("X-RS-ApiName", ApiName.ORDER_MGR_FETCH_ALL_ORDERS.name());

        // Fetch Call
        List<OrderBO> orderBOList = orderService.findAll();

        //Transform
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for(OrderBO orderBO : orderBOList) {
            OrderDTO orderDTO = new OrderDTO();
            OrderTransformer.tranformOrderBOToOrderDTO(orderBO,orderDTO);
            orderDTOList.add(orderDTO);
        }

        return orderDTOList;
    }

    @GetMapping("/{id}")
    public OrderDTO fetchById(@PathVariable("/id") Integer orderId) {

        MDC.put("X-RS-ApiName", ApiName.ORDER_MGR_FETCH_BY_ID.name());

        // Fetch call
        OrderBO orderBO = orderService.fetchById(Long.valueOf(orderId));

        // Transform
        OrderDTO orderDTO = OrderTransformer.tranformOrderBOToOrderDTO(orderBO, new OrderDTO());

        return orderDTO;
    }

    @PostMapping("/create")
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {

        MDC.put("X-RS-ApiName", ApiName.ORDER_MGR_CREATE_ORDER.name());

        //Transform
        OrderBO orderBO = OrderTransformer.tranformOrderDTOToOrderBO(orderDTO, new OrderBO());
        orderBO.setOrderDate(new Date());

        logger.info("OrderController:create Order create request receieved "+orderBO);
        orderBO = orderService.create(orderBO);
        logger.info("OrderController:create Order Created request receieved "+orderBO);

        //Transform
        orderDTO = OrderTransformer.tranformOrderBOToOrderDTO(orderBO,orderDTO);
        logger.info("OrderController:create Preparing response object "+orderDTO);

        return orderDTO;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Long orderId) {

        MDC.put("X-RS-ApiName", ApiName.ORDER_MGR_DELETE_BY_ID.name());

        // delete
        orderService.delete(orderId);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("Message","Order Item Number : "+orderId+" deleted succesfully ..!!");
        return responseMap;
    }
}
