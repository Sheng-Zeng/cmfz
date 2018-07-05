package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:管理员的业务处理
 * @Author:zs
 * @Time:2018-07-04 14:48
 *
 */
public interface AdminDAO {

    /**
     * @Description 根据管理员名称查询管理员
     * @Author zs
     * @Time   2018-07-04 14::50
     * @Exception 无
     * @param adminName 将要查询的管理员的名称
     * @return 返回管理员
     */
    Admin findAdminByAdminName( String adminName);

}
