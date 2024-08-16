package com.rafgj.easypoi;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public enum SortEnum {
    JW(Arrays.asList("市纪委市监委","市纪委","市纪委监委"), 1,"市纪委市监委","市纪委市监委"),
    RMFY(Arrays.asList("市人民法院","市法院"), 2,"市人民法院", "市法院"),
    RMJCY(Arrays.asList("市人民检察院","市检察院"), 3, "市人民检察院", "市检察院"),
    WB(Arrays.asList("市委办公室","市委办"), 4, "市委办公室", "市委办"),
    RD(Arrays.asList("市人大常委会办公室","市人大办公室"), 5, "市人大常委会办公室", "市人大办公室"),
    FB(Arrays.asList("市政府办公室","市府办"), 6, "市政府办公室", "市府办"),
    ZXFB(Arrays.asList("市政协办公室","市协办"), 7, "市政协办公室", "市政协办公室"),
    ZZB(Arrays.asList("市委组织部","市委组织部"), 8, "市委组织部", "市委组织部"),
    ZZBRCB(Arrays.asList("市委组织部（市人才办）","市委组织部（市人才办）"), 8, "市委组织部（市人才办）", "市委组织部（市人才办）"),
    XCB(Arrays.asList("市委宣传部","市委宣传部"), 9, "市委宣传部", "市委宣传部"),
    XCBWXB(Arrays.asList("市委宣传部(网信办)","市委宣传部(网信办)"), 9, "市委宣传部(网信办)", "市委宣传部(网信办)"),
    TZB(Arrays.asList("市委统战部","市委统战部"),10, "市委统战部", "市委统战部"),
    SGB(Arrays.asList("市委社工部","市委社工部"),11, "市委社工部", "市委社工部"),
    ZFW(Arrays.asList("市委政法委","市委政法委"),12, "市委政法委", "市委政法委"),
    GGB(Arrays.asList("市委改革办","市委改革办"), 13, "市委改革办", "市委改革办"),
    BB(Arrays.asList("市委编办","市委编办"), 13, "市委编办", "市委编办"),
    JGGW(Arrays.asList("市委直属机关工委","市委机关工委"), 14, "市委直属机关工委", "市委机关工委"),
    WXCB(Arrays.asList("市委巡察办","市委巡察办"), 15, "市委巡察办", "市委巡察办"),
    XFJ(Arrays.asList("市信访局","市信访局"), 16, "市信访局", "市信访局"),
    DX(Arrays.asList("市委党校","市委党校"), 17, "市委党校", "市委党校"),
    DSYJS(Arrays.asList("市委党史研究室","市委党史研究室"), 18, "市委党史研究室", "市委党史研究室"),
    DAG(Arrays.asList("市档案馆","市档案馆"), 19, "市档案馆", "市档案馆"),
    JSWM(Arrays.asList("市精神文明建设指导中心","市精神文明指导中心"), 20, "市精神文明建设指导中心", "市精神文明建设指导中心"),
    SHZL(Arrays.asList("市社会治理中心","市社会治理中心"), 21, "市社会治理中心", "市社会治理中心"),
    LGJK(Arrays.asList("市“两个健康”办","市“两个健康”办"), 6, "市“两个健康”办", "市“两个健康”办"),
    RMT(Arrays.asList("市融媒体中心","市融媒体中心"), 22, "市融媒体中心", "市融媒体中心"),
    FGJ(Arrays.asList("市发改局","市发改局"), 23, "市发改局", "市发改局"),
    JXJ(Arrays.asList("市经信局","市经信局"), 24, "市经信局", "市经信局"),
    JYJ(Arrays.asList("市教育局","市教育局"), 25, "市教育局", "市教育局"),
    KJJ(Arrays.asList("市科技局","市科技局"), 26, "市科技局", "市科技局"),
    MZJ(Arrays.asList("市民宗局","市民宗局"), 27, "市民宗局", "市民宗局"),
    GAJ(Arrays.asList("市公安局","市公安局"), 28, "市公安局", "市公安局"),
    SMZJ(Arrays.asList("市民政局","市民政局"), 29, "市民政局", "市民政局"),
    SFJ(Arrays.asList("市司法局","市司法局"), 30, "市司法局", "市司法局"),
    CZJ(Arrays.asList("市财政局","市财政局"), 31, "市财政局", "市财政局"),
    RSJ(Arrays.asList("市人力社保局","市人社局"), 32, "市人力社保局", "市人社局"),
    ZGJ(Arrays.asList("市自然资源和规划局","市资规局"), 33, "市自然资源和规划局", "市资规局"),
    ZJJ(Arrays.asList("市住建局","市住建局"), 34, "市住建局", "市住建局"),
    JTJ(Arrays.asList("市交通运输局","市交通运输局","市交通局"),35, "市交通运输局", "市交通运输局"),
    SLJ(Arrays.asList("市水利局","市水利局"), 36, "市水利局", "市水利局"),
    NYNCJ(Arrays.asList("市农业农村局","市农业农村局"), 37, "市农业农村局", "市农业农村局"),
    SWJ(Arrays.asList("市商务局","市商务局"), 38, "市商务局", "市商务局"),
    WGLTJ(Arrays.asList("市文化和广电旅游体育局","市文广旅体局"), 39, "市文化和广电旅游体育局", "市文广旅体局"),
    JKJ(Arrays.asList("市卫生健康局","市卫健局"), 40, "市卫生健康局", "市卫健局"),
    TYJRJ(Arrays.asList("市退役军人事务局","市退役军人事务局"), 41, "市退役军人事务局", "市退役军人事务局"),
    YJJ(Arrays.asList("市应急管理局","市应急管理局"), 42, "市应急管理局", "市应急管理局"),
    SJJ(Arrays.asList("市审计局","市审计局"), 43, "市审计局", "市审计局"),
    SSJ(Arrays.asList("市市场监管局","市市监局"),44, "市市场监管局", "市市监局"),
    TJJ(Arrays.asList("市统计局","市统计局"), 45, "市统计局", "市统计局"),
    YBJ(Arrays.asList("市医疗保障局","市医保局"), 46, "市医疗保障局", "市医保局"),
    XZZFJ(Arrays.asList("市综合行政执法局","市行政执法局","市综合执法局"),47, "市综合行政执法局", "市综合行政执法局"),
    HJJ(Arrays.asList("温州市生态环境局瑞安分局","市生态环境局","生态环境分局","市生态环境瑞安分局"), 48,"温州市生态环境局瑞安分局", "温州市生态环境局瑞安分局"),
    OFGLZX(Arrays.asList("市瓯飞开发建设管理中心","市瓯飞开发建设管理中心"), 49, "市瓯飞开发建设管理中心", "市瓯飞开发建设管理中心"),
    JRGZ(Arrays.asList("市金融工作服务中心","市金融中心","金融办", "市金融办"), 50, "市金融工作服务中心", "市金融工作服务中心"),
    TYSY(Arrays.asList("市体育事业发展中心","市体育事业发展中心"), 51, "市体育事业发展中心", "市体育事业发展中心"),
    JGSW(Arrays.asList("市机关事务管理中心","市机关事务管理中心"), 52, "市机关事务管理中心", "市机关事务管理中心"),
    TCZX(Arrays.asList("市投资促进服务中心","市投促中心"), 53, "市投资促进服务中心", "市投促中心"),
    ZWFW(Arrays.asList("市政务服务中心","市政务服务中心"), 54, "市政务服务中心", "市政务服务中心"),
    XJM(Arrays.asList("市新居民服务中心","市新居民服务中心"), 55, "市新居民服务中心", "市新居民服务中心"),
    GXS(Arrays.asList("市供销联社","市供销社"),56, "市供销联社", "市供销社"),
    EQLS(Arrays.asList("市二轻联社","市二轻联社"), 57, "市二轻联社", "市二轻联社"),
    MCJS(Arrays.asList("瑞安安阳中心城区开发建设中心（市名城建设中心）","市名城建设中心"),58, "瑞安安阳中心城区开发建设中心（市名城建设中心）","市名城建设中心"),
    CSGX(Arrays.asList("市城市更新中心","市城市更新中心"), 59, "市城市更新中心","市城市更新中心"),
    ZFTZ(Arrays.asList("市政府投资工程建设中心","市政府投资工程建设中心"), 60, "市政府投资工程建设中心","市政府投资工程建设中心"),
    JTGC(Arrays.asList("市交通工程建设中心","市交通工程建设中心"), 61, "市交通工程建设中心","市交通工程建设中心"),
    GSGL(Arrays.asList("市高速公路工程建设中心","市高速公路工程建设中心"), 62, "市高速公路工程建设中心","市高速公路工程建设中心"),
    SLGC(Arrays.asList("市水利工程建设中心","市水利工程建设中心"), 63, "市水利工程建设中心","市水利工程建设中心"),
    WRTH(Arrays.asList("市温瑞塘河工程建设中心","市温瑞塘河工程建设中心"), 64, "市温瑞塘河工程建设中心","市温瑞塘河工程建设中心"),
    DSJ(Arrays.asList("市大数据管理中心","市大数据管理中心"), 65, "市大数据管理中心","市大数据管理中心"),
    ZGH(Arrays.asList("市总工会","市总工会"), 66, "市总工会","市总工会"),
    TSW(Arrays.asList("团市委","团市委"), 67, "团市委","团市委"),
    FL(Arrays.asList("市妇联","市妇联"), 68,"市妇联","市妇联"),
    SKX(Arrays.asList("市科协","市科协"), 69,"市科协","市科协"),
    SQL(Arrays.asList("市侨联","市侨联"), 70,"市侨联","市侨联"),
    SWL(Arrays.asList("市文联","市文联"), 71, "市文联","市文联"),
    SSKL(Arrays.asList("市社科联","市社科联"), 72, "市社科联","市社科联"),
    SCL(Arrays.asList("市残联","市残联"), 73, "市残联","市残联"),
    HSZH(Arrays.asList("市红十字会","市红十字会"), 74, "市红十字会","市红十字会"),
    SGSL(Arrays.asList("市工商联","市工商联"), 75, "市工商联","市工商联"),
    SSWJ(Arrays.asList("市税务局","市税务局"), 76,"市税务局","市税务局"),
    SGAJ(Arrays.asList("市国安局","市国安局"), 77, "市国安局","市国安局"),
    RAJG(Arrays.asList("国家金融监督管理总局瑞安监管支局","国家金融监管总局瑞安监管支局","瑞安金融监管支局"),78, "国家金融监督管理总局瑞安监管支局", "国家金融监督管理总局瑞安监管支局"),
    RHZH(Arrays.asList("人行瑞安市支行","人行瑞安市支行"),78, "人行瑞安市支行", "人行瑞安市支行"),
    HGC(Arrays.asList("海关瑞鳌办事处","海关瑞鳌办事处"), 79, "海关瑞鳌办事处","海关瑞鳌办事处"),
    QXJ(Arrays.asList("市气象局","市气象局"), 80,"市气象局","市气象局"),
    FY(Arrays.asList("飞云江海事处","飞云江海事处"), 81, "飞云江海事处","飞云江海事处"),
    GJJ(Arrays.asList("公积金管理瑞安分中心","公积金管理中心"), 82, "公积金管理瑞安分中心", "公积金管理瑞安分中心"),
    GDJ(Arrays.asList("市供电局","市供电局","市电力局"), 83, "市供电局","市供电局"),
    YCJ(Arrays.asList("市烟草局","市烟草局"), 84, "市烟草局", "市烟草局"),
    XFDD(Arrays.asList("市消防救援大队","市消防救援大队","市消防大队"), 85, "市消防救援大队", "市消防救援大队"),
    SGDJ(Arrays.asList("国家统计局瑞安调查队","国调队"), 86, "国家统计局瑞安调查队","国家统计局瑞安调查队"),
    YZJ(Arrays.asList("瑞安邮政管理局","市邮政局","市邮政管理局"), 87, "瑞安邮政管理局", "瑞安邮政管理局"),
    YZFGS(Arrays.asList("邮政瑞安分公司","邮政瑞安分公司"), 88, "邮政瑞安分公司", "邮政瑞安分公司"),
    DXGS(Arrays.asList("电信瑞安分公司","电信瑞安分公司"), 89,"电信瑞安分公司","电信瑞安分公司"),
    YDGS(Arrays.asList("移动瑞安分公司","移动瑞安分公司"), 90, "移动瑞安分公司","移动瑞安分公司"),
    LTGS(Arrays.asList("联通瑞安分公司","联通瑞安分公司"), 91, "联通瑞安分公司","联通瑞安分公司"),
    HSGS(Arrays.asList("市华数广电网络有限公司","市华数广电网络有限公司"), 92, "市华数广电网络有限公司", "市华数广电网络有限公司"),
    GSYH(Arrays.asList("工行瑞安支行","工商银行"), 93, "工行瑞安支行", "工行瑞安支行"),
    NYYH(Arrays.asList("农行瑞安市支行","农业银行"), 94, "农行瑞安市支行", "农行瑞安市支行"),
    ZGYH(Arrays.asList("中行瑞安市支行","中国银行"), 95, "中行瑞安市支行", "中行瑞安市支行"),
    JSYH(Arrays.asList("建行瑞安支行","建设银行"), 96, "建行瑞安支行", "建行瑞安支行"),
    NFH(Arrays.asList("农发行瑞安市支行","农发行瑞安市支行"), 97, "农发行瑞安市支行","农发行瑞安市支行"),
    NCYH(Arrays.asList("瑞安农村商业银行","农商银行"), 98, "瑞安农村商业银行", "瑞安农村商业银行"),
    KFDX(Arrays.asList("浙江开放大学瑞安学院","浙江开放大学瑞安学院"), 99, "浙江开放大学瑞安学院","浙江开放大学瑞安学院"),
    RAZX(Arrays.asList("瑞安中学","瑞安中学"), 100, "瑞安中学","瑞安中学"),
    RMYY(Arrays.asList("市人民医院","市人民医院"), 101, "市人民医院","市人民医院"),
    SGT(Arrays.asList("市国投集团","市国投"),102, "市国投集团","市国投集团"),
    SCF(Arrays.asList("市产发集团","市产发"),103, "市产发集团", "市产发集团"),
    SGF(Arrays.asList("市国发集团","市国发"), 104, "市国发集团", "市国发集团"),
    SCFJT(Arrays.asList("市城发集团","市城发"),105, "市城发集团", "市城发集团"),
    SWGS(Arrays.asList("温州市公发集团瑞安水务有限公司","瑞安水务公司"), 106, "温州市公发集团瑞安水务有限公司", "温州市公发集团瑞安水务有限公司")
    ;


    private List<String> name;

    private Integer sort;

    private String outRule;

    private String outUnRule;

    SortEnum(List<String> name, Integer sort, String outRule, String outUnRule) {
        this.name = name;
        this.sort = sort;
        this.outRule = outRule;
        this.outUnRule = outUnRule;
    }

    private static SortEnum getEnum(String str) {
        for (SortEnum value : values()) {
            List<String> names = value.name;
            for (String name : names) {
                if(name.contains(str)) {
                    return value;
                }
            }


        }
        return null;
    }

    public static List<String> getRule(List<String> list) {

        List<SortEnum> sorts = new ArrayList<>();
        List<String> notIns = new ArrayList<>();
        for (String s : list) {
            SortEnum anEnum = getEnum(s);
            if(anEnum != null) {
                sorts.add(anEnum);
            }  else {
                notIns.add(s);
            }

        }
        if(!CollectionUtils.isEmpty(sorts)) {
            List<SortEnum> result = sorts.stream().sorted(new Comparator<SortEnum>() {
                @Override
                public int compare(SortEnum sortEnum, SortEnum t1) {
                    return sortEnum.sort - t1.sort;
                }
            }).collect(Collectors.toList());
            List<String> collect = result.stream().map(SortEnum::getOutRule).collect(Collectors.toList());
            collect.addAll(notIns);
            return collect;
        }
       return Collections.EMPTY_LIST;
    }

    public static List<String> getUnRule(List<String> list) {
        List<SortEnum> sorts = new ArrayList<>();
        for (String s : list) {
            SortEnum anEnum = getEnum(s);
            if(anEnum != null) {
                sorts.add(anEnum);
            }

        }
        if(!CollectionUtils.isEmpty(sorts)) {
            List<SortEnum> result = sorts.stream().sorted(new Comparator<SortEnum>() {
                @Override
                public int compare(SortEnum sortEnum, SortEnum t1) {
                    return sortEnum.sort - t1.sort;
                }
            }).collect(Collectors.toList());
            List<String> collect = result.stream().map(SortEnum::getOutUnRule).collect(Collectors.toList());
            return collect;
        }
        return Collections.EMPTY_LIST;
    }


    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getOutRule() {
        return outRule;
    }

    public void setOutRule(String outRule) {
        this.outRule = outRule;
    }

    public String getOutUnRule() {
        return outUnRule;
    }

    public void setOutUnRule(String outUnRule) {
        this.outUnRule = outUnRule;
    }
}
