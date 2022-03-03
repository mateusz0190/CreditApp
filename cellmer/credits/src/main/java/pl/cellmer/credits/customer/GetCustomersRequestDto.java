package pl.cellmer.credits.customer;

import lombok.Data;

import java.util.List;

@Data
public class GetCustomersRequestDto {
    private List<Integer> customersIds;
}
