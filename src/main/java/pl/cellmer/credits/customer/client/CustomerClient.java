package pl.cellmer.credits.customer.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.cellmer.credits.customer.*;

@RequiredArgsConstructor
@Component
public class CustomerClient {

    private final RestTemplate restTemplate;

    @Value("${service.customer.host}")
    private String customerHost;

    public SearchCustomerResultResponseDto searchCustomer(SearchCustomerResultRequestDto searchCustomerRequestDto) {
        ResponseEntity<SearchCustomerResultResponseDto> response = restTemplate.postForEntity(customerHost + "/customer", searchCustomerRequestDto, SearchCustomerResultResponseDto.class);
        return response.getBody();
    }

    public CreateCustomerResponseDto createCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
        ResponseEntity<CreateCustomerResponseDto> response = restTemplate.postForEntity(customerHost + "/customer", createCustomerRequestDto, CreateCustomerResponseDto.class);
        return response.getBody();
    }
}
