package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @program: cmfz
 * @description: 主页面菜单栏
 * @author: zs
 * @create: 2018-07-05 10:23
 **/

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    /**
    * @Description: gold管理员
    * @Param: []
    * @return: java.lang.String
    * @Author: zs
    * @Date: 2018/7/5
    */
    @RequestMapping("/gold")
    public String getMenu(HttpServletRequest request) {
        List<Menu> menus = menuService.goldMenu();
        request.setAttribute("menus", menus);
        return "forward:/main/main.jsp";
    }


}
