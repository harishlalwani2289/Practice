package com.harish.mapstruct;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-26T15:02:45+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 11.0.4 (AdoptOpenJDK)"
)
*/
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO mapCustomerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        return customerDTO;
    }
}
