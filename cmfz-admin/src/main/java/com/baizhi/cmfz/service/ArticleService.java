package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 文章业务
 * @author: zs
 * @create: 2018-07-08 20:03
 **/

public interface ArticleService {
    
    /** 
    * @Description: 插入一个新的文章 
    * @Param: [article] 
    * @return: java.lang.Integer 
    * @Author: zs
    * @Date: 2018/7/8 
    */
    Integer addArticle(Article article);

    /**
    * @Description: 查询所有文章的复用
    * @Param: [aticleId, page, single]
    * @return: java.util.List<com.baizhi.cmfz.entity.Article>
    * @Author: zs
    * @Date: 2018/7/8
    */
    Map<String, Object> queryArticle(Integer page, Integer single);

    /**
    * @Description: 查询单个文章的内容
    * @Param: [aticleId]
    * @return: com.baizhi.cmfz.entity.Article
    * @Author: zs
    * @Date: 2018/7/8
    */
    Article queryArtice(String aticleId);
}
