package com.devendrabrain.OrderManagement.transformer;

import com.devendrabrain.OrderManagement.bo.OrderBO;
import com.devendrabrain.OrderManagement.dto.OrderDTO;
import com.devendrabrain.OrderManagement.entity.Order;
import com.devendrabrain.OrderManagement.entity.OrderDetails;
import com.devendrabrain.OrderManagement.util.billing.BillingDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderTransformer {

    public static OrderBO tranformOrderDTOToOrderBO(OrderDTO orderDTO, OrderBO orderBO) {

        if(orderDTO != null) {

            if(orderDTO.getOrderId() != null) {
                orderBO.setOrderId(orderDTO.getOrderId());
            }
            if(orderDTO.getCustomerId() != null){
                orderBO.setCustomerId(orderDTO.getCustomerId());
            }
            if(orderDTO.getTotalOrderAmount() != null) {
                orderBO.setTotalOrderAmount(orderDTO.getTotalOrderAmount());
            }
            if(orderDTO.getOrderDate() != null) {
                orderBO.setOrderDate(orderDTO.getOrderDate());
            }

            if(!CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {

                for(OrderDTO.OrderDetails orderDetails : orderDTO.getOrderDetails()) {

                    OrderBO.OrderDetails orderDetailsBO = new OrderBO.OrderDetails();
                    if(orderDetails.getInventoryId() != null) {
                        orderDetailsBO.setInventoryId(orderDetails.getInventoryId());
                    }
                    if(orderDetails.getQuantity() != null) {
                        orderDetailsBO.setQuantity(orderDetails.getQuantity());
                    }
                    if(orderDetails.getTotalPrice() != null) {
                        orderDetailsBO.setTotalPrice(orderDetails.getTotalPrice());
                    }
                    orderBO.getOrderDetails().add(orderDetailsBO);
                }
            }
        }
        return orderBO;
    }

    public static OrderDTO tranformOrderBOToOrderDTO(OrderBO orderBO, OrderDTO orderDTO) {

        if(orderBO != null) {

            if(orderBO.getOrderId() != null) {
                orderDTO.setOrderId(orderBO.getOrderId());
            }
            if(orderBO.getCustomerId() != null){
                orderDTO.setCustomerId(orderBO.getCustomerId());
            }
            if(orderBO.getTotalOrderAmount() != null) {
                orderDTO.setTotalOrderAmount(orderBO.getTotalOrderAmount());
            }
            if(orderBO.getOrderDate() != null) {
                orderDTO.setOrderDate(orderBO.getOrderDate());
            }

            if(!CollectionUtils.isEmpty(orderBO.getOrderDetails())) {

                for(OrderBO.OrderDetails orderDetailsbo : orderBO.getOrderDetails()) {

                    OrderDTO.OrderDetails orderDetailsDTO = new OrderDTO.OrderDetails();
                    if(orderDetailsbo.getInventoryId() != null) {
                        orderDetailsDTO.setInventoryId(orderDetailsbo.getInventoryId());
                    }
                    if(orderDetailsbo.getQuantity() != null) {
                        orderDetailsDTO.setQuantity(orderDetailsbo.getQuantity());
                    }
                    if(orderDetailsbo.getTotalPrice() != null) {
                        orderDetailsDTO.setTotalPrice(orderDetailsbo.getTotalPrice());
                    }
                    orderDTO.getOrderDetails().add(orderDetailsDTO);
                }
            }
        }
        return orderDTO;
    }



    public static OrderBO tranformOrderToOrderBO(Order order, OrderBO orderBO) {

        if(order != null) {

            if(order.getOrderId() != null) {
                orderBO.setOrderId(order.getOrderId());
            }
            if(order.getCustomerId() != null){
                orderBO.setCustomerId(order.getCustomerId());
            }
            if(order.getTotalAmount() != null) {
                orderBO.setTotalOrderAmount(order.getTotalAmount());
            }
            if(order.getOrderDate() != null) {
                orderBO.setOrderDate(order.getOrderDate());
            }

            if(!CollectionUtils.isEmpty(order.getOrderDetailsList())) {

                for(OrderDetails orderDetailsbo : order.getOrderDetailsList()) {

                    OrderBO.OrderDetails orderDetailsBO = new OrderBO.OrderDetails();
                    if(orderDetailsbo.getInventoryId() != null) {
                        orderDetailsBO.setInventoryId(orderDetailsbo.getInventoryId());
                    }
                    if(orderDetailsbo.getQuantity() != null) {
                        orderDetailsBO.setQuantity(orderDetailsbo.getQuantity());
                    }
                    if(orderDetailsbo.getTotalPrice() != null) {
                        orderDetailsBO.setTotalPrice(orderDetailsbo.getTotalPrice());
                    }
                    orderBO.getOrderDetails().add(orderDetailsBO);
                }
            }
        }
        return orderBO;
    }


    public static Order tranformOrderBOToOrder(OrderBO orderBO, Order order) {

        if(orderBO != null) {

            if(orderBO.getOrderId() != null) {
                order.setOrderId(orderBO.getOrderId());
            }
            if(orderBO.getCustomerId() != null){
                order.setCustomerId(orderBO.getCustomerId());
            }
            if(orderBO.getTotalOrderAmount() != null) {
                order.setTotalAmount(orderBO.getTotalOrderAmount());
            }
            if(orderBO.getOrderDate() != null) {
                order.setOrderDate(orderBO.getOrderDate());
            }

            if(!CollectionUtils.isEmpty(orderBO.getOrderDetails())) {
                List<OrderDetails> orderDetailsList = new ArrayList<>();
                for(OrderBO.OrderDetails orderDetailsbo : orderBO.getOrderDetails()) {

                    OrderDetails orderDetailsDTO = new OrderDetails();
                    if(orderDetailsbo.getInventoryId() != null) {
                        orderDetailsDTO.setInventoryId(orderDetailsbo.getInventoryId());
                    }
                    if(orderDetailsbo.getQuantity() != null) {
                        orderDetailsDTO.setQuantity(orderDetailsbo.getQuantity());
                    }
                    if(orderDetailsbo.getTotalPrice() != null) {
                        orderDetailsDTO.setTotalPrice(orderDetailsbo.getTotalPrice());
                    }
                    orderDetailsList.add(orderDetailsDTO);
                }
                order.setOrderDetailsList(orderDetailsList);
            }
        }
        return order;
    }

    public static BillingDTO transformOrderToBillingDTO(Order order, BillingDTO billingDTO) {

        if(order != null) {

            if(order.getOrderId() != null) {
                billingDTO.setOrderId(order.getOrderId());
            }
            if(order.getCustomerId() != null) {
                billingDTO.setCustomerId(order.getCustomerId());
            }
            if(order.getOrderDate() != null) {
                billingDTO.setOrderDate(order.getOrderDate());
            }
            if(order.getTotalAmount() != null) {
                billingDTO.setTotalBillingAmount(order.getTotalAmount());
            }
        }

        return  billingDTO;
    }

}
