package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @program: cmfz
 * @description: Menu的Service业务层
 * @author: zs
 * @create: 2018-07-05 11:26
 **/

public interface MenuService {

    /**
    * @Description: 上帝管理员的权限
    * @Param: []
    * @return: java.util.List<com.baizhi.cmfz.entity.Menu>
    * @Author: zs
    * @Date: 2018/7/5
    */
    List<Menu> goldMenu();
}
