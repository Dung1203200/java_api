package com.example.Test.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "chude")
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeID;
    @Column(name = "tenchude")
    @NotNull(message = "ten chu de khong duoc de trong")
    private String tenChuDe;
    @Column(name = "noidung")
    @NotNull(message = "noi dung khong duoc de trong")
    private String noiDung;
    @Column(name = "loaibaivietid", insertable = false, updatable = false)
    private int loaiBaiVietID;
    @ManyToOne()
    @JoinColumn(name = "loaibaivietid")
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;
    
    public int getChuDeID() {
        return chuDeID;
    }
    public void setChuDeID(int chuDeID) {
        this.chuDeID = chuDeID;
    }
    public String getTenChuDe() {
        return tenChuDe;
    }
    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }
    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }
    public LoaiBaiViet getLoaiBaiViet() {
        return loaiBaiViet;
    }
    public void setLoaiBaiViet(LoaiBaiViet loaiBaiViet) {
        this.loaiBaiViet = loaiBaiViet;
    }
    
}
