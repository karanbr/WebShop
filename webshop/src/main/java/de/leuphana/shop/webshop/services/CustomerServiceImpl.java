package de.leuphana.shop.webshop.services;

import de.leuphana.shop.webshop.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .customerId(UUID.randomUUID())
                .name("Peter")
                .address("Hamburg")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .customerId(UUID.randomUUID())
                .name("John")
                .address("New York")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        // todo impl
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Deleting a Customer...");
    }
}
