package io.github.deogicorgi.spring.jpa.repository;

import io.github.deogicorgi.spring.jpa.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
