package com.example.Test.Controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.Models.KhoaHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.KhoaHocServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@RestController
@RequestMapping(value = "khoahoc")
public class KhoaHocConTroller {
    @Autowired
    private KhoaHocServices khoaHocServices;
    @RequestMapping(value = "themkhoahoc", method = RequestMethod.POST)
    public ObjRp<KhoaHoc> themKhoaHoc(@RequestBody String khoaHoc, BindingResult bindingResult){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {

            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }  
        }).create();
        KhoaHoc kh = gson.fromJson(khoaHoc, KhoaHoc.class);
        return khoaHocServices.themKhoaHoc(kh, bindingResult);
    }
    @RequestMapping(value = "suakhoahoc", method = RequestMethod.PUT)
    public ObjRp<KhoaHoc> suaKhoaHoc(@RequestBody String khoaHoc, BindingResult bindingResult){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {

            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }  
        }).create();
        KhoaHoc kh = gson.fromJson(khoaHoc, KhoaHoc.class);
        return khoaHocServices.suaKhoaHoc(kh, bindingResult);
    }
    @RequestMapping(value = "xoakhoahoc", method = RequestMethod.DELETE)
    public ObjRp<KhoaHoc> xoaKhoaHoc(@RequestParam int id){
        return khoaHocServices.xoaKhoaHoc(id);
    }
    @RequestMapping(value = "layKhoaHoc", method = RequestMethod.GET)
    public List<KhoaHoc> layKhoaHoc(){
        return khoaHocServices.hienThi();
    }
    @RequestMapping(value = "timkhoahoc", method = RequestMethod.GET)
    public List<KhoaHoc> timKiem(@RequestParam String ten){
        return khoaHocServices.timKiem(ten);
    }
    @RequestMapping(value = "timkhoahocphantrang", method = RequestMethod.GET)
    public Page<KhoaHoc> timKiemPhanTrang(@RequestParam String ten){
        Pageable pageable = PageRequest.of(1    , 2);
        return khoaHocServices.timKiemPhanTrang(ten, pageable);
    }
    
}
