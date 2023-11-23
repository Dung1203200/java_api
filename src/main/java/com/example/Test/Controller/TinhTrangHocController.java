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

import com.example.Test.Models.TinhTrangHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.TinhTrangHocServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@RestController
@RequestMapping(value = "tinhtrang")
public class TinhTrangHocController {
    @Autowired
    private TinhTrangHocServices tinhTrangHocServices;
    @RequestMapping(value = "themtinhtrang", method = RequestMethod.POST)
    public ObjRp<TinhTrangHoc> themTinhTrang(@RequestBody String tinhTrang){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        TinhTrangHoc tinhTrangHoc = gson.fromJson(tinhTrang, TinhTrangHoc.class);
        return tinhTrangHocServices.themTinhTrangHoc(tinhTrangHoc);
    }
    @RequestMapping(value = "suatinhtrang", method = RequestMethod.PUT)
    public ObjRp<TinhTrangHoc> suaTinhTrang(@RequestBody String tinhTrang){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        TinhTrangHoc tinhTrangHoc = gson.fromJson(tinhTrang, TinhTrangHoc.class);
        return tinhTrangHocServices.suaTinhTrangHoc(tinhTrangHoc);
    }
    @RequestMapping(value = "xoatinhtranghoc", method =  RequestMethod.DELETE)
    public ObjRp<TinhTrangHoc> xoaTinhTrang(@RequestParam int id){
        return tinhTrangHocServices.xoaTinhTrangHoc(id);
    }
    @RequestMapping(value = "laytinhtranghoc", method =  RequestMethod.GET)
    public List<TinhTrangHoc> layTinhTrangHoc(){
        return tinhTrangHocServices.layTinhTrangHoc();
    }

}
