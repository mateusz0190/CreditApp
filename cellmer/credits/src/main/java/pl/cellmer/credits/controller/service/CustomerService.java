package pl.cellmer.credits.controller.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cellmer.credits.customer.*;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerApi customerApi;

    public Optional<Customer> searchCustomer(String pesel) {
        SearchCustomerResponseDto foundCustomer = customerApi.searchCustomer(SearchCustomerRequestDto.builder()
                .pesel(pesel).build());

        return foundCustomer.getSearchResult().stream().findFirst();
    }

    public Optional<Customer> createCustomer(Customer customer) {
        CreateCustomerResponseDto createdCustomer = customerApi.createCustomer(CreateCustomerRequestDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .pesel(customer.getPesel()).build());
        Integer customerId = createdCustomer.getCustomerId();
        customer.setCustomerId(customerId);
        return Optional.of(customer);

    }

}
