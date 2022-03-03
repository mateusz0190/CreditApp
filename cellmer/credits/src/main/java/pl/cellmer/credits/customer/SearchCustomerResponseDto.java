package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchCustomerResponseDto {
    private List<Customer> searchResult;
}
