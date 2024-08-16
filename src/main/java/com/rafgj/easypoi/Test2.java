package com.rafgj.easypoi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        String s = "市市监局、市市监局、市住建局、市住建局、市电力局、市电力局、市电力局、市电力局、市公发集团、市公发集团、市资规局、市资规局、市税务局、市税务局、市法院、市法院、市法院、市法院、市法院、市信访局、市市监局、市市监局、市科技局、市人社局、市人社局、市人社局、市科技局、市科技局、市财政局、市财政局、市财政局、市财政局、市财政局、市发改局、市发改局、市发改局、市发改局、市发改局、市发改局、市发改局、市发改局、市发改局、市市监局、市市监局、市市监局、市发改局、市发改局、市发改局、市交通局、市生态环境瑞安分局、市生态环境瑞安分局、市生态环境瑞安分局、市生态环境瑞安分局、市发改局、市市监局、市市监局、市市监局、市市监局、市市监局";
        String[] split = s.split("、");
        List<String> arrays = Arrays.asList(split);
        System.out.println("输入的数量：" + arrays.size());
        List<String> list = arrays.stream().distinct().collect(Collectors.toList());
        System.out.println("去重后的数量：" + list.size());
        System.out.println(list);
        List<String> rules = SortEnum.getRule(list);
        System.out.println("=====================================================");
        System.out.println("输出的数量:" + rules.size());
        StringBuffer sb = new StringBuffer();
        for (String rule : rules) {
            sb.append(rule).append("、");
        }
        System.out.println(sb.substring(0, sb.lastIndexOf("、")));

    }
}
