package com.harish.mapstruct;

import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDTO mapCustomerToCustomerDTO(Customer customer);
}
