package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    
    /** 
    * @Description: 获取所有文章 
    * @Param: [begin, size] 
    * @return: java.util.List<com.baizhi.cmfz.entity.Article> 
    * @Author: zs
    * @Date: 2018/7/8 
    */
    List<Article> listArticle(@Param("articleId") String articleID, @Param("begin") Integer begin, @Param("size") Integer size);

    /** 
    * @Description: 获取文章总数 
    * @Param: [] 
    * @return: java.lang.Integer 
    * @Author: zs
    * @Date: 2018/7/8 
    */
    Integer getTotalMesage();
}
