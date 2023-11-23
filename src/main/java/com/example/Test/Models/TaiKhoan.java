package com.example.Test.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoanid")
    private int taiKhoanID;
    @Column(name = "tennguoidung")
    private String tenNguoiDung;
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;
    @Column(name = "quyenhanid", insertable = false, updatable = false)
    private int quyenHanID;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DangKyHoc> dangKyHocs;
    @ManyToOne()
    @JoinColumn(name = "quyenhanid")
    @JsonBackReference
    private QuyenHan quyenHan;
    
    public int getTaiKhoanID() {
        return taiKhoanID;
    }
    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }
    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }
    public String getTaiKhoan() {
        return taiKhoan;
    }
    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    public String getMatKhau() {
        return matKhau;
    }
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public int getQuyenHanID() {
        return quyenHanID;
    }
    public void setQuyenHanID(int quyenHanID) {
        this.quyenHanID = quyenHanID;
    }
    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }
    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
    public QuyenHan getQuyenHan() {
        return quyenHan;
    }
    public void setQuyenHan(QuyenHan quyenHan) {
        this.quyenHan = quyenHan;
    }
    

}
