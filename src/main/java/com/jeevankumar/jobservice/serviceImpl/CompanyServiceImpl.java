package com.jeevankumar.jobservice.serviceImpl;

import com.jeevankumar.jobservice.entity.Company;
import com.jeevankumar.jobservice.repository.CompanyRepository;
import com.jeevankumar.jobservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
        log.info("saved company  into database with resources : {}",company);


    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
       return this.companyRepository.findById(id).orElse(null);

    }

    @Override
    public boolean updateCompanyById(Long id, Company company) {
        if (companyRepository.existsById(id)) {
             Company companySavedToDB= Company.builder()
                    .id(company.getId())
                    .name(company.getName())
                    .description(company.getDescription())
                    .build();
             companyRepository.save(companySavedToDB);
             log.info("saved with into the database :{}",companySavedToDB);
             return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
