package bg.softuni.linkedout.models.entities;

import bg.softuni.linkedout.models.enums.EducationLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
public class Employee extends BaseEntity {
    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private String lastName;

    @Column(columnDefinition = "DECIMAL(19,2)", nullable = false)
    private Double salary;

    @ManyToOne
    private Company company;
}
