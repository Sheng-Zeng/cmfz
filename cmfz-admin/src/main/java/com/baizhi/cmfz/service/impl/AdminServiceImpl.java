package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
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
        if (admin != null) {

            String password = DigestUtils.md5Hex(admin.getAdminSolt() + adminPassword);
            if (password.equals(admin.getAdminPwd())) {
                return admin;
            }
        }
        return null;
    }
}
