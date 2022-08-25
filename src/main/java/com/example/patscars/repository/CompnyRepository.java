package com.example.patscars.repository;

import com.example.patscars.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompnyRepository extends JpaRepository<Company,Integer> {
}
