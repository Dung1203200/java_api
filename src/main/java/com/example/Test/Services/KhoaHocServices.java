package com.example.Test.Services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.Test.Models.KhoaHoc;
import com.example.Test.Models.LoaiKhoaHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.KhoaHocRepo;
import com.example.Test.Repository.LoaiKhoaHocRepo;
@Service
public class KhoaHocServices {
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private LoaiKhoaHocRepo loaiKhoaHocRepo;
    public ObjRp<KhoaHoc> themKhoaHoc(KhoaHoc khoaHoc, BindingResult bindingResult){
        ObjRp<KhoaHoc> themKhoaHoc = new ObjRp<>();
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder("Lỗi: ");
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            });
            themKhoaHoc.setMess(errorMessage.toString());
            return themKhoaHoc;
        }
        Optional<LoaiKhoaHoc> loai = loaiKhoaHocRepo.findById(khoaHoc.getLoaiKhoaHocID());
        if(loai.isEmpty()){
            themKhoaHoc.setMess("loai khoa hoc khong ton tai");
            return themKhoaHoc;
        }
        LoaiKhoaHoc loaiKhoaHoc = loai.get();
        khoaHoc.setLoaiKhoaHoc(loaiKhoaHoc);
        khoaHocRepo.save(khoaHoc);
        themKhoaHoc.setMess("them thanh cong");
        themKhoaHoc.setData(khoaHoc);
        return themKhoaHoc;
    }
    public ObjRp<KhoaHoc> suaKhoaHoc(KhoaHoc khoaHoc, BindingResult bindingResult){
        ObjRp<KhoaHoc> suaKhoaHoc = new ObjRp<>();
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder("Lỗi: ");
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            });
            suaKhoaHoc.setMess(errorMessage.toString());
            return suaKhoaHoc;
        }
        Optional<KhoaHoc> kh = khoaHocRepo.findById(khoaHoc.getKhoaHocID());
        if(kh.isPresent()){
            Optional<LoaiKhoaHoc> loai = loaiKhoaHocRepo.findById(khoaHoc.getLoaiKhoaHocID());
            if(loai.isPresent()){
                KhoaHoc kHoc = kh.get();
                LoaiKhoaHoc loaiKhoaHoc = loai.get();
                kHoc.setLoaiKhoaHoc(loaiKhoaHoc);
                kHoc.setGioiThieu(khoaHoc.getGioiThieu());
                kHoc.setHocPhi(khoaHoc.getHocPhi());
                kHoc.setNoiDung(khoaHoc.getNoiDung());
                kHoc.setSoHocVien(khoaHoc.getSoHocVien());
                kHoc.setSoLuongMon(khoaHoc.getSoLuongMon());
                kHoc.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
                kHoc.setThoiGianHoc(khoaHoc.getThoiGianHoc());
                khoaHocRepo.save(kHoc);
                suaKhoaHoc.setMess("sua thanh cong");
                suaKhoaHoc.setData(kHoc);
                return suaKhoaHoc;
            }
            else
            {
                suaKhoaHoc.setMess("loai khoa hoc khong ton tai");
                return suaKhoaHoc;
            }
        }
        suaKhoaHoc.setMess("khoa hoc khong ton tai");
        return suaKhoaHoc;
    }
    public ObjRp<KhoaHoc> xoaKhoaHoc(int khoaHocID){
        ObjRp<KhoaHoc> xoaKhoaHoc = new ObjRp<>();
        Optional<KhoaHoc> kh = khoaHocRepo.findById(khoaHocID);
        if(kh.isEmpty()){
            xoaKhoaHoc.setMess("khoa hoc khong ton tai");
            return xoaKhoaHoc;
        }
        KhoaHoc khoaHoc = kh.get();
        khoaHocRepo.delete(khoaHoc);
        xoaKhoaHoc.setData(khoaHoc);
        xoaKhoaHoc.setMess("xoa thanh cong");
        return xoaKhoaHoc;
    }
    public Page<KhoaHoc> timKiemPhanTrang(String searchKeyword, Pageable pageable) {
        return khoaHocRepo.findByTenKhoaHocContaining(searchKeyword, pageable);
    }
    public List<KhoaHoc> timKiem(String searchKeyword) {
        return khoaHocRepo.findByTenKhoaHocContaining(searchKeyword);
    }
    public List<KhoaHoc> hienThi(){
        return khoaHocRepo.findAll();
    }
}
