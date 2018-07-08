package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDAO;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

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

    @Override
    public Integer addArticle(Article article) {
        String uuidName = UUID.randomUUID().toString().replace("-","");
        article.setArticleId(uuidName);
        article.setArticleDate(new Date());
        return articleDAO.insertArticle(article);
    }
}
