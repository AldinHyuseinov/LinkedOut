package bg.softuni.linkedout.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ShowEmployeeInfoDTO {
    private String firstName;

    private String lastName;

    private String jobTitle;

    private LocalDate birthDate;
}
