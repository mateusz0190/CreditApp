package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class CreateCustomerRequestDto {
    private String firstName;
    private String lastName;
    private String pesel;

}
