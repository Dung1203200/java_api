package com.example.Test.Controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.Models.HocVien;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.HocVienServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@RestController
@RequestMapping(value = "hocvien")
public class HocVienController {
    @Autowired
    private HocVienServices hocVienServices;
    @RequestMapping(value = "themhocsinh", method =  RequestMethod.POST)
    public ObjRp<HocVien> themHocVien(@RequestBody String hocVien){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>(){

            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
               return LocalDate.parse(json.getAsString());
            }
        }).create();
        HocVien hv = gson.fromJson(hocVien, HocVien.class);
        return hocVienServices.themHocVien(hv);
    }
    @RequestMapping(value = "suahocvien", method = RequestMethod.PUT)
    public ObjRp<HocVien> suaHocVien(@RequestBody String hocVien){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>(){
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
               return LocalDate.parse(json.getAsString());
            }
        }).create();
        HocVien hv = gson.fromJson(hocVien, HocVien.class);
        return hocVienServices.suaHocVien(hv);
    }
    @RequestMapping(value = "xoahocvien", method = RequestMethod.DELETE)
    public ObjRp<HocVien> xoaHocVien(@RequestParam int id){
        return hocVienServices.xoaHocVien(id);
    }
    @RequestMapping(value="timkiem", method=RequestMethod.GET)
    public List<HocVien> timkiem(@RequestParam String ten, String email) {
        return hocVienServices.timTheoTenVaEmail(ten, email);
    }
    @RequestMapping(value="layds", method=RequestMethod.GET)
    public List<HocVien> layHocVien() {
        return hocVienServices.layHocVien();
    }
    
}
