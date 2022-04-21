package com.devendrabrain.OrderManagement.util.billing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class BillingServiceUtil {

    private Logger logger = LoggerFactory.getLogger(BillingServiceUtil.class);


    @Autowired
    Environment environment;

    public ResponseEntity<BillingDTO> processBillingRecords(BillingDTO billingDTO) {

        HttpHeaders headers = new HttpHeaders();
        /*
         * Setting Request in headers for backtracking
         */
        headers.set("X-RS-RequestId", MDC.get("X-RS-TraceId"));
        /*
         * Set Source Application in headers, so that we can save it EventHttpLog, which
         * application we are calling
         */
        headers.set("X-RS-SourceApplication", "OrderMgr");
        headers.set("X-RS-ApiName", "Outbound_BillingMgr_BILLING_MGR_SAVE_BILLING_RECORD");

        HttpEntity<BillingDTO> requestEntity = new HttpEntity<BillingDTO>(billingDTO,
                headers);
        ParameterizedTypeReference<BillingDTO> typeRef = new ParameterizedTypeReference<BillingDTO>() {
        };
        ResponseEntity<BillingDTO> responseEntity = null;

        try {
            
            // Add this to property file
            // Not going through APIGateway beacuse need to add entry in GateWayConfig.java for NotificationMgr
            // I AM LAZY :)
            // Hostname used here should match with service name defined in docker-compose file
            
            logger.info("BillingServiceUtil:processBillingRecords Sending request", requestEntity);
            String url = "http://inventorygateway-cluster-ip-service:9890/BillingMgr/process";
            UriComponentsBuilder builder = UriComponentsBuilder
                    .fromHttpUrl(url);
            RestTemplate restTemplate = new RestTemplate();
            responseEntity = restTemplate
                    .exchange(
                            builder.toUriString(),
                            HttpMethod.POST, requestEntity, typeRef);
        } catch (RestClientException | IllegalStateException  e) {
            logger.error("BillingServiceUtil:processBillingRecords Error Occured", e);
           // RSLogUtil.high(e);
        } catch (Exception e) {
           // log.error("ClassName : " + this.getClass().getSimpleName()
                //d    + " OrgMgr is down/Unknown exception while calling OrgMgr", ExceptionUtils.getStackTrace(e));
            //throw new ApiInternalErrorException(ErrorCategory.InternalServerError.getCode(),
                  //  ErrorCategory.InternalServerError.getMessage(), "OrgMgr is down/Unknown exception");
                  logger.error("BillingServiceUtil:processBillingRecords Error Occured", e);
        }

        return responseEntity;
    }
}
