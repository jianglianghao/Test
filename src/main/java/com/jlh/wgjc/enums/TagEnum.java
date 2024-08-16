package com.jlh.wgjc.enums;

import com.rafgj.easypoi.SortEnum;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum TagEnum {
    A1("开办企业手续",1),
    A2("开办企业时间",	2),
    A3("办理建筑许可手续",	3),
    A4("办理建筑许可时间",	4),
    A5("获得电力手续",	5),
    A6("获得电力时间",	6),
    A7("获得用水手续",	7),
    A8("获得用水时间",	8),
    A9("*获得用气手续",	9),
    A10("*获得用气时间",	10),
    A11("登记财产手续",	11),
    A12("登记财产时间",	12),
    A13("报税后流程指数",	13),
    A14("网上综合办税率",	14),
    A15("审理时间",	15),
    A16("执行时间",	16),
    A17("实际执结率",	17),
    A18("诉前化解率",	18),
    A19("程序比",	19),
    A20("涉商事纠纷初次化解率",	20),
    A21("注销企业手续",	21),
    A22("注销企业时间",	22),
    A23("企业研发机构强度指数",	23),
    A24("博士后工作站招收占比(%)",	24),
    A25("劳动人事争议调节成功率(%)",	25),
    A26("人力资源服务机构发展指数",	26),
    A27("省级科技型中小企业数增长率",	27),
    A28("全程无纸化投标（响应）项目数占比",	28),
    A29("中小企业中标",	29),
    A30("合同预付款平均比例",	30),
    A31("履约保证金平均比例",	31),
    A32("采购结果公告平均时长",	32),
    A33("交易数据完整率",	33),
    A34("全省统一招标投标系统应用率",	34),
    A35("远程异地多点评标利用率",	35),
    A36("数字保函应用率",	36),
    A37("交易效率",	37),
    A38("合同信息公开率",	38),
    A39("CA互认应用率",	39),
    A40("评标专家依法抽取率",	40),
    A41("外地企业中标率",	41),
    A42("“双随机、一公开”抽查事项覆盖率",	42),
    A43("“双随机、一公开”抽查占比",	43),
    A44("跨部门联合双随机监管率",	44),
    A45("地方政府公共信用指数",	45),
    A46("企业公共信用评价优良率",	46),
    A47("企业公共信用评价不良率",	47),
    A48("市（县）内二级及以上公路里程占比增长数",	48),
    A49("细颗粒物浓度（PM2.5）",	49),
    A50("空气质量优良率",	50),
    A51("省控断面三类及以上水质优良率",	51),
    A52("工业危险废物处置率",	52),
    A53("民营规上工业企业每百元营业收入成本",	53),
    A54("发明专利授权量",	54),
    A55("有效发明专利拥有量",	55),
    A56("有效发明专利拥有量增幅",	56),
    A57("调解机构数",	57),
    A58("行政处罚案件公开数占结案数百分比",	58),

            ;

    private String name;

    private Integer sort;

    TagEnum(String name, Integer sort) {
        this.name = name;
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public static TagEnum getEnum(String str) {
        for (TagEnum value : values()) {
            String name = value.name;
            if(name.equals(str)) {
                return value;
            }

        }
        return null;
    }

    public static List<String> sort(List<String> list) {

        List<TagEnum> sorts = new ArrayList<>();
        List<String> notIns = new ArrayList<>();
        for (String s : list) {
            TagEnum anEnum = getEnum(s);
            if(anEnum != null) {
                sorts.add(anEnum);
            }  else {
                notIns.add(s);
            }

        }
        if(!CollectionUtils.isEmpty(sorts)) {
            List<TagEnum> result = sorts.stream().sorted(new Comparator<TagEnum>() {
                @Override
                public int compare(TagEnum sortEnum, TagEnum t1) {
                    return sortEnum.sort - t1.sort;
                }
            }).collect(Collectors.toList());
            List<String> collect = result.stream().map(TagEnum::getName).collect(Collectors.toList());
//            collect.addAll(notIns);
            return collect;
        }
        return Collections.EMPTY_LIST;
    }
}
