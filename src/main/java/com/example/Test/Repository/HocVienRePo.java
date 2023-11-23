package com.example.Test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Test.Models.HocVien;

@Repository
public interface HocVienRePo extends JpaRepository<HocVien, Integer>{
    List<HocVien> findByHoTenContainingOrEmailContaining(String ten, String email);
}
