package com.example.Test.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.Test.Models.BaiViet;
import com.example.Test.Models.ChuDe;
import com.example.Test.Models.TaiKhoan;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.BaiVietRepo;
import com.example.Test.Repository.ChuDeRepo;
import com.example.Test.Repository.TaiKhoanRepo;
@Service
public class BaiVietServices {
    @Autowired
    private BaiVietRepo baiVietRepo;
    @Autowired
    private ChuDeRepo chuDeRepo;
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;
    public ObjRp<BaiViet> themBaiViet(BaiViet baiViet, BindingResult bindingResult){
        ObjRp<BaiViet> themBaiViet = new ObjRp<>();
        baiViet.setThoiGianTao(LocalDate.now());
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder("Loi :");
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            });
            themBaiViet.setMess(errorMessage.toString());
            return themBaiViet;
        }
        Optional<ChuDe> cd = chuDeRepo.findById(baiViet.getChuDeID());
        if(cd.isEmpty()){
            themBaiViet.setMess("chu de khong ton tai");
            return themBaiViet;
        }
        Optional<TaiKhoan> tk = taiKhoanRepo.findById(baiViet.getTaiKhoanID());
        if(tk.isEmpty()){
            themBaiViet.setMess("tai khoan khong ton tai");
            return themBaiViet;
        }
        ChuDe chuDe = cd.get();
        TaiKhoan taiKhoan = tk.get();
        baiViet.setChuDe(chuDe);
        baiViet.setTaiKhoan(taiKhoan);
        baiVietRepo.save(baiViet);
        themBaiViet.setMess("them thanh cong");
        themBaiViet.setData(baiViet);
        return themBaiViet;
    }
    public ObjRp<BaiViet> suaBaiViet(BaiViet baiViet, BindingResult bindingResult){
        ObjRp<BaiViet> suaBaiViet = new ObjRp<>();
        baiViet.setThoiGianTao(LocalDate.now());
        if(bindingResult.hasErrors()){
            StringBuilder errorMessage = new StringBuilder("Loi :");
            bindingResult.getFieldErrors().forEach(error -> {
                errorMessage.append(error.getField()).append(" ").append(error.getDefaultMessage()).append("; ");
            });
            suaBaiViet.setMess(errorMessage.toString());
            return suaBaiViet;
        }
        Optional<BaiViet> bv = baiVietRepo.findById(baiViet.getBaiVietID());
        if(bv.isEmpty()){
            suaBaiViet.setMess("bai viet khong ton tai");
            return suaBaiViet;
        }
        Optional<ChuDe> cd = chuDeRepo.findById(baiViet.getChuDeID());
        if(cd.isEmpty()){
            suaBaiViet.setMess("chu de khong ton tai");
            return suaBaiViet;
        }
        Optional<TaiKhoan> tk = taiKhoanRepo.findById(baiViet.getTaiKhoanID());
        if(tk.isEmpty()){
            suaBaiViet.setMess("tai khoan khong ton tai");
           return suaBaiViet;
        }
        BaiViet bVietCu = bv.get();
        ChuDe chuDe = cd.get();
        TaiKhoan taiKhoan = tk.get();
        bVietCu.setChuDe(chuDe);
        bVietCu.setTaiKhoan(taiKhoan);
        bVietCu.setHinhAnh(baiViet.getHinhAnh());
        bVietCu.setNoiDung(baiViet.getNoiDung());
        bVietCu.setNoiDungNgan(baiViet.getNoiDungNgan());
        bVietCu.setTenBaiViet(baiViet.getTenBaiViet());
        bVietCu.setTenTacGia(baiViet.getTenTacGia());
        baiVietRepo.save(bVietCu);
        suaBaiViet.setMess("sua thanh cong");
        suaBaiViet.setData(bVietCu);
        return suaBaiViet;
    }

    public ObjRp<BaiViet> xoaBaiViet(int id){
        ObjRp<BaiViet> xoaBaiViet = new ObjRp<>();
        Optional<BaiViet> bai = baiVietRepo.findById(id);
        if(bai.isEmpty()){
            xoaBaiViet.setMess("bai viet khong ton tai");
            return xoaBaiViet;
        }
        BaiViet baiViet = bai.get();
        baiVietRepo.delete(baiViet);
        xoaBaiViet.setMess("xoa thanh cong");
        xoaBaiViet.setData(baiViet);
        return xoaBaiViet;
    }
    public List<BaiViet> timKiem(String ten){
        return baiVietRepo.findByTenBaiVietContaining(ten);
    }
    public List<BaiViet> layDS(){
        return baiVietRepo.findAll();
    }
}
