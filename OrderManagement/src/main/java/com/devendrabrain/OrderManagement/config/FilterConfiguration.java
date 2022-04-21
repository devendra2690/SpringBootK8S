package com.devendrabrain.OrderManagement.config;

import com.devendrabrain.OrderManagement.filter.LoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
public class FilterConfiguration {

    @Autowired
    LoggingFilter loggingFilter;

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(loggingFilter);
        filterRegistrationBean.setOrder(0);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return  filterRegistrationBean;
    }

}
