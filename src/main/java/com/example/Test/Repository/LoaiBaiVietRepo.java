package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.LoaiBaiViet;
@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet, Integer>{
    
}
