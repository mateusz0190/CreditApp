package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

//@Builder //to build customerService
@Data
public class SearchCustomerRequestDto {
    private String pesel;
}
