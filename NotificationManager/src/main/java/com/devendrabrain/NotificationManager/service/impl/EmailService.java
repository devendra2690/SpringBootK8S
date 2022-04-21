package com.devendrabrain.NotificationManager.service.impl;

import com.devendrabrain.NotificationManager.dto.NotificationDTO;

public interface EmailService {

    public void sendEmail(NotificationDTO notificationDTO);
}
