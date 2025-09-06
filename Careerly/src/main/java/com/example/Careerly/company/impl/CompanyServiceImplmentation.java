package com.example.Careerly.company.impl;

import com.example.Careerly.company.Company;
import com.example.Careerly.company.CompanyRepo;
import com.example.Careerly.company.CompanyService;
import com.example.Careerly.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplmentation implements CompanyService {
    private CompanyRepo companyRepo;

    public CompanyServiceImplmentation(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }


    public List<Company> getAllCompany(){
        return companyRepo.findAll();
    }


//    @Override
//    public List<Company> getAllCompany() {
//        return List.of();
//    }

    @Override
    public void AddCompany(Company comp) {
        companyRepo.save(comp);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepo.getById(id);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepo.existsById(id)){
            companyRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(Long id, Company comp) {
        Optional<Company> companyOptional=companyRepo.findById(id);
        if(companyOptional.isPresent()){
            Company company=companyOptional.get();
            company.setName(company.getName());
            company.setDescription(company.getDescription());
            company.setJobs(company.getJobs());
            companyRepo.save(company);
            return true;
        }
         return false;
    }



}
