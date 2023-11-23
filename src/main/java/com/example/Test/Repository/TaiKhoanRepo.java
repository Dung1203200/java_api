package com.example.Test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Test.Models.TaiKhoan;
@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, Integer> {
    List<TaiKhoan> findByTenNguoiDungContaining(String ten);
    List<TaiKhoan> findByTaiKhoanContaining(String ten);
}
