package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * @program: cmfz
 * @description: Menu的数据操作
 * @author: zs
 * @create: 2018-07-05 10:24
 **/

public interface MenuDAO {
    /** 
    * @Description: 查询该管理员能操作的所有权限 
    * @Param: [] 
    * @return: java.util.List<com.baizhi.cmfz.entity.Menu> 
    * @Author: zs
    * @Date: 2018/7/5 
    */
    List<Menu> listMenu();

}
