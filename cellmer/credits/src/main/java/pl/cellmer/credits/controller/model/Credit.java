package pl.cellmer.credits.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Credit {
    private Integer creditId;
    private String creditName;
    private Integer customerId;
    private Double value;
}
