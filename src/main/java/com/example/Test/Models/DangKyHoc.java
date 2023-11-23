package com.example.Test.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "dangkyhoc")
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dangkyhocid")
    private int dangKyHocID;
    @Column(name = "khoahocid", insertable = false, updatable = false)
    private int khoaHocID;
    @Column(name = "hocvienid", insertable = false, updatable = false)
    private int hocVienID;
    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;
    @Column(name = "tinhtranghocid", insertable = false, updatable = false)
    private int tinhTrangHocID;
    @Column(name = "taikhoanid", insertable = false, updatable = false)
    private int taiKhoanID;
    @ManyToOne()
    @JoinColumn(name = "khoahocid")
    @JsonBackReference
    private KhoaHoc khoaHoc;
    @ManyToOne()
    @JoinColumn(name = "hocvienid")
    @JsonBackReference
    private HocVien hocVien;
    @ManyToOne()
    @JoinColumn(name = "tinhtranghocid")
    @JsonBackReference
    private TinhTrangHoc tinhTrangHoc;  
    @ManyToOne()
    @JoinColumn(name = "taikhoanid")
    @JsonBackReference
    private TaiKhoan taiKhoan;
    
    public int getDangKyHocID() {
        return dangKyHocID;
    }
    public void setDangKyHocID(int dangKyHocID) {
        this.dangKyHocID = dangKyHocID;
    }
    public int getKhoaHocID() {
        return khoaHocID;
    }
    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }
    public int getHocVienID() {
        return hocVienID;
    }
    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }
    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }
    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }
    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }
    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }
    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
    public int getTinhTrangHocID() {
        return tinhTrangHocID;
    }
    public void setTinhTrangHocID(int tinhTrangHocID) {
        this.tinhTrangHocID = tinhTrangHocID;
    }
    public int getTaiKhoanID() {
        return taiKhoanID;
    }
    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }
    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }
    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
    public HocVien getHocVien() {
        return hocVien;
    }
    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }
    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }
    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }
    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }
    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    } 
    
}
