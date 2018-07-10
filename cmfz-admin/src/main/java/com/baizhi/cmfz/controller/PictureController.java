package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 轮播图
 * @author: zs
 * @create: 2018-07-05 21:14
 **/

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;


    @RequestMapping("/add")
    @ResponseBody
    public String addPicture(HttpSession session, MultipartFile picture, String desc, String dept) throws IOException {
        String realPath = session.getServletContext().getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\cmfz-admin");
        String Newpath = realPath.substring(0,lastIndexOf) + "\\upload";
        String uuidName = UUID.randomUUID().toString().replace("-","");
        String oldName = picture.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        picture.transferTo(new File(Newpath + "/" + uuidName + suffix));
        Picture pict = new Picture();
        pict.setPictureDate(new Date());
        pict.setPictureDescription(desc);
        pict.setPicturePath(uuidName + suffix);
        pict.setPictureStatus(dept);
        pict.setPictureId(uuidName);
        int result = pictureService.addPicture(pict);
        if (result > 0) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String, Object> showAllPicture(Integer page , Integer rows) {
        return pictureService.queryPicturs(page,rows);
    }

    @RequestMapping("/modifyPicture")
    @ResponseBody
    public Integer modifyPicture(String pictureId, String pictureDescription, String pictureStatus){
        System.out.println(pictureId + "  " + pictureDescription + " " + pictureStatus);
        return pictureService.modifyPicture(pictureId,pictureDescription,pictureStatus);
    }

}
