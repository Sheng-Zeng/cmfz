package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: cmfz
 * @description: 轮播图
 * @author: zs
 * @create: 2018-07-05 22:42
 **/

public interface PictureDAO {

    /**
    * @Description: 插入轮播图
    * @Param: [picture]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/5
    */
    Integer insertPicture(Picture picture);

    /**
    * @Description: 获取所有的轮播图
    * @Param: []
    * @return: java.util.List<com.baizhi.cmfz.entity.Picture>
    * @Author: zs
    * @Date: 2018/7/6
    */
    List<Picture> listPictures(@Param("begin") Integer begin , @Param("size") Integer size);

    /**
    * @Description: 获取总信息数
    * @Param: []
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer getTotalMesage();

    /**
    * @Description: 修改图片的信息
    * @Param: [pictureId, pictureDescription, pictureStatus]
    * @return: java.lang.Integer
    * @Author: zs
    * @Date: 2018/7/6
    */
    Integer updatePicture(@Param("pictureId") String pictureId, @Param("pictureDescription") String pictureDescription,@Param("pictureStatus") String pictureStatus);
}
