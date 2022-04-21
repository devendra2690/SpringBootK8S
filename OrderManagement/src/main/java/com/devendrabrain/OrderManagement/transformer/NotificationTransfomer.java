package com.devendrabrain.OrderManagement.transformer;

import com.devendrabrain.OrderManagement.dto.NotificationDTO;
import com.devendrabrain.OrderManagement.entity.Order;
import com.devendrabrain.OrderManagement.util.customermgr.CustomerDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class NotificationTransfomer {

    private static Logger logger = LoggerFactory.getLogger(NotificationTransfomer.class);

    public static NotificationDTO transformNotificationDTO(Order order, CustomerDTO customerDTO, Map<Long, String> inventoryDetails) {

        logger.info("NotificationTransfomer:transformNotificationDTO Inside transformer");

        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setCustomerId(order.getCustomerId());
        notificationDTO.setOrderId(order.getOrderId());
        notificationDTO.setTotalPrice(order.getTotalAmount());
        notificationDTO.setInventoryDetails(inventoryDetails);
        notificationDTO.setEmail(customerDTO.getEmailId());
        notificationDTO.setCustomerFirstName(customerDTO.getFirstName());
        notificationDTO.setCustomerLastName(customerDTO.getLastName());

        logger.info("NotificationTransfomer:transformNotificationDTO Leaving transformer");

        return notificationDTO;
    }
}
