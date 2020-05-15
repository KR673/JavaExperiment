package com.wxb.commontest.modules;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.lang.NonNull;
import java.io.*;
import java.util.*;

public class ExcelRead {

    public static void main(String[] args) throws  InvalidFormatException {
//        String path = "E:\\Document\\A项目原型\\推广系统_原型+资料\\推广系统_原型+资料\\报表说明\\六大基础表\\2-机会库.xlsx";
//        List fields = getFields(path);
//        if(CollectionUtils.isEmpty(fields)){
//
//        }

//        Map excelDataByPage = getExcelDataByPage(path, fields, 1, 10);
        String a = null;
        testNon(a);
    }

    public static void testNon(@NonNull String a){
        System.out.println("可以为空");
    }

    public static Map<String, Object> getExcelDataByPage(String path, List<String> fields, Integer page, Integer limit) throws  InvalidFormatException {

        try(FileInputStream in = new FileInputStream(path)){
            Workbook wb = WorkbookFactory.create(in);
            Sheet sheet = wb.getSheetAt(0);

            if (Objects.isNull(sheet)) {
                return new HashMap<>();
            }
            List<Map> resultList = new ArrayList<>();
            //取出 page 和 limit 之前的数据
            int rowNumber = 0;
            int step = page > 0 ? (page - 1) * limit + 2 : 2;
            limit = page + limit;
            for (Row rowData : sheet) {
                if (rowNumber >= step) {
                    //遍历每一行数据
                    Map<String, Object> map = new HashMap<>();
                    for (Cell cell : rowData) {
                        if(cell.getColumnIndex() < fields.size()){
                            map.put(fields.get(cell.getColumnIndex()), String.valueOf(cell));
                        }
                    }
                    resultList.add(map);
                }
                rowNumber++;
                if(rowNumber >= limit){
                    break;
                }
            }
            return new HashMap<>() {{
                put("data", resultList);
                put("count", sheet.getLastRowNum() + 1);
            }};
        }catch (IOException e){
            return new HashMap<>() {{
                put("data","文件不存在");
                put("count", 0);
            }};
        }
    }

    public static List<String> getFields(String path) throws InvalidFormatException {

        try(FileInputStream in = new FileInputStream(path)) {
            List<String> result = new ArrayList<>();
            Workbook wb = WorkbookFactory.create(in);
            Sheet sheet = wb.getSheetAt(0);

            if (sheet != null) {
                for (Row rowData : sheet) {
                    for (Cell cell : rowData) {
                        result.add(cell.toString());
                    }
                    break;
                }
            }
            return result;
        } catch (IOException e){
            return new ArrayList<>();
        }
    }

}
