package bg.softuni.linkedout.models.dto;

import bg.softuni.linkedout.utils.validation.UniqueCompanyName;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddCompanyDTO {
    @NotEmpty(message = "Company name must not be null or empty!")
    @UniqueCompanyName
    @Size(min = 2, max = 10, message = "Company name must be between 2 and 10 characters!")
    private String name;

    @NotEmpty(message = "Town name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Town name must be between 2 and 10 characters!")
    private String town;

    @NotEmpty(message = "Description must not be null or empty!")
    @Size(min = 10, message = "Description must be at least 10 characters!")
    private String description;

    @Min(value = 1, message = "Budget must be a positive number!")
    @NotNull(message = "Budget must not be null or empty!")
    private Double budget;
}
