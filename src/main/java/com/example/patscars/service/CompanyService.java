package com.example.patscars.service;

import com.example.patscars.model.Company;
import com.example.patscars.model.User;
import com.example.patscars.repository.CompnyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    public final CompnyRepository companyRepository;
    
    public List<Company> getCompany() {
        return companyRepository.findAll();

        
    }

    public void add(Company company) {
        String hashedPassword = new BCryptPasswordEncoder().encode(company.getPassword());
        company.setPassword(hashedPassword);
        companyRepository.save(company);
    }

    public void updateCompny(Company company, Integer id) {
        Company oldcompany = companyRepository.getById(id);
        oldcompany.setUsername(company.getUsername());
        oldcompany.setPassword(company.getPassword());
        oldcompany.setEmail(company.getEmail());
        oldcompany.setRule(company.getRule());
    }

    public void deleteCompany(Integer id) {
        Company oldCompany = companyRepository.getById(id);
        companyRepository.delete(oldCompany);
    }

    public List FindCompanyByNissan(Integer Nissan) {
        return companyRepository.findAll();
    }



}

    

