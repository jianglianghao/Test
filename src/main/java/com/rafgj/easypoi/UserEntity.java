package com.rafgj.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.imports.ExcelImportService;
import cn.afterturn.easypoi.exception.excel.ExcelImportException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Excel(name = "序号")
    private int num;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "部门")
    private String dept;
    @Excel(name = "工龄")
    private int age;
    @Excel(name = "工资")
    private int money;

    public static void main(String[] args) throws Exception {

        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        File file = new File("D:\\code\\Excel\\表1.xls");

        List<ImportParams> paramsList = new ArrayList<>();
        paramsList.add(params);


        List<UserEntity> list1 = ExcelImportUtil.importExcel(file,
                UserEntity.class, params);



        params.setStartSheetIndex(1);
        List<UserEntity> list2 = ExcelImportUtil.importExcel(file,
                UserEntity.class, params);
        Map<String, Integer> map = list2.stream().collect(Collectors.toMap(UserEntity::getName, UserEntity::getMoney));
        for (UserEntity userEntity : list1) {
            String name = userEntity.getName();
            Integer money = map.get(name);
            userEntity.setMoney(money);
        }
//
//        //生成excel文档
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户","用户信息"),
                UserEntity.class, list1);
        FileOutputStream fos = new FileOutputStream("D:\\code\\Excel\\表4.xls");
        workbook.write(fos);
        fos.close();
    }


    public static <T> List<List<T>> importExcel(File file, Class<?> pojoClass, List<ImportParams> paramsList) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            List<List<T>> map = new ArrayList<>();
            for (ImportParams importParams : paramsList) {
                List list = new ExcelImportService().importExcelByIs(in, pojoClass, importParams, false).getList();
                map.add(list);
            }
            return map;
        } catch (ExcelImportException e) {
            throw new ExcelImportException(e.getType(), e);
        } catch (Exception e) {
            throw new ExcelImportException(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
}
