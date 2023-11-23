package com.example.Test.Models;

import java.time.LocalDate;
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
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienID;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "email")
    @Email(message = "Email is not valid")
    private String email;
    @Column(name = "tinhthanh")
    private String tinhThanh;
    @Column(name = "quanhuyen")
    private String quanHuyen;
    @Column(name = "phuongxa")
    private String phuongXa;
    @Column(name = "sonha")
    private int soNha;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hocVien", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<DangKyHoc> dangKyHocs;
    
    public int getHocVienID() {
        return hocVienID;
    }
    public void setHocVienID(int hocVienID) {
        this.hocVienID = hocVienID;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getSdt() {
        return sdt;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTinhThanh() {
        return tinhThanh;
    }
    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }
    public String getQuanHuyen() {
        return quanHuyen;
    }
    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }
    public String getPhuongXa() {
        return phuongXa;
    }
    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }
    public int getSoNha() {
        return soNha;
    }
    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }
    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }
    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
}
