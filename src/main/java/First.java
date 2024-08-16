import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class First {
    public static void main(String[] args) {
        String s = "市税务局、市财政局、市科技局、市人社局、市财政局、市金融工作服务中心、市资规局、市经信局、市住建局、市财政局、市发改局、国家金融监管总局瑞安监管支局、市经信局、市财政局、市市监局、市税务局、市金融工作服务中心、市人社局、市教育局、市税务局、市市监局、市发改局、市住建局、市交通运输局、市水利局、市财政局（国资办）、市科技局、市发改局、市税务局、市大数据管理中心、市发改局、市住建局、市财政局（国资办）、国家金融监管总局瑞安监管支局、市发改局、市市监局、市司法局、市公安局、市住建局、市交通运输局、市水利局、市发改局、市经信局、市交通运输局、市住建局、市水利局、市商务局、市财政局、市税务局、国家金融监管总局瑞安监管支局、市市监局、市财政局、市资规局、市统计局、市税务局、市经信局、市发改局、市财政局、市经信局、市财政局、市税务局、市经信局、市科技局、市财政局、市资规局、市人社局、国家金融监管总局瑞安监管支局、市金融工作服务中心、市委政法委、市人民法院、市检察院、市公安局、市市监局、市司法局、市委统战部、市委社工部、市委改革办、市发改局、市经信局、市市监局、市工商联、市司法局、市委改革办、市发改局、市经信局、市市监局、市大数据管理中心、市财政局、市司法局、市市监局、市交通运输局、市经信局、市人社局、市委统战部、市经信局、市市监局、市工商联、市委社工部、市委宣传部、市公安局、市发改局、市统计局";
        String[] split = s.split("、");
        List<String> array = Arrays.asList(split);
        List<String> list = array.stream().map(ss -> ss.trim()).distinct().collect(Collectors.toList());
        System.out.println(list);
    }
}
