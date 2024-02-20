package com.jeevankumar.jobservice.service;

import com.jeevankumar.jobservice.entity.Company;

import java.util.List;

public interface CompanyService {

    void createCompany(Company company);
    List<Company> getAllCompany();
    Company getCompanyById(Long id);
    boolean updateCompanyById(Long id,Company company);
    boolean deleteCompanyById(Long id);
}
