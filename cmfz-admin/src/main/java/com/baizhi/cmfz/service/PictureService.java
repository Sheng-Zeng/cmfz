package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * @program: cmfz
 * @description: 轮播图业务
 * @author: zs
 * @create: 2018-07-05 22:47
 **/

public interface PictureService {
    /**
    * @Description: 插入新图片
    * @Param: [picture]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/5
    */
    Integer addPicture(Picture picture);

    /** 
    * @Description: 查询轮播图 
    * @Param: [] 
    * @return: java.util.List<com.baizhi.cmfz.entity.RichTextResult.Picture>
    * @Author: zs
    * @Date: 2018/7/6 
    */
    Map<String, Object> queryPicturs(Integer page, Integer single);
    
    /** 
    * @Description: 修改图片信息 
    * @Param: [pictureId, pictureDescription, pictureStatus] 
    * @return: java.lang.Integer 
    * @Author: zs
    * @Date: 2018/7/6 
    */
    Integer modifyPicture(String pictureId, String pictureDescription, String pictureStatus);
}
