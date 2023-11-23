package com.example.Test.Controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.Models.ChuDe;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.ChuDeServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
@RestController
@RequestMapping(value = "chude")
public class ChuDeController {
    @Autowired 
    private ChuDeServices chuDeServices;
    @RequestMapping(value = "themchude", method = RequestMethod.POST)
    public ObjRp<ChuDe> themChuDe(@RequestBody String chuDe, BindingResult bindingResult){
         Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        ChuDe cDe = gson.fromJson(chuDe , ChuDe.class);
        return chuDeServices.themChuDe(cDe, bindingResult);
    }
    @RequestMapping(value = "suachude", method = RequestMethod.PUT)
    public ObjRp<ChuDe> suaChuDe(@RequestBody String chuDe, BindingResult bindingResult){
         Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        ChuDe cDe = gson.fromJson(chuDe , ChuDe.class);
        return chuDeServices.suaChuDe(cDe, bindingResult);
    }
    @RequestMapping(value = "xoachude", method = RequestMethod.DELETE)
    public ObjRp<ChuDe> xoaChuDe(@RequestParam int id){
        return chuDeServices.xoaChuDe(id);
    }
    @RequestMapping(value = "hienthichude", method = RequestMethod.GET)
    public List<ChuDe> hienThiChuDe(){
        return chuDeServices.hienThi();
    }
}
