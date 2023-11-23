package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.LoaiKhoaHoc;
@Repository
public interface LoaiKhoaHocRepo extends JpaRepository<LoaiKhoaHoc, Integer>{
    
}
