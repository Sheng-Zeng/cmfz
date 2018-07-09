package com.baizhi.cmfz.admin;

import com.baizhi.cmfz.dao.*;
import com.baizhi.cmfz.entity.*;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpSession;
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

}
