package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 上师控制层
 * @author: zs
 * @create: 2018-07-06 19:30
 **/
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping("/add")
    @ResponseBody
    public String addPicture(HttpSession session, MultipartFile guruPicture, Guru guru) throws IOException {
        String realPath = session.getServletContext().getRealPath("/");
        int lastIndexOf = realPath.lastIndexOf("\\cmfz-admin");
        String uuidName = UUID.randomUUID().toString().replace("-","");
        guru.setGuruId(uuidName);
        String Newpath = realPath.substring(0,lastIndexOf) + "\\upload\\guru\\"+ guru.getGuruId();
        File file = new File(Newpath);
        System.out.println(Newpath);
        if (!file.exists()) {
            System.out.println("文件已创建！");
            file.mkdir();
        }
        String oldName = guruPicture.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        guruPicture.transferTo(new File(Newpath + "/" + uuidName + suffix));

        guru.setGuruPhoto(uuidName + suffix);
        int result = guruService.addGuru(guru);
        if (result > 0) {
            return "success";
        } else {
            return "error";
        }

    }

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String, Object> showAll(String name, String value, Integer page , Integer rows) {
        return guruService.queryGurus(name, value, page, rows);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Integer deleteGuru(String guruId) {
        return guruService.dropGuru(guruId);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modifyGuru(HttpSession session, MultipartFile guruPicture, Guru guru) throws IOException {
        if (!guruPicture.isEmpty() && guruPicture != null) {
            String realPath = session.getServletContext().getRealPath("/");
            int lastIndexOf = realPath.lastIndexOf("\\cmfz-admin");
            String Newpath = realPath.substring(0,lastIndexOf) +"\\upload\\guru\\"+ guru.getGuruId();
            File file = new File(Newpath);
            System.out.println(Newpath);
            if (!file.exists()) {
                System.out.println("文件已创建！");
                file.mkdir();
            }
            String uuidName = UUID.randomUUID().toString().replace("-","");
            String oldName = guruPicture.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));
            guruPicture.transferTo(new File(Newpath + "/" + uuidName + suffix));
            guru.setGuruPhoto(uuidName + suffix);
        }
        System.out.println(guru);
        int result = guruService.modifyGuru(guru);
        if (result > 0) {
            return "success";
        } else {
            return "error";
        }
    }


}
