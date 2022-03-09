package pl.cellmer.credits.controller.dto;

import lombok.Builder;
import lombok.Data;
import pl.cellmer.credits.controller.model.Credit;

import java.util.List;

@Data
@Builder
public class GetCreditsDto {
    private List<Credit> credits;
}
