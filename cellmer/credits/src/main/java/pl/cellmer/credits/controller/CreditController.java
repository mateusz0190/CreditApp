package pl.cellmer.credits.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cellmer.credits.controller.dto.CreateCreditRequestDto;
import pl.cellmer.credits.controller.dto.CreateCreditResponseDto;
import pl.cellmer.credits.controller.dto.GetCreditsDto;
import pl.cellmer.credits.controller.model.Credit;
import pl.cellmer.credits.controller.service.CreditService;
import pl.cellmer.credits.customer.Customer;
import pl.cellmer.credits.customer.SearchCustomerResponseDto;

import java.util.List;

@RestController
@RequestMapping("credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @PostMapping
    public ResponseEntity<CreateCreditResponseDto> createCredit(@RequestBody CreateCreditRequestDto createCreditRequestDto) {


        return ResponseEntity.ok(CreateCreditResponseDto.builder()
                .creditNumber(creditService.createCredit(
                        Customer.builder()
                                .firstName(createCreditRequestDto.getFirstName())
                                .lastName(createCreditRequestDto.getLastName())
                                .pesel(createCreditRequestDto.getPesel()).build(),
                        Credit.builder()
                                .creditName(createCreditRequestDto.getCreditName())
                                .value(createCreditRequestDto.getCreditValue()).build()))
                .build());


    }

    @PostMapping
    public ResponseEntity<GetCreditsDto> getCredits() {
        try {
            return ResponseEntity.ok(GetCreditsDto.builder()
                    .credits(creditService.getCredits()).build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(GetCreditsDto.builder().build());
        }
    }


}
