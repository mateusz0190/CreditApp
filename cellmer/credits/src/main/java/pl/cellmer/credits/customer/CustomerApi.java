package pl.cellmer.credits.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "customer-api", url = "${service.customer.host}/customer", decode404 = true)
public interface CustomerApi {
    @PostMapping("search")
    SearchCustomerResponseDto searchCustomer(@RequestBody SearchCustomerRequestDto searchCustomerRequestDto);

    @PostMapping
    CreateCustomerResponseDto createCustomer(@RequestBody CreateCustomerRequestDto createCustomerRequestDto);
}
