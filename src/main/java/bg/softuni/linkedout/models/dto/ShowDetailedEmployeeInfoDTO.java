package bg.softuni.linkedout.models.dto;

import bg.softuni.linkedout.models.enums.EducationLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ShowDetailedEmployeeInfoDTO {
    private String firstName;

    private String lastName;

    private EducationLevel educationLevel;

    private String jobTitle;

    private LocalDate birthDate;

    private Double salary;

    private String companyName;
}
