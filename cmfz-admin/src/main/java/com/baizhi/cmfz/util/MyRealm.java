package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.dao.GuruDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: cmfz
 * @description: 自定义数据源类
 * @author: zs
 * @create: 2018-07-10 17:06
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminDAO adminDAO;

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
       // ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
       // AdminDAO adminDAO = (AdminDAO) applicationContext.getBean("adminDAO");
        System.out.println(adminDAO);
        Admin admin = adminDAO.findAdminByAdminName(upToken.getUsername());
        System.out.println(upToken.getUsername());
        System.out.println(admin);
        if (admin != null) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin.getAdminName(),admin.getAdminPwd(), ByteSource.Util.bytes(admin.getAdminSolt()),admin.getAdminId() );
            return simpleAuthenticationInfo;
        }
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();

        return null;
    }
}
