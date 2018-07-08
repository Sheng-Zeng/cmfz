package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Author;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.RichTextResult;
import com.baizhi.cmfz.service.ArticleService;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 文章
 * @author: zs
 * @create: 2018-07-08 17:30
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private GuruService guruService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/guru")
    @ResponseBody
    public List<Author> getGuru() {
        List<Author> authors = new ArrayList<Author>();

        List<Guru> gurus = guruService.listGurns();
        for (Guru guru : gurus) {
            authors.add(new Author(guru.getGuruId(),guru.getGuruName()));
        }
        return authors;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String createArticle(Article article) {
        int result =  articleService.addArticle(article);
        if (result > 0) {
            return "success";
        } else {
            return "error";
        }

    }

    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files")MultipartFile[] files, HttpServletRequest request) throws IOException {
        RichTextResult result = new RichTextResult();
        if(files != null && files.length != 0) {
            List<String> strings = new ArrayList<String>();
            String realPath = request.getSession().getServletContext().getRealPath("/");
            int lastIndexOf = realPath.lastIndexOf("\\cmfz-admin");
            String Newpath = realPath.substring(0,lastIndexOf) + "\\upload\\article";
            String uuidName = UUID.randomUUID().toString().replace("-","");
            for (MultipartFile file : files) {
                String oldName = file.getOriginalFilename();
                String suffix = oldName.substring(oldName.lastIndexOf("."));
                file.transferTo(new File(Newpath + "/" + uuidName + suffix));
                strings.add(request.getContextPath()+"/upload/article/" + uuidName + suffix);
            }
            result.setErrno(0);
            result.setData(strings);
        } else {
            result.setErrno(1);
        }
        return result;
    }
}
