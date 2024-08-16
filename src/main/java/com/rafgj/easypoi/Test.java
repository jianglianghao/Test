package com.rafgj.easypoi;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String js = "瑞安市马屿镇sawssas洒水";
        String js1 = "瑞安市仙降街道而且鞍山市大";
        String js2 = "安阳街道谁打我的啊都上望街道是";
        String js3 = "塘下镇谁打我的啊都是";

        String reg = "^(瑞安市)?(.*?[镇|街道]{1,2})";
        ArrayList<String> lists = Lists.newArrayList(js, js1, js2,js3);
        for (String list : lists) {
            Pattern compile = Pattern.compile(reg);
            Matcher matcher = compile.matcher(list);
            while (matcher.find()) {
                System.out.println(matcher.group(2));
            }
        }

    }
}
