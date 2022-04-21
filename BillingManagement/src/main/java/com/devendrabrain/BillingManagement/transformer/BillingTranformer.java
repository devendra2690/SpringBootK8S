package com.devendrabrain.BillingManagement.transformer;

import com.devendrabrain.BillingManagement.bo.BillingBO;
import com.devendrabrain.BillingManagement.dto.BillingDTO;
import com.devendrabrain.BillingManagement.entity.Billing;

import java.util.Date;

public class BillingTranformer {

    public static BillingBO tranformBillingDTOToBillingBO(BillingDTO billingDTO, BillingBO billingBO) {

        if(billingDTO != null) {
            if(billingDTO.getBillingId() != null) {
                billingBO.setBillingId(billingDTO.getBillingId());
            }
            if(billingDTO.getCustomerId() != null) {
                billingBO.setCustomerId(billingDTO.getCustomerId());
            }
            if(billingDTO.getOrderId() != null) {
                billingBO.setOrderId(billingDTO.getOrderId());
            }
            if(billingDTO.getTotalBillingAmount() != null) {
                billingBO.setTotalBillingAmount(billingDTO.getTotalBillingAmount());
            }
            if(billingDTO.getOrderDate() != null) {
                billingBO.setOrderDate(billingDTO.getOrderDate());
            }else{
                billingBO.setOrderDate(new Date());
            }
        }

        return billingBO;
    }


    public static BillingDTO tranformBillingBOToBillingDTO(BillingBO billingBO, BillingDTO billingDTO) {

        if(billingBO != null) {
            if(billingBO.getBillingId() != null) {
                billingDTO.setBillingId(billingBO.getBillingId());
            }
            if(billingBO.getCustomerId() != null) {
                billingDTO.setCustomerId(billingBO.getCustomerId());
            }
            if(billingBO.getOrderId() != null) {
                billingDTO.setOrderId(billingBO.getOrderId());
            }
            if(billingBO.getTotalBillingAmount() != null) {
                billingDTO.setTotalBillingAmount(billingBO.getTotalBillingAmount());
            }
            if(billingBO.getOrderDate() != null) {
                billingDTO.setOrderDate(billingBO.getOrderDate());
            }else{
                billingDTO.setOrderDate(new Date());
            }
        }

        return billingDTO;
    }


    public static BillingBO tranformBillingToBillingBO(Billing billing, BillingBO billingBO) {

        if(billing != null) {
            if(billing.getBillingId() != null) {
                billingBO.setBillingId(billing.getBillingId());
            }
            if(billing.getCustomerId() != null) {
                billingBO.setCustomerId(billing.getCustomerId());
            }
            if(billing.getOrderId() != null) {
                billingBO.setOrderId(billing.getOrderId());
            }
            if(billing.getTotalBillingAmount() != null) {
                billingBO.setTotalBillingAmount(billing.getTotalBillingAmount());
            }
            if(billing.getOrderDate() != null) {
                billingBO.setOrderDate(billing.getOrderDate());
            }else{
                billingBO.setOrderDate(new Date());
            }
        }

        return billingBO;
    }

    public static Billing tranformBillingBOToBilling(BillingBO billingBO, Billing billing) {

        if(billingBO != null) {
            if(billingBO.getBillingId() != null) {
                billing.setBillingId(billingBO.getBillingId());
            }
            if(billingBO.getCustomerId() != null) {
                billing.setCustomerId(billingBO.getCustomerId());
            }
            if(billingBO.getOrderId() != null) {
                billing.setOrderId(billingBO.getOrderId());
            }
            if(billingBO.getTotalBillingAmount() != null) {
                billing.setTotalBillingAmount(billingBO.getTotalBillingAmount());
            }
            if(billingBO.getOrderDate() != null) {
                billing.setOrderDate(billingBO.getOrderDate());
            }else{
                billing.setOrderDate(new Date());
            }
        }

        return billing;
    }
}
