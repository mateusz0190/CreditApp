package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class SearchCustomerResultResponseDto {
    private List<Customer> searchResult;
}
