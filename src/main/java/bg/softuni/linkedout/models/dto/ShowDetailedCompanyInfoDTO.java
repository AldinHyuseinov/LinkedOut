package bg.softuni.linkedout.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ShowDetailedCompanyInfoDTO {
    private String name;

    private String town;

    private String description;

    private double budget;
}
