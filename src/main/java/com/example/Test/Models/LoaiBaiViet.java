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
@Table(name = "loaibaiviet")
public class LoaiBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaibaivietid")
    private int loaiBaiVietID;
    @Column(name = "tenloaibaiviet")
    private String tenLoaiBaiViet;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiBaiViet", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ChuDe> chuDes;
    
    public int getLoaiBaiVietID() {
        return loaiBaiVietID;
    }
    public void setLoaiBaiVietID(int loaiBaiVietID) {
        this.loaiBaiVietID = loaiBaiVietID;
    }
    public String getTenLoaiBaiViet() {
        return tenLoaiBaiViet;
    }
    public void setTenLoaiBaiViet(String tenLoaiBaiViet) {
        this.tenLoaiBaiViet = tenLoaiBaiViet;
    }
    public Set<ChuDe> getChuDes() {
        return chuDes;
    }
    public void setChuDes(Set<ChuDe> chuDes) {
        this.chuDes = chuDes;
    }
    
}
