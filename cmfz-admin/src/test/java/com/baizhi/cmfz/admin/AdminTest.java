package com.baizhi.cmfz.admin;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminTest {

    @Test
    public void testLogin() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AdminDAO adminDAO = (AdminDAO) applicationContext.getBean("adminDAO");
        Admin admin = adminDAO.findAdminByAdminName("admin");
        System.out.println(admin);
    }
}
