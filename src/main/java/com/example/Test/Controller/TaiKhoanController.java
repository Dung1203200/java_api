package com.example.Test.Controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.Models.TaiKhoan;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.TaiKhoanServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "taikhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanServices taiKhoanServices;
    @RequestMapping(value = "themtaikhoan", method = RequestMethod.POST)
    public ObjRp<TaiKhoan> themTaiKhoan(@RequestBody String taiKhoan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {

            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }    
        }).create();
        TaiKhoan tk = gson.fromJson(taiKhoan, TaiKhoan.class);
        return taiKhoanServices.themTaiKhoan(tk);
    }
    @RequestMapping(value = "suataikhoan", method = RequestMethod.PUT)
    public ObjRp<TaiKhoan> suaTaiKhoan(@RequestBody String taiKhoan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {

            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }    
        }).create();
        TaiKhoan tk = gson.fromJson(taiKhoan, TaiKhoan.class);
        return taiKhoanServices.suaTaiKhoan(tk);
    }
    @RequestMapping(value="xoaTaiKhoan", method = RequestMethod.DELETE)
    public ObjRp<TaiKhoan> xoaTaiKhoan(@RequestParam int id) {
        return taiKhoanServices.xoaTaiKhoan(id);
    }
    @RequestMapping(value = "timtaikhoan", method = RequestMethod.GET)
    public List<TaiKhoan> timKiem(@RequestParam String tenTK){
        return taiKhoanServices.timKiem(tenTK);
    }
    
}
