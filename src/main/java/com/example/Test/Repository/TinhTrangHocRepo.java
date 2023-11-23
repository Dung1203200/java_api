package com.example.Test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Test.Models.TinhTrangHoc;
@Repository
public interface TinhTrangHocRepo extends JpaRepository<TinhTrangHoc, Integer>{

}

