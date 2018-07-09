package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Guru;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 上师业务层
 * @author: zs
 * @create: 2018-07-06 19:56
 **/

public interface GuruService {
    /**
     * @Description: 查询所有上师
     * @Param: []
     * @return: java.util.List<com.baizhi.cmfz.entity.RichTextResult.Picture>
     * @Author: zs
     * @Date: 2018/7/6
     */
    Map<String, Object> queryGurus(String name, String value, Integer page, Integer single);

    /**
    * @Description: 删除上师
    * @Param: [gurnId]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer dropGuru(String gurnId);

    /**
    * @Description: 修改上师
    * @Param: [guru]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer modifyGuru(Guru guru);

    /**
    * @Description: 新增上师
    * @Param: [guru]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer addGuru(Guru guru);
    
    /** 
    * @Description: 导出所有上师 
    * @Param: [] 
    * @return: java.util.List<com.baizhi.cmfz.entity.Guru> 
    * @Author: zs
    * @Date: 2018/7/7 
    */
    List<Guru> listGurns();
    
    /** 
    * @Description: 批量插入 
    * @Param: [gurus] 
    * @return: java.lang.Integer 
    * @Author: zs
    * @Date: 2018/7/8 
    */
    Integer addGurus(List<Guru> gurus);
    

}
