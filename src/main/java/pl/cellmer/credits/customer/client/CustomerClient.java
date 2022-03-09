package pl.cellmer.credits.customer.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.cellmer.credits.customer.CreateCustomerRequestDto;
import pl.cellmer.credits.customer.CreateCustomerResponseDto;
import pl.cellmer.credits.customer.SearchCustomerRequestDto;
import pl.cellmer.credits.customer.SearchCustomerResponseDto;

@RequiredArgsConstructor
@Component
public class CustomerClient {

    private final RestTemplate restTemplate;

    @Value("${service.customer.host}")
    private String customerHost;

    public SearchCustomerResponseDto searchCustomer(SearchCustomerRequestDto searchCustomerRequestDto) {
        ResponseEntity<SearchCustomerResponseDto> response = restTemplate.postForEntity(customerHost + "/customer", searchCustomerRequestDto, SearchCustomerResponseDto.class);
        return response.getBody();
    }

    public CreateCustomerResponseDto createCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
        ResponseEntity<CreateCustomerResponseDto> response = restTemplate.postForEntity(customerHost + "/customer", createCustomerRequestDto, CreateCustomerResponseDto.class);
        return response.getBody();
    }
}
