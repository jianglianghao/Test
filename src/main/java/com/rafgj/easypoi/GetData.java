package com.rafgj.easypoi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.checkerframework.checker.units.qual.C;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GetData {

    public static void main(String[] args) {
        String area = "上城区、拱墅区、西湖区、滨江区、萧山区、余杭区、临平区、钱塘区、富阳区、临安区、桐庐县、淳安县、建德市、海曙区、江北区、北仑区、镇海区、鄞州区、奉化区、象山县、宁海县、余姚市、慈溪市、鹿城区、龙湾区、瓯海区、洞头区、永嘉县、平阳县、苍南县、文成县、泰顺县、瑞安市、乐清市、龙港市、南湖区、秀洲区、嘉善县、海盐县、海宁市、平湖市、桐乡市、吴兴区、南浔区、德清县、长兴县、安吉县、越城区、柯桥区、上虞区、新昌县、诸暨市、嵊州市、婺城区、金东区、武义县、浦江县、磐安县、兰溪市、义乌市、东阳市、永康市、柯城区、衢江区、常山县、开化县、龙游县、江山市、定海区、普陀区、岱山县、嵊泗县、椒江区、黄岩区、路桥区、三门县、天台县、仙居县、温岭市、临海市、玉环市、莲都区、青田县、缙云县、遂昌县、松阳县、云和县、庆元县、景宁县、龙泉市";
        List<String> areaList = Arrays.asList(area.split("、"));
        List<String> codes = Lists.newArrayList("330100","330200","330300","330400","330500","330600","330700","330800","330900","331000","331100");

        String url = "https://dgov-integrate-task.zj.gov.cn/yshjapi/wgjc/quotaValue";

        List<City> allCity = new ArrayList<>();
        List<City> wzCitys = new ArrayList<>();
        //0-从小到大 1-从大到小
        int flag = 0;
        //是否排序，默认不排序
        boolean sort = false;
        for (int i = 0; i < codes.size(); i++) {
            String code = codes.get(i);

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("areaCode", code));
            params.add(new BasicNameValuePair("code", "2024_W330000030106"));
            params.add(new BasicNameValuePair("statDate", "2024-06"));
            params.add(new BasicNameValuePair("type", "1"));
            params.add(new BasicNameValuePair("tag", "1"));
//        params.add(new BasicHeader("Stoken", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmODMyMDkyMi1lMjRkLTRiMjEtOWYyOC03MWQ4ZjNiMGIzODEiLCJpYXQiOjE3MjI0ODU4MTgsImV4cCI6MTcyMjQ4OTQxOH0.InerLEHHMw77ovqjp7fLmRAyJlGDv0O-3e2ztq-s12eqlTdv4hH33iNOcPkDIAH8lMt12LIL8IDaoG3yTN5i9g"));

            String result = HttpClientUtils.post(url, params);

            JSONObject jsonObject = JSON.parseObject(result);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray xList = data.getJSONArray("xList");
            JSONArray yList = data.getJSONArray("yList");
            if(xList == null || yList == null) {
                continue;
            }
            for (int j = 1; j < xList.size(); j++) {
                 City city = new City();
                 city.setPreName(xList.getString(0));
                 city.setName(xList.getString(j));
                 city.setValue(yList.getDoubleValue(j));
                 allCity.add(city);
                if(StringUtils.equals(code, "330300")) {
                    City wzCity = new City();
                    wzCity.setPreName(xList.getString(0));
                    wzCity.setName(xList.getString(i));
                    wzCity.setValue(yList.getDoubleValue(i));
                    wzCitys.add(city);
                }
            }

        }

        if(sort) {
            if(!CollectionUtils.isEmpty(wzCitys)) {
                List<City> collect = new ArrayList<>();
                if (flag == 0) {
                    collect = wzCitys.stream().sorted((o1,o2) -> {
                        return o1.getValue().compareTo(o2.getValue());
                    }).collect(Collectors.toList());
                } else {
                    collect = wzCitys.stream().sorted((o1,o2) -> {
                                return o2.getValue().compareTo(o1.getValue());
                            }
                    ).collect(Collectors.toList());
                }




                for (City city : collect) {
                    city.setRank(collect.indexOf(city) + 1);
                    System.out.println(city.getPreName() + "\t"  + city.getName() + "\t" + city.getValue()+"\t" + city.getRank());
                }
            }
            System.out.println("================================================================================");
            if(!CollectionUtils.isEmpty(allCity)) {

                List<City> collect = new ArrayList<>();
                if (flag == 0) {
                    collect = allCity.stream().sorted((o1,o2) -> {
                        return o1.getValue().compareTo(o2.getValue());
                    }).collect(Collectors.toList());
                } else {
                    collect = allCity.stream().sorted((o1,o2) -> {
                                return o2.getValue().compareTo(o1.getValue());
                            }
                    ).collect(Collectors.toList());
                }

                for (City city : collect) {
                    city.setRank(collect.indexOf(city) + 1);
                    System.out.println(city.getPreName() + "\t"  + city.getName() + "\t" + city.getValue() +"\t" + city.getRank());
                }
            }
        } else {
//            if(!CollectionUtils.isEmpty(wzCitys)) {
//                for (City city : wzCitys) {
//                    System.out.println(city.getPreName() + "\t"  + city.getName() + "\t" + city.getValue());
//                }
//            }
//            System.out.println("=========================================================================================");
            if(!CollectionUtils.isEmpty(allCity)) {
                List<String> list = allCity.stream().map(City::getName).collect(Collectors.toList());
                List<String> other = areaList.stream().filter(areas -> !list.contains(areas)).collect(Collectors.toList());
                if(!CollectionUtils.isEmpty(other)){
                    Map<String, Double> map = allCity.stream().collect(Collectors.toMap(City::getName, City::getValue));
                    System.out.println("没有数据的城市:" + other);
                    for (String cityName : areaList) {
                        if(list.contains(cityName)) {
                            Double data = map.get(cityName);
                            System.out.println(data);
                        }else {
                            System.out.println("无数据");
                        }

                    }
                } else {
                    for (City city : allCity) {
//                    System.out.println(city.getPreName() + "\t"  + city.getName() + "\t" + city.getValue());
                        System.out.println(city.getValue());
                    }
                }


            }
        }





    }
}
