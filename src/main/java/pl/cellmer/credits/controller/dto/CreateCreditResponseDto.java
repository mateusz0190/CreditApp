package pl.cellmer.credits.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCreditResponseDto {
    private Integer creditNumber;
}
