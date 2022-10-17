package com.example.poi.controller;

import com.example.poi.service.GoodsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RequestMapping("/goods")
@RestController
public class GoodsController {
    
    @Resource
    private GoodsService goodsService;
    
    @PostMapping("/uploadExcel")
    public Boolean uploadExcel(@RequestParam("file") MultipartFile file) {
        Boolean result = false;
        if (null == file) {
            return false;
        }
        try {
            result = this.goodsService.uploadExcel(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
