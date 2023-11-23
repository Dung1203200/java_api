package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.DangKyHoc;
@Repository
public interface DangKyHocRepo extends JpaRepository<DangKyHoc, Integer>{
    
}
