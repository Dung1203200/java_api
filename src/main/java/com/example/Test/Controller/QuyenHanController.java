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

import com.example.Test.Models.QuyenHan;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.QuyenHanServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@RestController
@RequestMapping(value = "quyenhan")
public class QuyenHanController {
    @Autowired
    private QuyenHanServices quyenHanServices;
    @RequestMapping(value = "themquyenhan", method = RequestMethod.POST)
    public ObjRp<QuyenHan> themQuyenHan(@RequestBody String quyenHan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        QuyenHan quyen = gson.fromJson(quyenHan, QuyenHan.class);
        return quyenHanServices.themQuyenHan(quyen);
    }
    @RequestMapping(value = "suaquyenhan", method = RequestMethod.PUT)
    public ObjRp<QuyenHan> suaQuyenHan(@RequestBody String quyenHan){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        QuyenHan quyen = gson.fromJson(quyenHan, QuyenHan.class);
        return quyenHanServices.suaQuyenHan(quyen);
    }
    @RequestMapping(value = "xoaquyengan", method = RequestMethod.DELETE)
    public ObjRp<QuyenHan> xoaQuyenHan(@RequestParam int id){
        return quyenHanServices.xoaQuyenHan(id);
    }
    @RequestMapping(value = "layds", method = RequestMethod.GET)
    public List<QuyenHan> layQuyenHan(){
        return quyenHanServices.layQuyenHan();
    }
}
