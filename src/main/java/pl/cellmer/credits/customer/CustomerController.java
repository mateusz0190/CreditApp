package pl.cellmer.credits.customer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();
    private int index = 0;

    @PostMapping
    public CreateCustomerResponseDto createCustomer(@RequestBody CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = Customer.builder()
                .customerId(index++)
                .firstName(createCustomerRequestDto.getFirstName())
                .lastName(createCustomerRequestDto.getLastName())
                .pesel(createCustomerRequestDto.getPesel())
                .build();
        customers.add(customer);
        return CreateCustomerResponseDto.builder().customerId(customer.getCustomerId()).build();
    }

    @PostMapping("filtered")
    public GetCustomersResponseDto getCustomers(@RequestBody GetCustomersRequestDto getCustomersRequestDto) {
        List<Customer> customers = this.customers.stream().filter(customer -> getCustomersRequestDto.getCustomersIds()
                        .contains(customer.getCustomerId()))
                .collect(Collectors.toList());
        return GetCustomersResponseDto.builder().customers(customers).build();
    }

    @PostMapping("search")
    public SearchCustomerResponseDto searchCustomer(@RequestBody SearchCustomerRequestDto searchCustomerRequestDto) {
        List<Customer> customers = this.customers.stream().filter(customer -> customer.getPesel().equals(searchCustomerRequestDto.getPesel()))
                .collect(Collectors.toList());
        return SearchCustomerResponseDto.builder().searchResult(customers).build();
    }

}
