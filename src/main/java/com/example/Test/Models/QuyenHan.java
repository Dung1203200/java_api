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
@Table(name = "quyenhan")
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quyenhanid")
    private int quyenHanID;
    @Column(name = "tenquyenhan")
    private String tenQuyenHan;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quyenHan", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<TaiKhoan> taiKhoans;
    
    public int getQuyenHanID() {
        return quyenHanID;
    }
    public void setQuyenHanID(int quyenHanID) {
        this.quyenHanID = quyenHanID;
    }
    public String getTenQuyenHan() {
        return tenQuyenHan;
    }
    public void setTenQuyenHan(String tenQuyenHan) {
        this.tenQuyenHan = tenQuyenHan;
    }
    public Set<TaiKhoan> getTaiKhoans() {
        return taiKhoans;
    }
    public void setTaiKhoans(Set<TaiKhoan> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }
}
