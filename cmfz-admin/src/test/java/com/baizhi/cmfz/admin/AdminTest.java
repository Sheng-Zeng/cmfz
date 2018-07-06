package com.baizhi.cmfz.admin;

import com.baizhi.cmfz.dao.AdminDAO;
import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.dao.PictureDAO;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.impl.AdminServiceImpl;
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
}
