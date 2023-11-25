package com.rafgj.easypoi;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Demo {
    @ExcelProperty("序号")
    private Integer num;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("部门")
    private String dept;
    @ExcelProperty("工龄")
    private Integer age;
    @ExcelProperty("工资")
    private Integer money;
}