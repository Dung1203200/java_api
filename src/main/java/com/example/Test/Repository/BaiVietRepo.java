package com.example.Test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.BaiViet;
@Repository
public interface BaiVietRepo extends JpaRepository<BaiViet, Integer>{
    List<BaiViet> findByTenBaiVietContaining(String ten);
}
