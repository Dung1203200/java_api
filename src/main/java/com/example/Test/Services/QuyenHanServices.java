package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.QuyenHan;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.QuyenHanRepo;
@Service
public class QuyenHanServices {
    @Autowired
    private QuyenHanRepo quyenHanRepo;
    public ObjRp<QuyenHan> themQuyenHan(QuyenHan quyenHan){
        ObjRp<QuyenHan> themQuyenHan = new ObjRp<>();
        quyenHanRepo.save(quyenHan);
        themQuyenHan.setMess("them thanh cong");
        themQuyenHan.setData(quyenHan);
        return themQuyenHan;
    }
    public ObjRp<QuyenHan> suaQuyenHan(QuyenHan quyenHan){
        ObjRp<QuyenHan> suaQuyenHan = new ObjRp<>();
        Optional<QuyenHan> quyen =  quyenHanRepo.findById(quyenHan.getQuyenHanID());
        if(quyen.isEmpty()){
            suaQuyenHan.setMess("quyen han can sua khong ton tai");
            return suaQuyenHan;
        }
        QuyenHan qh = quyen.get();
        qh.setTenQuyenHan(quyenHan.getTenQuyenHan());
        quyenHanRepo.save(qh);
        suaQuyenHan.setMess("sua thanh cong");
        suaQuyenHan.setData(qh);
        return suaQuyenHan;
    }
    public ObjRp<QuyenHan> xoaQuyenHan(int id){
        ObjRp<QuyenHan> xoaQuyenHan = new ObjRp<>();
        Optional<QuyenHan> quyen =  quyenHanRepo.findById(id);
        if(quyen.isEmpty()){
            xoaQuyenHan.setMess("quyen han can xoa khong ton tai");
            return xoaQuyenHan;
        }
        QuyenHan qh = quyen.get();
        quyenHanRepo.delete(qh);
        xoaQuyenHan.setMess("xoa thanh cong");
        xoaQuyenHan.setData(qh);
        return xoaQuyenHan;
    }
    public List<QuyenHan> layQuyenHan(){
        return quyenHanRepo.findAll();
    }
}
