package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String pesel;


}
