package com.example.poi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GoodsService {
    
    Boolean uploadExcel(MultipartFile file) throws IOException;
    
}
