package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.HocVien;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.HocVienRePo;
@Service
public class HocVienServices {
    @Autowired
    private HocVienRePo hocVienRePo;
    public ObjRp<HocVien> themHocVien(HocVien hv){
        ObjRp<HocVien> themHocVien = new ObjRp<>();
        int check = check(hv)  ;
        if(check == 1){
            themHocVien.setMess("email da ton tai");
            return themHocVien;
        }
        else if(check == 2){
            themHocVien.setMess("sdt da ton tai");
            return themHocVien;
        }
        hv.setHoTen(WordUtils.capitalizeFully(hv.getHoTen()));
        hocVienRePo.save(hv);
        themHocVien.setMess("them thanh cong");
        themHocVien.setData(hv);
        return themHocVien;
    }
    public ObjRp<HocVien> suaHocVien(HocVien hv){
        ObjRp<HocVien> suaHocVien = new ObjRp<>();
        Optional<HocVien> hOptional = hocVienRePo.findById(hv.getHocVienID());
        if(hOptional.isEmpty()){
            suaHocVien.setMess("hoc vien khong ton tai");
            return suaHocVien;
        }
        HocVien hvCu = hOptional.get();
        int check = check(hv)  ;
        if(!hv.getEmail().equals(hvCu.getEmail())){
            if(check == 1){
            suaHocVien.setMess("email da ton tai");
            return suaHocVien;
            }
            hvCu.setEmail(hv.getEmail());
        }
        if(!hv.getSdt().equals(hvCu.getSdt())){
            if(check == 2){
            suaHocVien.setMess("so dien thoai da ton tai");
            return suaHocVien;
            }
            hvCu.setSdt(hv.getSdt());
        }
        hvCu.setHinhAnh(hv.getHinhAnh());
        hvCu.setNgaySinh(hv.getNgaySinh());
        hvCu.setPhuongXa(hv.getPhuongXa());
        hvCu.setQuanHuyen(hv.getQuanHuyen());
        hvCu.setSoNha(hv.getSoNha());
        hvCu.setTinhThanh(hv.getTinhThanh());
        hvCu.setHoTen(WordUtils.capitalizeFully(hv.getHoTen()));
        hocVienRePo.save(hvCu);
        suaHocVien.setMess("sua thanh cong");
        suaHocVien.setData(hvCu);
        return suaHocVien;
    }
    public ObjRp<HocVien> xoaHocVien(int id){
        ObjRp<HocVien> xoaHocVien = new ObjRp<>();
        Optional<HocVien> hv = hocVienRePo.findById(id);
        if(hv.isEmpty()){
            xoaHocVien.setMess("hoc vien khong ton tai");
            return xoaHocVien;
        }
        HocVien hocVien = hv.get();
        hocVienRePo.delete(hocVien);
        return xoaHocVien;
    }
    
    public List<HocVien> timTheoTenVaEmail(String ten, String email){
        return hocVienRePo.findByHoTenContainingOrEmailContaining(ten, email);
    }
    public int check(HocVien hv){
        List<HocVien> list = hocVienRePo.findAll();
        String sdt = hv.getSdt();
        String email = hv.getEmail();
        for (HocVien hocVien : list) {
            if(hocVien.getEmail().equals(email)){
                return 1;
            }
            if(hocVien.getSdt().equals(sdt)){
                return 2;
            }
        }
        return 0;
    }
    public List<HocVien> layHocVien(){
        return hocVienRePo.findAll();
    }

}
