package com.example.Test.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.KhoaHoc;
@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc, Integer>{
    Page<KhoaHoc> findByTenKhoaHocContaining(String ten, Pageable pageable);
    List<KhoaHoc> findByTenKhoaHocContaining(String ten);
}
