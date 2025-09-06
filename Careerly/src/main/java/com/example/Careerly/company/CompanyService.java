package com.example.Careerly.company;

import com.example.Careerly.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();

    void AddCompany(Company comp);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id, Company comp);
}
