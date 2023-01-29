package bg.softuni.linkedout.services;

import bg.softuni.linkedout.models.dto.AddEmployeeDTO;
import bg.softuni.linkedout.models.dto.ShowDetailedEmployeeInfoDTO;
import bg.softuni.linkedout.models.dto.ShowEmployeeInfoDTO;
import bg.softuni.linkedout.models.entities.Employee;
import bg.softuni.linkedout.repositories.CompanyRepository;
import bg.softuni.linkedout.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;

    private final ModelMapper mapper;

    public void addEmployee(AddEmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO, Employee.class);
        employee.setCompany(companyRepository.findByName(employeeDTO.getCompanyName()).orElse(null));

        employeeRepository.saveAndFlush(employee);
    }

    public List<ShowEmployeeInfoDTO> allEmployees() {
        return employeeRepository.findAll().stream().map(employee -> mapper.map(employee, ShowEmployeeInfoDTO.class))
                .collect(Collectors.toList());
    }

    public ShowDetailedEmployeeInfoDTO employeeInfo(String employeeFullName) {
        return mapper.map(employeeRepository.findEmployeeByFullName(employeeFullName), ShowDetailedEmployeeInfoDTO.class);
    }

    public void fireEmployee(String employeeFullName) {
        employeeRepository.deleteEmployeeByFullName(employeeFullName);
    }
}
