package com.zk.msscbrewery.services;

import com.zk.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Alex")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }
    
    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        //todo: add a real impl
        log.debug("Updating a customer");
    }

    @Override
    public void deleteById(UUID customerId) {
        //todo: add a real impl
        log.debug("Deleting a customer");
    }
}