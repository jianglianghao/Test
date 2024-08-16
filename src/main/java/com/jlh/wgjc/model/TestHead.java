package com.jlh.wgjc.model;


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TestHead {

    @ExcelProperty({"主标题", "字符串标题1", "措施"})
    private String a1;
    @ExcelProperty({"主标题", "字符串标题1", "政策"})
    private String a2;
    @ExcelProperty({"主标题", "字符串标题2", "/"})
    private String a3;
    @ExcelProperty({"主标题", "字符串标题3", "用电"})
    private String a4;
    @ExcelProperty({"主标题", "字符串标题4", "/"})
    private String a5;
}
