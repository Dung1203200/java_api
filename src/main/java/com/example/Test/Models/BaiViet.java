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
@Table(name = "baiviet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    private int baiVietID;
    @Column(name = "tenbaiviet")
    private String tenBaiViet;
    @Column(name = "thoigiantao")
    private LocalDate thoiGianTao;
    @Column(name = "tentacgia")
    private String tenTacGia;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "noidungngan")
    private String noiDungNgan;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "chudeid", insertable = false, updatable = false)
    private int chuDeID;
    @Column(name = "taikhoanid", insertable = false, updatable = false)
    private int taiKhoanID;
    @ManyToOne()
    @JoinColumn(name = "chudeid")
    @JsonBackReference
    private ChuDe chuDe;
    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "taikhoanid")
    private TaiKhoan taiKhoan;
    
    public int getBaiVietID() {
        return baiVietID;
    }
    public void setBaiVietID(int baiVietID) {
        this.baiVietID = baiVietID;
    }
    public String getTenBaiViet() {
        return tenBaiViet;
    }
    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }
    public LocalDate getThoiGianTao() {
        return thoiGianTao;
    }
    public void setThoiGianTao(LocalDate thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }
    public String getTenTacGia() {
        return tenTacGia;
    }
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public String getNoiDungNgan() {
        return noiDungNgan;
    }
    public void setNoiDungNgan(String noiDungNgan) {
        this.noiDungNgan = noiDungNgan;
    }
    public int getChuDeID() {
        return chuDeID;
    }
    public void setChuDeID(int chuDeID) {
        this.chuDeID = chuDeID;
    }
    public int getTaiKhoanID() {
        return taiKhoanID;
    }
    public void setTaiKhoanID(int taiKhoanID) {
        this.taiKhoanID = taiKhoanID;
    }
    public ChuDe getChuDe() {
        return chuDe;
    }
    public void setChuDe(ChuDe chuDe) {
        this.chuDe = chuDe;
    }
    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }
    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    
}
