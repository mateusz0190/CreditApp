package pl.cellmer.credits.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCustomerResponseDto {
    private Integer customerId;

}
