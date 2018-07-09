package com.baizhi.cmfz.service;

import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: zs
 * @create: 2018-07-09 20:13
 **/

public interface LogService {
    /**
    * @Description: 获取所有日志信息
    * @Param: [page, rows]
    * @return: java.util.Map<java.lang.String,java.lang.Object>
    * @Author: zs
    * @Date: 2018/7/9
    */
    Map<String,Object> queryAllLog( Integer page , Integer rows);

}
