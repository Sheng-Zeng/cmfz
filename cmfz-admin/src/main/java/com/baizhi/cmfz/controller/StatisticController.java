package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Agreement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 用户分布统计
 * @author: zs
 * @create: 2018-07-09 14:57
 **/

@Controller
@RequestMapping("/statistic")
public class StatisticController {

    @ResponseBody
    @RequestMapping("/agreement_Man")
    public List<Agreement> getAgreementMan() {
        List<Agreement> agreements = new ArrayList<Agreement>();
        agreements.add(new Agreement("北京","100"));
        agreements.add(new Agreement("天津","200"));
        agreements.add(new Agreement("青海","300"));
        agreements.add(new Agreement("西藏","400"));
        return agreements;
    }

    @ResponseBody
    @RequestMapping("/agreement_Woman")
    public List<Agreement> getAgreementWoman() {
        List<Agreement> agreements = new ArrayList<Agreement>();
        agreements.add(new Agreement("北京","200"));
        agreements.add(new Agreement("天津","230"));
        agreements.add(new Agreement("广西","300"));
        agreements.add(new Agreement("山西","400"));
        return agreements;
    }


    /*
    Map<String,Object> map = new HashMap<String,Object>();
    map.put("intervals",new String[]{"7天","15天"});
    map.put("counts",new int[]{5,10});'
    return map;

    [{"intervals":["7天","15天"]},{}]


    */

    @ResponseBody
    @RequestMapping("/analyze")
    public Map<String,Object> getAnalyze() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("intervals",new String[]{"7天","15天","30天","半年","一年"});
        map.put("counts",new int[]{5,10,20,30,40});
        return map;
    }

}
