package com.example.poi.service.impl;

import com.example.poi.entity.Users;
import com.example.poi.repository.GoodsRepository;
import com.example.poi.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    
    @Resource
    private GoodsRepository goodsRepository;
    
    @Override
    public Boolean uploadExcel(MultipartFile file) throws IOException {
        
        // 解析excel文件
        List<Users> result = new ArrayList<Users>();
        try {
            InputStream is = file.getInputStream();
            is = new PushbackInputStream(is, 8);
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRaw = sheet.getPhysicalNumberOfRows();
            int firstIndex = 1;
            for (int i = firstIndex; i < lastRaw; i++) {
                // 封装实体类
                Users users = new Users();
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                int cells = row.getPhysicalNumberOfCells();
                for (int j = 0; j < cells; j++) {
                    Cell cell = row.getCell(j);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String value = cell.getStringCellValue();
                    this.setField(users, j, value);
                }
                // 存放集合
                result.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 存入数据库
        System.out.println("result = " + result);
        
        return true;
    }
    
    private void setField(Users users, int j, String value) {
        if (StringUtils.isBlank(value)) {
            return;
        }
        if (j == 0) {
            users.setId(Long.valueOf(value));
        } else if (j == 1) {
            users.setName(value);
        } else if (j == 2) {
            users.setAge(Long.valueOf(value));
        }
    }
    
}
