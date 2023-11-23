package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.TinhTrangHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.TinhTrangHocRepo;

@Service
public class TinhTrangHocServices {
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    public ObjRp<TinhTrangHoc> themTinhTrangHoc(TinhTrangHoc tinhTrangHoc){
        ObjRp<TinhTrangHoc> themTinhTrangHoc = new ObjRp<>();
        tinhTrangHocRepo.save(tinhTrangHoc);
        themTinhTrangHoc.setMess("them thanh cong");
        themTinhTrangHoc.setData(tinhTrangHoc);
        return themTinhTrangHoc;
    }
    public ObjRp<TinhTrangHoc> suaTinhTrangHoc(TinhTrangHoc tinhTrangHocSua){
        ObjRp<TinhTrangHoc> suaTinhTrangHoc = new ObjRp<>();
        Optional<TinhTrangHoc> tinhTrang = tinhTrangHocRepo.findById(tinhTrangHocSua.getTinhTrangHocID());
        if(tinhTrang.isEmpty()){
            suaTinhTrangHoc.setMess("tinh trang hoc nay khong ton tai");
            return suaTinhTrangHoc;
        }
        TinhTrangHoc tinhTrangHoc = tinhTrang.get();
        tinhTrangHoc.setTenTinhTrangHoc(tinhTrangHocSua.getTenTinhTrangHoc());
        tinhTrangHocRepo.save(tinhTrangHoc);
        suaTinhTrangHoc.setMess("sua tinh trang hoc thanh cong");
        suaTinhTrangHoc.setData(tinhTrangHoc);
        return suaTinhTrangHoc;
    }
    public ObjRp<TinhTrangHoc> xoaTinhTrangHoc(int id){
        ObjRp<TinhTrangHoc> xoaTinhTrangHoc= new ObjRp<>();
        Optional<TinhTrangHoc> tinhTrang = tinhTrangHocRepo.findById(id);
        if(tinhTrang.isEmpty()){
            xoaTinhTrangHoc.setMess("tinh trang hoc khong ton tai");
            return xoaTinhTrangHoc;
        }
        TinhTrangHoc tinhTrangHoc = tinhTrang.get();
        tinhTrangHocRepo.delete(tinhTrangHoc);
        xoaTinhTrangHoc.setData(tinhTrangHoc);
        xoaTinhTrangHoc.setMess("xoa thanh cong");
        return xoaTinhTrangHoc;
    }
    public List<TinhTrangHoc> layTinhTrangHoc(){
        return tinhTrangHocRepo.findAll();
    }
}
