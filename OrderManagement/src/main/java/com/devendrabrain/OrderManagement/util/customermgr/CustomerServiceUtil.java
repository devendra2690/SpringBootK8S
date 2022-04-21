package com.devendrabrain.OrderManagement.util.customermgr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class CustomerServiceUtil {

    private Logger logger = LoggerFactory.getLogger(CustomerServiceUtil.class);


    @Autowired
    Environment environment;

    public ResponseEntity<CustomerDTO> fetchCustomerRecords(Long customerId) {

        HttpHeaders headers = new HttpHeaders();
        /*
         * Setting Request in headers for backtracking
         */
        headers.set("X-RS-RequestId", MDC.get("X-RS-TraceId"));
        /*
         * Set Source Application in headers, so that we can save it
         * EventHttpLog, which application we are calling
         */
        headers.set("X-RS-SourceApplication", "CustomerMgr");
        headers.set("X-RS-ApiName", "Outbound_CUST_MGR_CUSTOMER_FETCH_BY_ID");

        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

        ResponseEntity<CustomerDTO> responseEntity = null;
        RestTemplate restTemplate = new RestTemplate();

        try {
            // Add this to property file
            // Not going through APIGateway beacuse need to add entry in GateWayConfig.java for NotificationMgr
            // I AM LAZY :)
            // Hostname used here should match with service name defined in docker-compose file

            logger.info("ConsumerServiceUtil:fetchCustomerRecords", requestEntity);
            responseEntity = restTemplate.exchange(new URI(
                            "http://customermanagament-cluster-ip-service:8081/CustomerMgr/" + customerId),
                    HttpMethod.GET, requestEntity, CustomerDTO.class);
        } catch (RestClientException | IllegalStateException | URISyntaxException e) {
           /* log.error("ClassName : " + this.getClass().getSimpleName() + " Exception in calling OrgMgr", e);
            throw new ApiInternalErrorException(ErrorCategory.InternalServerError.getCode(),
                    ErrorCategory.InternalServerError.getMessage(), e.getMessage() + " Exception in calling OrgMgr");*/
        } catch (Exception e) {
           /* log.error("ClassName : " + this.getClass().getSimpleName()
                    + " OrgMgr is down/Unknown exception while calling OrgMgr", e);
            throw new ApiInternalErrorException(ErrorCategory.InternalServerError.getCode(),
                    ErrorCategory.InternalServerError.getMessage(), "OrgMgr is down/Unknown exception");*/
                    logger.error("ConsumerServiceUtil:fetchCustomerRecords Error Occured", e);
        }

        return responseEntity;
    }
}
