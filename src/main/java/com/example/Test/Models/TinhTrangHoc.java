package com.example.Test.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tinhtranghoc")
public class TinhTrangHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tinhtranghocid")
    private int tinhTrangHocID;
    @Column(name = "tentinhtranghoc")
    private String tenTinhTrangHoc;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tinhTrangHoc", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DangKyHoc> dangKyHocs;
    public int getTinhTrangHocID() {
        return tinhTrangHocID;
    }
    public void setTinhTrangHocID(int tinhTrangHocID) {
        this.tinhTrangHocID = tinhTrangHocID;
    }
    public String getTenTinhTrangHoc() {
        return tenTinhTrangHoc;
    }
    public void setTenTinhTrangHoc(String tenTinhTrangHoc) {
        this.tenTinhTrangHoc = tenTinhTrangHoc;
    }
    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }
    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
    
}
