package de.leuphana.shop.webshop.mappers;

import de.leuphana.shop.webshop.domain.Customer;
import de.leuphana.shop.webshop.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
