package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;

/**
 * @program: 日志信息
 * @description:
 * @author: zs
 * @create: 2018-07-09 19:49
 **/

public interface LogDAO {

    /**
    * @Description: 日志信息插入数据库
    * @Param: [log]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/9
    */
    Integer inserLog(Log log);

}
