package pl.cellmer.credits.service;

import pl.cellmer.credits.persistance.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.cellmer.credits.controller.model.Credit;
import pl.cellmer.credits.persistance.CreditEntity;
import pl.cellmer.credits.customer.Customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final CustomerService customerService;

    public Integer createCredit(Customer customer, Credit credit) {
        Optional<Customer> foundCustomer = customerService.searchCustomer(customer.getPesel())
                .or(() -> customerService.createCustomer(customer));

        if (foundCustomer.isPresent()) {
            CreditEntity creditEntity = creditRepository.save(CreditEntity.builder()
                    .creditName(credit.getCreditName())
                    .value(credit.getValue())
                    .customerId(customer.getCustomerId())
                    .build());

            return creditEntity.getCreditId();
        }

        throw new RuntimeException("Customer not found and not created");
    }

    public List<Credit> getCredits() {
        return creditRepository.findAll().stream().map(creditEntity -> Credit.builder()
                        .creditId(creditEntity.getCreditId())
                        .creditName(creditEntity.getCreditName())
                        .value(creditEntity.getValue())
                        .build())
                .collect(Collectors.toList());
    }
}
