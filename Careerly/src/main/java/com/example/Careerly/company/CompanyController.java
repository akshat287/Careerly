package com.example.Careerly.company;

import org.hibernate.metamodel.internal.EmbeddableRepresentationStrategyPojo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> companies=companyService.getAllCompany();
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBYId(@PathVariable Long id, @RequestBody Company comp){
        boolean bool=companyService.updateCompany(id,comp);
        if(bool)
            return new ResponseEntity<>("Updated Successfully!!",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCompany(@RequestBody Company comp){
        companyService.AddCompany(comp);
        return new ResponseEntity<>("Added Successfully!!",HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        boolean bool=companyService.deleteCompanyById(id);
        if(bool)
            return new ResponseEntity<>("Deleted Successfully!!",HttpStatus.OK);
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id){
        Company comp=companyService.getCompanyById(id);
        if(comp!=null)
            return new ResponseEntity<>(comp,HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
