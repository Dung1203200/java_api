package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.QuyenHan;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan, Integer>{
    
}
