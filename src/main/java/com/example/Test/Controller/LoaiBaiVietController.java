package com.example.Test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Test.Models.LoaiBaiViet;
import com.example.Test.Models.ObjRespon.ObjRp;
import com.example.Test.Services.LoaiBaiVietServices;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "loaibaiviet")
public class LoaiBaiVietController {
    @Autowired
    private LoaiBaiVietServices loaiBaiVietServices;
    @RequestMapping(value = "themloaibaiviet", method = RequestMethod.POST)
    private ObjRp<LoaiBaiViet> themLoaiBaiViet(@RequestBody String loaiBaiViet){
        Gson gson = new Gson();
        LoaiBaiViet loai = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBaiVietServices.themLoaiBaiViet(loai);
    }
    @RequestMapping(value = "sualoaibaiviet", method = RequestMethod.PUT)
    private ObjRp<LoaiBaiViet> suaLoaiBaiViet(@RequestBody String loaiBaiViet){
        Gson gson = new Gson();
        LoaiBaiViet loai = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
        return loaiBaiVietServices.suaLoaiBaiViet(loai);
    }
    @RequestMapping(value="xoaloaibaiviet", method=RequestMethod.DELETE)
    public ObjRp<LoaiBaiViet> xoaLoaiBaiViet(@RequestParam int id) {
        return loaiBaiVietServices.xoaLoaiBaiViet(id);
    }
    @RequestMapping(value="hienthiloaibaiviet", method=RequestMethod.GET)
    public List<LoaiBaiViet> hienthiLoaiBaiViet() {
        return loaiBaiVietServices.hienThi();
    }
}
