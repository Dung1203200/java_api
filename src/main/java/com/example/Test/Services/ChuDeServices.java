package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.Test.Models.ChuDe;
import com.example.Test.Models.LoaiBaiViet;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.ChuDeRepo;
import com.example.Test.Repository.LoaiBaiVietRepo;

@Service
public class ChuDeServices {
    @Autowired
    private ChuDeRepo chuDeRepo;
    @Autowired
    private LoaiBaiVietRepo loaiBaiVietRepo;
    public ObjRp<ChuDe> themChuDe(ChuDe chuDe, BindingResult bindingResult){
        ObjRp<ChuDe> themChuDe = new ObjRp<>();
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Lỗi: ");
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            });
            themChuDe.setMess(errorMessage.toString());
            return themChuDe;
        }
        Optional<LoaiBaiViet> loai = loaiBaiVietRepo.findById(chuDe.getLoaiBaiVietID());
        if(loai.isEmpty()){
            themChuDe.setMess("loai bai viet khong ton tai");
            return themChuDe;
        }
        chuDe.setLoaiBaiViet(loai.get());
        chuDeRepo.save(chuDe);
        themChuDe.setMess("them thanh cong");
        themChuDe.setData(chuDe);
        return themChuDe;
    }
    public ObjRp<ChuDe> suaChuDe(ChuDe chuDe, BindingResult bindingResult){
        ObjRp<ChuDe> suaChuDe = new ObjRp<>();
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Lỗi: ");
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            });
            suaChuDe.setMess(errorMessage.toString());
            return suaChuDe;
        }
        Optional<LoaiBaiViet> loai = loaiBaiVietRepo.findById(chuDe.getLoaiBaiVietID());
        if(loai.isEmpty()){
            suaChuDe.setMess("loai bai viet khong ton tai");
            return suaChuDe;
        }
        Optional<ChuDe> cd = chuDeRepo.findById(chuDe.getChuDeID());
        if(cd.isEmpty()){
            suaChuDe.setMess("chu de khong ton tai");
            return suaChuDe;
        }
        LoaiBaiViet loaiBaiViet = loai.get();
        ChuDe cdCu = cd.get();
        cdCu.setLoaiBaiViet(loaiBaiViet);
        cdCu.setNoiDung(chuDe.getNoiDung());
        cdCu.setTenChuDe(chuDe.getTenChuDe());
        chuDeRepo.save(cdCu);
        suaChuDe.setMess("sua chu de thanh cong");
        suaChuDe.setData(chuDe);
        return suaChuDe;
    }
    public ObjRp<ChuDe> xoaChuDe(int id){
        ObjRp<ChuDe> xoaChuDe = new ObjRp<>();
        Optional<ChuDe> cd = chuDeRepo.findById(id);
        if(cd.isEmpty()){
            xoaChuDe.setMess("chu de khong ton tai");
            return xoaChuDe;
        }
        ChuDe chuDe = cd.get();
        chuDeRepo.delete(chuDe);
        xoaChuDe.setMess("xoa thanh cong");
        xoaChuDe.setData(chuDe);
        return xoaChuDe;
    }
    public List<ChuDe> hienThi(){
        return chuDeRepo.findAll();
    }
}
