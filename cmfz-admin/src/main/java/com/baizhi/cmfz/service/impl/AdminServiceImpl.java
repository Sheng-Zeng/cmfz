package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;


    public Admin adminLogin(String adminName, String adminPassword) {
        Admin admin = adminDAO.findAdminByAdminName(adminName);
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 通过安全工厂创建安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.createInstance();
        // 对安全管理器初始化
        SecurityUtils.setSecurityManager(securityManager);
        // 获取当前访问系统的主体对象
        Subject subject = SecurityUtils.getSubject();

        // 认证
        AuthenticationToken authenticationToken = new UsernamePasswordToken(adminName,adminPassword);

        try {
            subject.login(authenticationToken);
            System.out.println("验证成功！");
            return admin;
        } catch (UnknownAccountException e) {
            System.err.println("用户不存在！");
        }   catch (IncorrectCredentialsException e) {
            System.err.println("密码错误！");
        }
        return null;
    }

}
