package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.ChuDe;
@Repository
public interface ChuDeRepo extends JpaRepository<ChuDe, Integer>{
    
}
