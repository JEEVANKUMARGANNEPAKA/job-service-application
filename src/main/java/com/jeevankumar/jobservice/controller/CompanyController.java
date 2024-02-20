package com.jeevankumar.jobservice.controller;

import com.jeevankumar.jobservice.entity.Company;
import com.jeevankumar.jobservice.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        if(company !=null){
            return new ResponseEntity<>("Company created successfully with id :"+company.getId(),
                    HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Company is not crated with with id : "+company.getId(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
         List<Company> companyReturnObj=companyService.getAllCompany();
         if (companyReturnObj !=null){
             return new ResponseEntity<>(companyReturnObj,HttpStatus.OK);
         }else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
    }

    @GetMapping("/{id}")
    private ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company companyReturnObj= companyService.getCompanyById(id);
        if(companyReturnObj !=null){
            return new ResponseEntity<>(companyReturnObj,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id,
                                                    @RequestBody Company company){
         boolean existingObjet= companyService.updateCompanyById(id,company);
         if (existingObjet){
             return new ResponseEntity<>("Updated is successfully with id : "+id,
                     HttpStatus.OK);
         }else {
             return new ResponseEntity<>("update is not completed because no resource with id :"+id,
                     HttpStatus.NOT_FOUND);
         }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        boolean deletedObj= companyService.deleteCompanyById(id);
        if (deletedObj){
            return new ResponseEntity<>("Deleted company successfully with id is :"+id,
                    HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Resouce for this id for deleting :"+id,
                    HttpStatus.NOT_FOUND);
        }
    }
}
