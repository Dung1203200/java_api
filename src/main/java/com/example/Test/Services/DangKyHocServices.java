package com.example.Test.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.DangKyHoc;
import com.example.Test.Models.HocVien;
import com.example.Test.Models.KhoaHoc;
import com.example.Test.Models.TaiKhoan;
import com.example.Test.Models.TinhTrangHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.DangKyHocRepo;
import com.example.Test.Repository.HocVienRePo;
import com.example.Test.Repository.KhoaHocRepo;
import com.example.Test.Repository.TaiKhoanRepo;
import com.example.Test.Repository.TinhTrangHocRepo;
@Service
public class DangKyHocServices {
    @Autowired
    private DangKyHocRepo dangKyHocRepo;
    @Autowired
    private HocVienRePo hocVienRePo;
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    public ObjRp<DangKyHoc> themDangKyHoc(DangKyHoc dangKyHoc){
        ObjRp<DangKyHoc> themDangKyHoc = new ObjRp<>();
        int check = check(dangKyHoc);
        if(check != 0){
            themDangKyHoc.setMess(errMes(check));
            return themDangKyHoc;
        }
        if(dangKyHoc.getTinhTrangHocID() !=1){
            themDangKyHoc.setMess("dang ky moi phai o trang thai cho duyet");
            return themDangKyHoc;
        }
        HocVien hv = hocVienRePo.findById(dangKyHoc.getHocVienID()).get();
        KhoaHoc kh = khoaHocRepo.findById(dangKyHoc.getKhoaHocID()).get();
        TaiKhoan tk = taiKhoanRepo.findById(dangKyHoc.getTaiKhoanID()).get();
        TinhTrangHoc tt = tinhTrangHocRepo.findById(dangKyHoc.getTinhTrangHocID()).get();
        kh.setSoHocVien(kh.getSoHocVien()+1); 
        khoaHocRepo.save(kh);
        dangKyHoc.setHocVien(hv);
        dangKyHoc.setKhoaHoc(kh);
        dangKyHoc.setTaiKhoan(tk);
        dangKyHoc.setTinhTrangHoc(tt);
        dangKyHoc.setNgayDangKy(LocalDate.now());
        dangKyHocRepo.save(dangKyHoc);
        themDangKyHoc.setMess("them thanh cong");
        themDangKyHoc.setData(dangKyHoc);
        return themDangKyHoc;
    }
    public ObjRp<DangKyHoc> suaDangKyHoc(DangKyHoc dangKyHoc){
        ObjRp<DangKyHoc> suaDangKyHoc = new ObjRp<>();
        int check = check(dangKyHoc);
        if(check != 0){
            suaDangKyHoc.setMess(errMes(check));
            return suaDangKyHoc;
        }
        Optional<DangKyHoc> dk = dangKyHocRepo.findById(dangKyHoc.getDangKyHocID());
        if(dk.isEmpty()){
            suaDangKyHoc.setMess("dang ky hoc khong ton tai");
            return suaDangKyHoc;
        }
        DangKyHoc dangKyHocCu = dk.get();
        HocVien hv = hocVienRePo.findById(dangKyHoc.getHocVienID()).get();
        KhoaHoc kh = khoaHocRepo.findById(dangKyHoc.getKhoaHocID()).get();
        TaiKhoan tk = taiKhoanRepo.findById(dangKyHoc.getTaiKhoanID()).get();
        TinhTrangHoc tt = tinhTrangHocRepo.findById(dangKyHoc.getTinhTrangHocID()).get();
        if(dangKyHocCu.getTinhTrangHocID() == 4){
            suaDangKyHoc.setMess("dang ky hoc dang o trang thai hoc chua hoan thanh, khong the cap nhat trang thai khac");
            return suaDangKyHoc;
        }
        if(tt.getTinhTrangHocID()==2){
            dangKyHocCu.setNgayBatDau(LocalDate.now());
            dangKyHocCu.setNgayKetThuc(LocalDate.now().plusMonths(kh.getThoiGianHoc()));
        }
        if(dangKyHocCu.getKhoaHocID() != dangKyHoc.getKhoaHocID()){
            KhoaHoc khCu = dangKyHocCu.getKhoaHoc();
            khCu.setSoHocVien(khCu.getSoHocVien() - 1);
            kh.setSoHocVien(kh.getSoHocVien() + 1);    
            dangKyHocCu.setKhoaHoc(kh);       
        }
        dangKyHocCu.setTinhTrangHoc(tt);
        dangKyHocCu.setHocVien(hv);
        dangKyHocCu.setTaiKhoan(tk);
        dangKyHocRepo.save(dangKyHocCu);
        suaDangKyHoc.setMess("sua thanh cong");
        suaDangKyHoc.setData(dangKyHocCu);
        return suaDangKyHoc;
    }
    public ObjRp<DangKyHoc> xoaDangKyHoc(int id){
        ObjRp<DangKyHoc> xoaDangKyHoc = new ObjRp<>();
        Optional<DangKyHoc> dk = dangKyHocRepo.findById(id);
        if(dk.isEmpty()){
            xoaDangKyHoc.setMess("dang ky hoc khong ton tai");
            return xoaDangKyHoc;
        }
        DangKyHoc dangKyHoc = dk.get();
        KhoaHoc kh = dangKyHoc.getKhoaHoc();
        kh.setSoHocVien(kh.getSoHocVien() -1 );
        khoaHocRepo.save(kh);
        dangKyHocRepo.delete(dangKyHoc);
        xoaDangKyHoc.setData(dangKyHoc);
        xoaDangKyHoc.setMess("xoa thanh cong");
        return xoaDangKyHoc;
    }
    public List<DangKyHoc> dsDangKyHocs(){
        return dangKyHocRepo.findAll();
    }
    private int check(DangKyHoc dangKyHoc){
        int hocVienID = dangKyHoc.getHocVienID();
        int khoaHocID = dangKyHoc.getKhoaHocID();
        int taiKhoanID = dangKyHoc.getTaiKhoanID();
        int tinhTrangHocID = dangKyHoc.getTinhTrangHocID();
        if(hocVienRePo.findById(hocVienID).isEmpty()){
            return 1;
        }
        if(khoaHocRepo.findById(khoaHocID).isEmpty()){
            return 2;
        }
        if(taiKhoanRepo.findById(taiKhoanID).isEmpty()){
            return 3;
        }
        if(tinhTrangHocRepo.findById(tinhTrangHocID).isEmpty()){
            return 4;
        }
        return 0;
    }
    private String errMes(int num){
        if(num == 1){
            return "hoc vien khong ton tai";
        }
        else if(num == 2){
            return "khoa hoc khong ton tai";
        }
        else if(num == 4){
            return "tinh trang hoc khong ton tai";
        }
        return "tai khoan khong ton tai";
    }

}
