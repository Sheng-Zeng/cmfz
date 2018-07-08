package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: cmfz
 * @description: 文章业务实现
 * @author: zs
 * @create: 2018-07-08 20:04
 **/

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public Integer addArticle(Article article) {
        String uuidName = UUID.randomUUID().toString().replace("-","");
        article.setArticleId(uuidName);
        article.setArticleDate(new Date());
        return articleDAO.insertArticle(article);
    }

    public Map<String, Object> queryArticle(Integer page, Integer single) {
        System.out.println(page+"  "+single);
        int begMes = (page-1) * single;
        String id = null;
        List<Article> articles = articleDAO.listArticle(id,begMes,single);
        for (Article article : articles) {
            System.out.println(article);
        }
        int total = articleDAO.getTotalMesage();
        Map<String, Object> mapEmps = new HashMap<String, Object>();
        mapEmps.put("total", total);
        mapEmps.put("rows", articles);
        return mapEmps;
    }

    public Article queryArtice(String aticleId) {
        List<Article> articles = articleDAO.listArticle(aticleId, 0 , 5);
        return articles.get(0);
    }
}
