package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.util.VerifyCodeUtils;
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
    public String adminLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session, String adminName, String adminPwd, String enCode, String rember) {
        String vcode = (String) session.getAttribute("vercode");
        if (vcode!=null && vcode.equalsIgnoreCase(enCode)) {
            Admin admin = adminService.adminLogin(adminName,adminPwd);
            if (rember!=null && "true".equalsIgnoreCase(rember)) {
                String username = null;
                try {
                    username = URLEncoder.encode(adminName,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Cookie cookie = new Cookie("adminName",username);
                cookie.setMaxAge(60*60*24*7);
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }

            if (admin != null) {
                return "redirect:/main/main.jsp";
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
