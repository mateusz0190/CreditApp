package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data //settery i gettery, equals i toString
@Builder
public class GetCustomersResponseDto {
    private List<Customer> customers;

}
