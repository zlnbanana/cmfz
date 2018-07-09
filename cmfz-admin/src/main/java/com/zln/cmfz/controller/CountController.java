package com.zln.cmfz.controller;

import com.zln.cmfz.entity.Echarts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhanglijiao on 2018/7/9.
 */
@Controller
@RequestMapping("/echarts")
public class CountController {

        @RequestMapping("/activeUser")
        @ResponseBody
        public Map<String, Object> getEchartsPic(){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("intervals",new String[]{"1天","3天","7天","10天","15天"});
            map.put("counts",new int[]{5,10,18,15,3});
            return map;
        }

        @RequestMapping("/distribution1")
        @ResponseBody
        public List<Echarts> getEcharts(){
            List<Echarts> list= new ArrayList<Echarts>();
            list.add(new Echarts("北京","100"));
            list.add(new Echarts("上海","200"));
            list.add(new Echarts("河北","300"));
            list.add(new Echarts("云南","200"));
            list.add(new Echarts("黑龙江","700"));
            list.add(new Echarts("安徽","500"));
            list.add(new Echarts("新疆","900"));
            list.add(new Echarts("浙江","1000"));
            list.add(new Echarts("湖北","150"));
            list.add(new Echarts("甘肃","190"));
            list.add(new Echarts("内蒙古","300"));
            list.add(new Echarts("吉林","600"));
            list.add(new Echarts("贵州","200"));
            list.add(new Echarts("青海","700"));
            list.add(new Echarts("四川","300"));
            list.add(new Echarts("海南","500"));
            list.add(new Echarts("香港","800"));
            list.add(new Echarts("澳门","100"));
            list.add(new Echarts("台湾","550"));
            list.add(new Echarts("宁夏","770"));
            list.add(new Echarts("天津","100"));
            list.add(new Echarts("重庆","430"));
            list.add(new Echarts("河南","2000"));
            list.add(new Echarts("辽宁","3000"));
            list.add(new Echarts("湖南","1000"));
            list.add(new Echarts("山东","2020"));
            list.add(new Echarts("江苏","800"));
            list.add(new Echarts("江西","102"));
            list.add(new Echarts("广西","134"));
            list.add(new Echarts("山西","256"));
            list.add(new Echarts("陕西","654"));
            list.add(new Echarts("福建","764"));
            list.add(new Echarts("广东","234"));
            list.add(new Echarts("西藏","543"));

            return list;
        }

        @RequestMapping("/distribution2")
        @ResponseBody
        public List<Echarts> distributeWomen(){
            List<Echarts> list= new ArrayList<Echarts>();
            ;
            list.add(new Echarts("北京",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("上海",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("河北",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("云南",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("黑龙江",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("安徽",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("新疆",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("浙江",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("湖北",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("甘肃",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("内蒙古",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("吉林",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("贵州",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("青海",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("四川",String.valueOf((int)(Math.random()*1000))));
            list.add(new Echarts("海南",String.valueOf((int)(Math.random()*1000))));
            return list;
        }

}
