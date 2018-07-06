package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDAO;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 轮播图
 * @author: zs
 * @create: 2018-07-05 22:49
 **/

@Service
@Transactional
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDAO pictureDAO;

    public Integer addPicture(Picture picture) {
        return pictureDAO.insertPicture(picture);
    }

    @Override
    public Map<String, Object> queryPicturs(Integer page, Integer single) {
        int begMes = (page-1) * single;
        List<Picture> pictures = pictureDAO.listPictures(begMes,single);
        int total = pictureDAO.getTotalMesage();
        Map<String, Object> mapEmps = new HashMap<String, Object>();
        mapEmps.put("total", total);
        mapEmps.put("rows", pictures);
        return mapEmps;
    }

    @Override
    public Integer modifyPicture(String pictureId, String pictureDescription, String pictureStatus) {
        return pictureDAO.updatePicture(pictureId,pictureDescription,pictureStatus);
    }
}
