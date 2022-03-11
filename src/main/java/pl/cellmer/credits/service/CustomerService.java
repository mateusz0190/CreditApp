package pl.cellmer.credits.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cellmer.credits.customer.*;
import pl.cellmer.credits.customer.client.CustomerClient;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {


    private final CustomerClient customerClient;

    public Optional<Customer> searchCustomer(String pesel) {
        SearchCustomerResultResponseDto foundCustomer = customerClient.searchCustomer(SearchCustomerResultRequestDto.builder().pesel(pesel).build());

        return foundCustomer.getSearchResult().stream().findFirst();
    }

    public Optional<Customer> createCustomer(Customer customer) {

        CreateCustomerResponseDto customerController = new CustomerController().createCustomer(CreateCustomerRequestDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .pesel(customer.getPesel()).build());
        Integer customerId = customerController.getCustomerId();
        CreateCustomerResponseDto createdCustomer = customerClient.createCustomer(CreateCustomerRequestDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .pesel(customer.getPesel()).build());
        customerId = createdCustomer.getCustomerId();
        createdCustomer.setCustomerId(customerId);
        customer.setCustomerId(customerId);
        return Optional.of(customer);

    }

}
