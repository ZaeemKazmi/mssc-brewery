package com.zk.msscbrewery.web.mappers;

import com.zk.msscbrewery.domain.Customer;
import com.zk.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

}
