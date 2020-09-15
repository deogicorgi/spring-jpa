package io.github.deogicorgi.spring.jpa.service;

import io.github.deogicorgi.spring.jpa.entity.Company;
import io.github.deogicorgi.spring.jpa.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company findById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElseThrow();
    }

    public void remove(Company company){
        companyRepository.delete(company);
    }
}
