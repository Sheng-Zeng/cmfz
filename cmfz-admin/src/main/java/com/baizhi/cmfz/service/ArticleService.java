package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Article;

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
}
