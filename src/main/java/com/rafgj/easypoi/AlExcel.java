package com.rafgj.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.json.simple.JSONArray;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AlExcel implements Cloneable{




    @Test
    public void test() {
        String filePath = "D:\\code\\Excel\\表1.xls";
        List<Demo1> list1 = EasyExcel.read(filePath).head(Demo1.class).sheet(0).doReadSync();
        List<Demo2> list2 = EasyExcel.read(filePath).head(Demo2.class).sheet(1).doReadSync();
        System.out.println(list1);
        System.out.println(list2);
        List<Demo> list = new ArrayList<>();
        Map<String, Integer> map = list2.stream().collect(Collectors.toMap(Demo2::getName, Demo2::getMoney));
        for (Demo1 demo1 : list1) {
            String name = demo1.getName();
            Integer money = map.get(name);
            Demo demo = new Demo();
            demo.setAge(demo1.getAge());
            demo.setDept(demo1.getDept());
            demo.setNum(demo1.getNum());
            demo.setName(demo1.getName());
            demo.setMoney(money);
            list.add(demo);
        }
        //表头
        List<List<String>> headList = new ArrayList<>();
        headList.add(Lists.newArrayList("序号"));
        headList.add(Lists.newArrayList("姓名"));
        headList.add(Lists.newArrayList("部门"));
        headList.add(Lists.newArrayList("工龄"));
        headList.add(Lists.newArrayList("工资"));

        List<List<String>> headList1 = new ArrayList<>();
        headList1.add(Lists.newArrayList("序号"));
        headList1.add(Lists.newArrayList("姓名"));
        headList1.add(Lists.newArrayList("部门"));
        headList1.add(Lists.newArrayList("工龄"));

        List<List<String>> headList2 = new ArrayList<>();
        headList2.add(Lists.newArrayList("序号"));
        headList2.add(Lists.newArrayList("姓名"));
        headList2.add(Lists.newArrayList("工资"));

//        EasyExcel.write("D:\\code\\Excel\\表5.xls").head(headList).sheet("用户信息").sheetNo(0).doWrite(list1);
        ExcelWriter build = EasyExcel.write("D:\\code\\Excel\\表7.xls").build();
        WriteSheet sheet = EasyExcel.writerSheet(0, "结果表").head(headList).build();
        WriteSheet sheet1 = EasyExcel.writerSheet(1, "表1").head(headList1).build();
        WriteSheet sheet2 = EasyExcel.writerSheet(2, "表2").head(headList2).build();
        build.write(list, sheet);
        build.write(list1, sheet1);
        build.write(list2, sheet2).finish();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

    }
}



