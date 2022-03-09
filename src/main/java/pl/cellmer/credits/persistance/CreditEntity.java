package pl.cellmer.credits.persistance;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credits")
@ToString
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditId;

    private String creditName;
    private Integer customerId;
    private Double value;
}
