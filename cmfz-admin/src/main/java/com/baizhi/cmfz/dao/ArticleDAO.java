package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;

/**
 * @program: cmfz
 * @description: 文章
 * @author: zs
 * @create: 2018-07-08 20:02
 **/

public interface ArticleDAO {
    
    /** 
    * @Description: 插入文章 
    * @Param: [article] 
    * @return: java.lang.Integer 
    * @Author: zs
    * @Date: 2018/7/8 
    */
    Integer insertArticle(Article article);
}
