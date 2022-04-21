package com.devendrabrain.customer.management.controller;

import com.devendrabrain.customer.management.bo.CustomerBO;
import com.devendrabrain.customer.management.constant.ApiName;
import com.devendrabrain.customer.management.dto.CustomerDTO;
import com.devendrabrain.customer.management.service.CustomerService;
import com.devendrabrain.customer.management.transform.CustomerTransformer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/CustomerMgr")
public class CustomerInfoController {

    @Autowired
    CustomerService customerService;

      @GetMapping("/listAll")
      public List<CustomerDTO> listAll() {

          MDC.put("X-RS-ApiName", ApiName.CUST_MGR_FETCH_ALL_CUSTOMER_RECORD.name());

          List<CustomerBO> customerBOList = customerService.fetchAll();

          //Transform Customer BO to Customer DTO
          List<CustomerDTO> customerDTOList = new ArrayList<>();
          for(CustomerBO customerBO : customerBOList) {
              CustomerDTO customerDTO = new CustomerDTO();
              CustomerTransformer.transformCustomerBOTOCustomerDTO(customerBO,customerDTO);
              customerDTOList.add(customerDTO);
          }

          return customerDTOList;
      }

    @GetMapping("/{id}")
    public CustomerDTO fetchById(@PathVariable("id") Long customerId) {

        MDC.put("X-RS-ApiName", ApiName.CUST_MGR_CUSTOMER_FETCH_BY_ID.name());

        CustomerBO customerBO = customerService.fetchById(customerId);

        //Transform
        CustomerDTO customerDTO = CustomerTransformer.transformCustomerBOTOCustomerDTO(customerBO,new CustomerDTO());

        return customerDTO;
    }

    @PostMapping(path = "/create")
    public CustomerDTO createCustomerRecord(@RequestBody CustomerDTO customerDTO) {

        MDC.put("X-RS-ApiName", ApiName.CUST_MGR_CREATE_CUSTOMER.name());

        CustomerBO  customerBO = new CustomerBO();
        // Transform DTO object to BO object
        customerBO = CustomerTransformer.transformCustomerDTOTOCustomerBO(customerDTO,customerBO);
        customerBO = customerService.createRecords(customerBO);

        // Transform Customer to CustomerBO
        customerDTO = CustomerTransformer.transformCustomerBOTOCustomerDTO(customerBO,customerDTO);

        return customerDTO;
    }

    @PatchMapping("/updateConsumer")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO) {

        MDC.put("X-RS-ApiName", ApiName.CUST_MGR_UPDATE_CUSTOMER.name());

        CustomerBO  customerBO = new CustomerBO();
          customerBO = customerService.updateRecords(customerBO);
          return null;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Object> deleteCustomer(@PathVariable("id") Long customerId) {

        MDC.put("X-RS-ApiName", ApiName.CUST_MGR_DELETE_CUSTOMER.name());

        customerService.deleteRecords(customerId);

        Map<String,Object> responseMap =  new HashMap<>();
        responseMap.put("Message","Customer record "+customerId+" deleted Successfully ..!!");

        return responseMap;
    }

    @GetMapping("/logout")
    public String logout() {

          return "Log Out You MotherFucker ...!!";
    }
}
