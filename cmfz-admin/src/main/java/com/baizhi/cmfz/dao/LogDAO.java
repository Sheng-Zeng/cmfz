package com.baizhi.cmfz.dao;


import com.baizhi.cmfz.entity.LogMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


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
    Integer inserLog(LogMessage log);

    /**
    * @Description: 获取所有日志
    * @Param: [begin, size]
    * @return: java.util.List<com.baizhi.cmfz.entity.Log>
    * @Author: zs
    * @Date: 2018/7/9
    */
    List<LogMessage> listLogs(@Param("begin") Integer begin, @Param("size") Integer size);

    /**
    * @Description:
    * @Param: []
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/9
    */
    Integer getTotalMesage();

}
