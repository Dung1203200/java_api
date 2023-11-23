package com.example.Test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Test.Models.QuyenHan;
import com.example.Test.Models.TaiKhoan;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Repository.QuyenHanRepo;
import com.example.Test.Repository.TaiKhoanRepo;
import org.passay.*;
@Service
public class TaiKhoanServices {
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;
    @Autowired
    private QuyenHanRepo quyenHanRepo;
    public ObjRp<TaiKhoan> themTaiKhoan(TaiKhoan taiKhoan){
        ObjRp<TaiKhoan> themTaiKhoan = new ObjRp<>();
        int quyenHanID = taiKhoan.getQuyenHanID();
        String check = checkTaiKhoan(taiKhoan.getTaiKhoan());
        if(!check.equals("ok")){
            themTaiKhoan.setMess("tai khoan da ton tai");
            return themTaiKhoan;
        }
        Optional<QuyenHan> quyen = quyenHanRepo.findById(quyenHanID);
        if(quyen.isEmpty()){
            themTaiKhoan.setMess("quyen han khong ton tai");
            return themTaiKhoan;
        }
        if (!isStrongPassword(taiKhoan.getMatKhau())) {
            themTaiKhoan.setMess("qmat khau phai co so va ky tu dac biet");
            return themTaiKhoan;
        }
        QuyenHan quyenHan = quyen.get();
        taiKhoan.setQuyenHan(quyenHan);
        taiKhoanRepo.save(taiKhoan);
        themTaiKhoan.setMess("them thanh cong");
        themTaiKhoan.setData(taiKhoan);
        return themTaiKhoan;
    }
    public ObjRp<TaiKhoan> suaTaiKhoan(TaiKhoan taiKhoan){
        ObjRp<TaiKhoan> suaTaiKhoan = new ObjRp<>();
        int quyenHanID = taiKhoan.getQuyenHanID();
        Optional<TaiKhoan> tk = taiKhoanRepo.findById(taiKhoan.getTaiKhoanID());
        if(tk.isEmpty()){
            suaTaiKhoan.setMess("tai khoan khong ton tai");
            return suaTaiKhoan;
        }
        Optional<QuyenHan> quyen = quyenHanRepo.findById(quyenHanID);
        if(quyen.isEmpty()){
            suaTaiKhoan.setMess("quyen han khong ton tai");
            return suaTaiKhoan;
        }
         if (!isStrongPassword(taiKhoan.getMatKhau())) {
            suaTaiKhoan.setMess("qmat khau phai co so va ky tu dac biet");
            return suaTaiKhoan;
        }
        TaiKhoan tkCu = tk.get();
        if(!taiKhoan.getTaiKhoan().equals(tkCu.getTaiKhoan())){
            String check = checkTaiKhoan(taiKhoan.getTaiKhoan());
            if(!check.equals("ok")){
                suaTaiKhoan.setMess("tai khoan da ton tai");
                return suaTaiKhoan;
            }
            tkCu.setTaiKhoan(taiKhoan.getTaiKhoan());
        }

        QuyenHan quyenHan = quyen.get();
        tkCu.setQuyenHan(quyenHan);
        tkCu.setMatKhau(taiKhoan.getMatKhau());
        tkCu.setTenNguoiDung(taiKhoan.getTenNguoiDung());
        taiKhoan.setQuyenHan(quyenHan);
        taiKhoanRepo.save(tkCu);
        suaTaiKhoan.setMess("sua thanh cong");
        suaTaiKhoan.setData(tkCu);
        return suaTaiKhoan;
    }
    public ObjRp<TaiKhoan> xoaTaiKhoan(int id){
        ObjRp<TaiKhoan> xoaTaiKhoan = new ObjRp<>();
        Optional<TaiKhoan> tk = taiKhoanRepo.findById(id);
        if(tk.isEmpty()){
            xoaTaiKhoan.setMess("tai khoan khong ton tai");
            return xoaTaiKhoan;
        }
        taiKhoanRepo.delete(tk.get());
        return xoaTaiKhoan;
    }


    public static boolean isStrongPassword(String password) {
        PasswordValidator validator = new PasswordValidator(
            // new LengthRule(8, 30),            // Độ dài từ 8 đến 30 ký tự
            // new CharacterRule(EnglishCharacterData.UpperCase, 1), // Ít nhất 1 chữ cái hoa
            // new CharacterRule(EnglishCharacterData.LowerCase, 1), // Ít nhất 1 chữ cái thường
            new CharacterRule(EnglishCharacterData.Digit, 1),     // Ít nhất 1 số
            new CharacterRule(EnglishCharacterData.Special, 1)    // Ít nhất 1 ký tự đặc biệt
        );

        RuleResult result = validator.validate(new PasswordData(password));
        return result.isValid();
    }
    public String checkTaiKhoan(String ten){
        List<TaiKhoan> taiKhoans = taiKhoanRepo.findAll();
        for (TaiKhoan tKhoan : taiKhoans) {
            if(tKhoan.getTaiKhoan().equals(ten)){
                return "ten tai khoan da ton tai";
            }

        }
        return "ok";
    }
    public List<TaiKhoan> timKiem(String tenTK){
        return taiKhoanRepo.findByTaiKhoanContaining(tenTK);
    }

}
