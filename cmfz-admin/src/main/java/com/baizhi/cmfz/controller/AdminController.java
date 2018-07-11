package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.VerifyCodeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String adminLogin(HttpSession session, String adminName, String adminPwd, String enCode, Boolean rember) {
        if (rember == null) {
           rember = false;
        }
        String vcode = (String) session.getAttribute("vercode");
        if (vcode!=null && vcode.equalsIgnoreCase(enCode)) {
            // 在web环境中安全管理器会自动进行初始化
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(adminName, adminPwd,rember);
            try {
                subject.login(token);
                session.setAttribute("adminName", adminName);
                return "redirect:/main/main.jsp";
            } catch (UnknownAccountException e) {
                System.err.println("用户不存在！");
                return "redirect:/main/login/login.jsp";
            }   catch (IncorrectCredentialsException e) {
                System.err.println("密码错误！");
                return "redirect:/main/login/login.jsp";
            }
        }
        return "redirect:/main/login/login.jsp";
    }

    @RequestMapping("/vcode")
    public String vcode(HttpServletResponse response, HttpSession session) {

        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpg");
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute("vercode",verifyCode.toLowerCase());
        int w = 100, h = 40;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
