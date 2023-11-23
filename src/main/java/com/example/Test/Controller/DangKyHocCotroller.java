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

import com.example.Test.Models.DangKyHoc;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.DangKyHocServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
@RestController
@RequestMapping(value = "dangkyhoc")
public class DangKyHocCotroller {
    @Autowired
    private DangKyHocServices dangKyHocServices;
    @RequestMapping(value = "themdangky", method = RequestMethod.POST)
    public ObjRp<DangKyHoc> themDangKy(@RequestBody String dangKyHoc){
                 Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        DangKyHoc dKyHoc = gson.fromJson(dangKyHoc, DangKyHoc.class);
        return dangKyHocServices.themDangKyHoc(dKyHoc);
    }
    @RequestMapping(value = "suadangky",method = RequestMethod.PUT)
    public ObjRp<DangKyHoc> suaDangKy(@RequestBody String dangKyHoc){
                 Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        DangKyHoc dKyHoc = gson.fromJson(dangKyHoc, DangKyHoc.class);
        return dangKyHocServices.suaDangKyHoc(dKyHoc);
    }
    @RequestMapping(value = "xoadangky", method = RequestMethod.DELETE)
    public ObjRp<DangKyHoc> xoaDangKyHoc(@RequestParam int id){
        return dangKyHocServices.xoaDangKyHoc(id);
    }
    @RequestMapping(value = "layds", method = RequestMethod.GET)
    public List<DangKyHoc> layDangKyHoc(){
        return dangKyHocServices.dsDangKyHocs();
    }
}
