package pl.cellmer.credits.controller.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class CreateCreditRequestDto {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    //for pesel should be added checking are there eleven digits
    @NotBlank
    private String pesel;
    @NotBlank
    private String creditName;
    @Min(value = 1)
    private Double creditValue;
}
