package bg.softuni.linkedout.models.dto;

import bg.softuni.linkedout.models.enums.EducationLevel;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AddEmployeeDTO {
    @NotEmpty(message = "First name cannot be null or empty!")
    @Size(min = 2, message = "First name should be at least 2 characters long!")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null or empty!")
    @Size(min = 2, message = "Last name should be at least 2 characters long!")
    private String lastName;

    @NotNull(message = "Please choose an education level!")
    private EducationLevel educationLevel;

    @NotEmpty(message = "Please choose a company!")
    private String companyName;

    @NotEmpty(message = "Job title cannot be null or empty!")
    private String jobTitle;

    @NotNull(message = "Birth date cannot be null or empty!")
    private LocalDate birthDate;

    @NotNull(message = "Salary cannot be null or empty!")
    @Min(value = 1, message = "Salary must be a positive number!")
    private Double salary;
}
