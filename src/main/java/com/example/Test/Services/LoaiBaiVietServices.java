package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.LoaiBaiViet;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.LoaiBaiVietRepo;

@Service
public class LoaiBaiVietServices {
    @Autowired
    private LoaiBaiVietRepo loaiBaiVietRepo;
    public ObjRp<LoaiBaiViet> themLoaiBaiViet(LoaiBaiViet loaiBaiViet){
        ObjRp<LoaiBaiViet> themLoaiBaiViet = new ObjRp<>();
        loaiBaiVietRepo.save(loaiBaiViet);
        themLoaiBaiViet.setMess("them thanh cong");
        themLoaiBaiViet.setData(loaiBaiViet);
        return themLoaiBaiViet;
    }
    public ObjRp<LoaiBaiViet> suaLoaiBaiViet(LoaiBaiViet loaiBaiViet){
        ObjRp<LoaiBaiViet> suaLoaiBaiViet = new ObjRp<>();
        Optional<LoaiBaiViet> loai = loaiBaiVietRepo.findById(loaiBaiViet.getLoaiBaiVietID());
        if(loai.isEmpty()){
                suaLoaiBaiViet.setMess("loai bai viet khong ton tai");
                return suaLoaiBaiViet;
        }
        LoaiBaiViet lBaiViet = loai.get();
        lBaiViet.setTenLoaiBaiViet(loaiBaiViet.getTenLoaiBaiViet());
        loaiBaiVietRepo.save(lBaiViet);
        suaLoaiBaiViet.setMess("sua thanh cong");
        suaLoaiBaiViet.setData(lBaiViet);
        return suaLoaiBaiViet;
    }
    public ObjRp<LoaiBaiViet> xoaLoaiBaiViet(int id){
        ObjRp<LoaiBaiViet> xoaLoaiBaiViet = new ObjRp<>();
        Optional<LoaiBaiViet> loai = loaiBaiVietRepo.findById(id);
        if(loai.isEmpty()){
                xoaLoaiBaiViet.setMess("loai bai viet khong ton tai");
                return xoaLoaiBaiViet;
        }
        LoaiBaiViet lBaiViet = loai.get();
        loaiBaiVietRepo.delete(lBaiViet);
        xoaLoaiBaiViet.setMess("xoa thanh cong");
        xoaLoaiBaiViet.setData(lBaiViet);
        return xoaLoaiBaiViet;
    }
    public List<LoaiBaiViet> hienThi(){
        return loaiBaiVietRepo.findAll();
    }
}
