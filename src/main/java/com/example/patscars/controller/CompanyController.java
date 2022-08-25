package com.example.patscars.controller;

import com.example.patscars.dto.ApiResponse;
import com.example.patscars.model.Company;
import com.example.patscars.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping
    public ResponseEntity<List> getTeacher(){
        List<Company>companies=companyService.getCompany();
        return ResponseEntity.status(200).body(companies);

    }
    @PostMapping("/register")
    private ResponseEntity addCompany(@RequestBody @Valid Company company){
        companyService.add(company);
        return ResponseEntity.status(200).body(new ApiResponse("Company added",200));
    }
    @PutMapping("/update")
    private ResponseEntity updateCompany(@RequestParam @Valid Company company, @RequestBody Integer id){
        companyService.updateCompny(company,id);
        return ResponseEntity.status(200).body(new ApiResponse("Company updated",200));
    }
    @DeleteMapping("/delete")
    private ResponseEntity deleteCompany(@RequestBody @Valid Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.status(200).body(new ApiResponse("company deleted ",200));
    }
       @GetMapping("/Nissan")
    public ResponseEntity<List<Company>> findCompanyByNissan(@RequestParam Integer Nissan){
       List company=  companyService.FindCompanyByNissan(Nissan);
      return ResponseEntity.status(200).body(company);
    }

   }


