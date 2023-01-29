package bg.softuni.linkedout.services;

import bg.softuni.linkedout.models.dto.AddCompanyDTO;
import bg.softuni.linkedout.models.dto.ShowCompanyInfoDTO;
import bg.softuni.linkedout.models.dto.ShowDetailedCompanyInfoDTO;
import bg.softuni.linkedout.models.entities.Company;
import bg.softuni.linkedout.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CompanyService {
    private final CompanyRepository companyRepository;

    private final ModelMapper mapper;

    public void addCompany(AddCompanyDTO companyDTO) {
        companyRepository.saveAndFlush(mapper.map(companyDTO, Company.class));
    }

    public List<ShowCompanyInfoDTO> allCompanies() {
        return companyRepository.findAll().stream().map(company -> mapper.map(company, ShowCompanyInfoDTO.class))
                .collect(Collectors.toList());
    }

    public ShowDetailedCompanyInfoDTO companyDetails(String companyName) {
        return mapper.map(companyRepository.findByName(companyName).orElse(null), ShowDetailedCompanyInfoDTO.class);
    }

    public void removeCompany(String companyName) {
        companyRepository.deleteByName(companyName);
    }
}
