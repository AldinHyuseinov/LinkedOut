package bg.softuni.linkedout.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "companies")
@Getter
@Setter
public class Company extends BaseEntity {
    @Column(columnDefinition = "DECIMAL(19,2)", nullable = false)
    private Double budget;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String town;

    @OneToMany(mappedBy = "company", targetEntity = Employee.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public Company() {
        employees = new HashSet<>();
    }
}
