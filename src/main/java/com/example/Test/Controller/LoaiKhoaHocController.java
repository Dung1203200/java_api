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

import com.example.Test.Models.LoaiKhoaHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.LoaiKhoaHocServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@RestController
@RequestMapping(value = "loaikhoahoc")
public class LoaiKhoaHocController {
    @Autowired
    private LoaiKhoaHocServices loaiKhoaHocServices;
    @RequestMapping(value = "themloaikhoahoc", method = RequestMethod.POST)
    public ObjRp<LoaiKhoaHoc> themLoaiKhoaHoc(@RequestBody String loaiKhoaHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {

            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }
        }).create();
        LoaiKhoaHoc loai = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
        return loaiKhoaHocServices.themLoaiKhoaHoc(loai);
    }
    @RequestMapping(value = "sualoaikhoahoc", method = RequestMethod.PUT)
    public ObjRp<LoaiKhoaHoc> suaLoaiKhoaHoc(@RequestBody String loaiKhoaHoc){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }
        }).create();
        LoaiKhoaHoc loai = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
        return loaiKhoaHocServices.suaLoaiKhoaHoc(loai);
    }
    @RequestMapping(value = "xoaloaikhoahoc", method = RequestMethod.DELETE)
    public ObjRp<LoaiKhoaHoc> xoaLoaiKhoaHoc(@RequestParam int id){
        return loaiKhoaHocServices.xoaLoaiKhoaHoc(id);
    }
    @RequestMapping(value = "layloaikhoahoc", method = RequestMethod.GET)
    public List<LoaiKhoaHoc> hienThi(){
        return loaiKhoaHocServices.hienThi();
    }
}
