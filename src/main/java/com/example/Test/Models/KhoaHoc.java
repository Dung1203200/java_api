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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khoahocid")
    private int khoaHocID;
    @Column(name = "loaikhoahocid", insertable = false, updatable = false)
    private int loaiKhoaHocID;
    @Column(name = "tenkhoahoc")
    @NotNull(message = "ten khoa hoc khong duoc de trong")
    private String tenKhoaHoc;
    @Column(name = "thoigianhoc")
    @NotNull(message = "thoi gian hoc khong duoc de trong")
    private int thoiGianHoc;
    @Column(name = "gioithieu")
    @NotNull(message = "gioi thieu khong duoc de trong")
    private String gioiThieu;
    @Column(name = "noidung")
    @NotNull(message = "noi dung khong duoc de trong")
    private String noiDung;
    @Column(name = "hocphi")
    @NotNull(message = "hoc phi khong duoc de trong")
    private int hocPhi;
    @Column(name = "sohocvien")
    @NotNull(message = "so hoc vien khong duoc de trong")
    private int soHocVien;
    @Column(name = "soluongmon")
    @NotNull(message = "so luong khong duoc de trong")
    private int soLuongMon;
    @Column(name = "hinhanh")
    @NotNull(message = "hinh anh khong duoc de trong")
    private String hinhAnh;
    @ManyToOne()
    @JoinColumn(name = "loaikhoahocid")
    @JsonBackReference
    private LoaiKhoaHoc loaiKhoaHoc;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "khoaHoc" , cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DangKyHoc> dangKyHocs;

    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public int getKhoaHocID() {
        return khoaHocID;
    }
    public void setKhoaHocID(int khoaHocID) {
        this.khoaHocID = khoaHocID;
    }
    public int getLoaiKhoaHocID() {
        return loaiKhoaHocID;
    }
    public void setLoaiKhoaHocID(int loaiKhoaHocID) {
        this.loaiKhoaHocID = loaiKhoaHocID;
    }
    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }
    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }
    public int getThoiGianHoc() {
        return thoiGianHoc;
    }
    public void setThoiGianHoc(int thoiGianHoc) {
        this.thoiGianHoc = thoiGianHoc;
    }
    public String getGioiThieu() {
        return gioiThieu;
    }
    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public int getHocPhi() {
        return hocPhi;
    }
    public void setHocPhi(int hocPhi) {
        this.hocPhi = hocPhi;
    }
    public int getSoHocVien() {
        return soHocVien;
    }
    public void setSoHocVien(int soHocVien) {
        this.soHocVien = soHocVien;
    }
    public int getSoLuongMon() {
        return soLuongMon;
    }
    public void setSoLuongMon(int soLuongMon) {
        this.soLuongMon = soLuongMon;
    }
    public LoaiKhoaHoc getLoaiKhoaHoc() {
        return loaiKhoaHoc;
    }
    public void setLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        this.loaiKhoaHoc = loaiKhoaHoc;
    }
    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }
    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
    
}
