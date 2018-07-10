package com.baizhi.cmfz.admin;

import com.baizhi.cmfz.dao.*;
import com.baizhi.cmfz.entity.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AdminTest {


   
    @Test
    public void testLogin() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuDAO menuDAO = (MenuDAO) applicationContext.getBean("menuDAO");
        List<Menu> menus = menuDAO.listMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
            for (Menu menu1 : menu.getChildMenus()) {
                System.out.println(menu1);
            }
        }
    }

    @Test
    public void testPicture() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureDAO pictureDAO = (PictureDAO) applicationContext.getBean("pictureDAO");
        List<Picture> pictures = pictureDAO.listPictures(1,1);
        for (Picture picture : pictures) {
            System.out.println(picture);
        }
    }

    @Test
    public void testGuru() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        GuruDAO guruDAO = (GuruDAO) applicationContext.getBean("guruDAO");
        List<Guru> gurus = guruDAO.listGurus(null, null,0,5);
        for (Guru guru : gurus)  {
            System.out.println(guru);
        }
    }

    @Test
    public void testArticle() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ArticleDAO articleDAO = (ArticleDAO) applicationContext.getBean("articleDAO");
        List<Article> gurus = articleDAO.listArticle(null,0,5);
        for (Article guru : gurus)  {
            System.out.println(guru);
        }
    }

    @Test
    public void testLog() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LogDAO logDAO = (LogDAO) applicationContext.getBean("logDAO");
        List<LogMessage> logMessages = logDAO.listLogs(0,10);
        for (LogMessage logMessage : logMessages) {
            System.out.println(logMessage);
        }
    }

    @Test
    public void testShiro() {
        Realm realm = new JdbcRealm();

        // 初始化基于ini配置文件的安全管理工厂
        IniSecurityManagerFactory iniSecurityManagerFactory = new IniSecurityManagerFactory("classpath:shiro.ini");
        // 通过安全工厂创建安全管理器
        SecurityManager securityManager = iniSecurityManagerFactory.createInstance();
        // 对安全管理器初始化
        SecurityUtils.setSecurityManager(securityManager);
        // 获取当前访问系统的主体对象
        Subject subject = SecurityUtils.getSubject();

        // 认证
        AuthenticationToken authenticationToken = new UsernamePasswordToken("admin","a0c36e79de341654592ddb90b128a7a2");

        try {
            subject.login(authenticationToken);
            System.out.println("验证成功！");
        } catch (UnknownAccountException e) {
            System.err.println("用户不存在！");
        }   catch (IncorrectCredentialsException e) {
            System.err.println("密码错误！");
        }
    }

}
