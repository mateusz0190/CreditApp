package pl.cellmer.credits.controller.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "credits")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditId;

    private String creditName;
    private Integer customerId;
    private Double value;
}
