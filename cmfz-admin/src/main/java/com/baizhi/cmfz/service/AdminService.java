package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
/**
 * @Description:管理员的业务处理
 * @Author:zs
 * @Time:2018-07-04 14:55
 *
 */
public interface AdminService {

    /**
     * @Description 管理员的登录
     * @Author zs
     * @Time   2018-07-04 14::57
     * @Exception 无
     * @param adminName 管理员名称
     * @param adminPassword 管理员密码
     * @return 返回管理员
     */
    Admin adminLogin(String adminName, String adminPassword);
}
