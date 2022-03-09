package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

@Builder //to build customer
@Data
public class SearchCustomerRequestDto {
    private String pesel;
}
