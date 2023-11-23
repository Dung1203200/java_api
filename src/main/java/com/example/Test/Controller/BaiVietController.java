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

import com.example.Test.Models.BaiViet;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.BaiVietServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@RestController
@RequestMapping(value  = "baiviet")
public class BaiVietController {
   @Autowired
   private BaiVietServices baiVietServices;
   @RequestMapping(value = "thembaiviet" , method = RequestMethod.POST)
   public ObjRp<BaiViet> themBaiViet(@RequestBody String baiViet, BindingResult bindingResult){
         Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }
        }).create();
        BaiViet bViet = gson.fromJson(baiViet, BaiViet.class);
        return baiVietServices.themBaiViet(bViet, bindingResult);
   }
    @RequestMapping(value = "suabaiviet" , method = RequestMethod.PUT)
    public ObjRp<BaiViet> suaBaiViet(@RequestBody String baiViet, BindingResult bindingResult){
         Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException {
                return LocalDate.parse(json.getAsString());
            }

        }).create();
        BaiViet bViet = gson.fromJson(baiViet, BaiViet.class);
        return baiVietServices.suaBaiViet(bViet, bindingResult);
   }
     @RequestMapping(value = "xoabaiviet", method = RequestMethod.DELETE)
     public ObjRp<BaiViet> xoaBaiViet(@RequestParam int id){
          return baiVietServices.xoaBaiViet(id);
     }
     @RequestMapping(value = "timkiembaiviet", method = RequestMethod.GET)
     public List<BaiViet> timKiem(@RequestParam String ten){
          return baiVietServices.timKiem(ten);
     }
     @RequestMapping(value = "layds", method = RequestMethod.GET)
     public List<BaiViet> layDS(){
          return baiVietServices.layDS();
     }
}
