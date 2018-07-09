package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: cmfz
 * @description: 日志信息
 * @author: zs
 * @create: 2018-07-09 20:00
 **/

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> getLog(Integer page , Integer rows) {
        return logService.queryAllLog(page,rows);
    }
}
