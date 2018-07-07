package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Guru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 上师信息
 * @author: zs
 * @create: 2018-07-06 19:38
 **/

public interface GuruDAO {

    /**
    * @Description: 通过分页获取所有上师信息
    * @Param: [begin, size]
    * @return: java.util.List<com.baizhi.cmfz.entity.Guru>
    * @Author: zs
    * @Date: 2018/7/6
    */
    List<Guru> listGurus(@Param("name") String name, @Param("value") String value, @Param("begin") Integer begin, @Param("size") Integer size);

    /**
    * @Description: 获取上师个数
    * @Param: []
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer getTotalMesage( @Param("name") String name,@Param("value")String value);

    /**
    * @Description: 添加上师
    * @Param: [guru]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer insertGuru(Guru guru);

    /**
    * @Description: 删除上师
    * @Param:
    * @return:
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer deleteGuru(@Param("guruId") String guruId);

    /**
    * @Description: 修改上师
    * @Param: [gurn]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer updateGuru(Guru guru);
}
