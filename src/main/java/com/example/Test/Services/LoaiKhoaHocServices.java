package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.LoaiKhoaHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.LoaiKhoaHocRepo;
@Service
public class LoaiKhoaHocServices {
    @Autowired
    private LoaiKhoaHocRepo loaiKhoaHocRepo;
    public ObjRp<LoaiKhoaHoc> themLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc){
        ObjRp<LoaiKhoaHoc> themKhoaHoc = new ObjRp<>();
        loaiKhoaHocRepo.save(loaiKhoaHoc);
        themKhoaHoc.setMess("them thanh cong");
        themKhoaHoc.setData(loaiKhoaHoc);
        themKhoaHoc.setStt(0);
        return themKhoaHoc;
    }
    public ObjRp<LoaiKhoaHoc> xoaLoaiKhoaHoc(int loaiKhoaHocID){
        ObjRp<LoaiKhoaHoc> xoaLoaiKhoaHoc = new ObjRp<>();
        Optional<LoaiKhoaHoc> loai = loaiKhoaHocRepo.findById(loaiKhoaHocID);
        if(loai.isEmpty()){
            xoaLoaiKhoaHoc.setMess("loai khoa hoc khong ton tai");
            return xoaLoaiKhoaHoc;
        }
        LoaiKhoaHoc loaiKhoaHoc = loai.get();
        loaiKhoaHocRepo.delete(loaiKhoaHoc);
        xoaLoaiKhoaHoc.setMess("xoa thanh cong");
        xoaLoaiKhoaHoc.setData(loaiKhoaHoc);
        xoaLoaiKhoaHoc.setStt(0);
        return xoaLoaiKhoaHoc;
    }
    public ObjRp<LoaiKhoaHoc> suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc){
        ObjRp<LoaiKhoaHoc> suaLoaiKhoaHoc = new ObjRp<>();
        Optional<LoaiKhoaHoc> loai = loaiKhoaHocRepo.findById(loaiKhoaHoc.getLoaiKhoaHocID());
        if(loai.isEmpty()){
            suaLoaiKhoaHoc.setMess("loai khoa hoc khong ton tai");
            return suaLoaiKhoaHoc;
        }
        LoaiKhoaHoc lKhoaHoc = loai.get();
        lKhoaHoc.setTenLoaiKhoaHoc(loaiKhoaHoc.getTenLoaiKhoaHoc());
        loaiKhoaHocRepo.save(lKhoaHoc);
        suaLoaiKhoaHoc.setMess("sua thanh cong");
        suaLoaiKhoaHoc.setData(loaiKhoaHoc);
        suaLoaiKhoaHoc.setStt(0);
        return suaLoaiKhoaHoc;
    }
    public List<LoaiKhoaHoc> hienThi(){
        return loaiKhoaHocRepo.findAll();
    }
}
