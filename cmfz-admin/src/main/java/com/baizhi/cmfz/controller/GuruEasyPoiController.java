package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import com.baizhi.cmfz.dao.GuruDAO;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.service.GuruService;
import com.baizhi.cmfz.util.GuruExcelHandler;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @program: cmfz
 * @description: 上师批量上传表
 * @author: zs
 * @create: 2018-07-07 15:21
 **/

@RequestMapping("/easypoi")
@Controller
public class GuruEasyPoiController {

    private static final Logger log = LoggerFactory.getLogger(GuruEasyPoiController.class);

    @Autowired
    private GuruService guruService;


    @RequestMapping("/excelImport")
    @ResponseBody
    public String excelImport(MultipartFile file) {
        int resultTotal = 1;
        ImportParams importParams = new ImportParams();

        // 数据处理
        IExcelDataHandler<Guru> handler = new GuruExcelHandler();
        // 对应Excel表格的列名 ，也是实体类对象上指定的列名
        handler.setNeedHandlerFields(new String[]{"姓名"});

        // 需要验证
        importParams.setDataHandler(handler);

        try {
            ExcelImportResult<Guru> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Guru.class, importParams);
            List<Guru> successList = result.getList();
            List<Guru> failList = result.getFailList();
            log.info("是否存在验证未通过的数据：" + result.isVerfiyFail());
            log.info("验证通过的数量" + successList.size());
            log.info("验证未通过的数量" + failList.size());

            for (Guru guru : successList) {
                log.info("成功列表信息：" + guru);
            }

            for (Guru guru : successList) {

                String uuidName = UUID.randomUUID().toString().replace("-", "");
                guru.setGuruId(uuidName);
                int judge = guruService.addGuru(guru);
                if (judge == 0) {
                    resultTotal = 0;
                }
            }

            for (Guru guru : failList) {
                log.info("失败列表信息：" + guru);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        if (resultTotal == 1) {
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        try {
            // 设置响应输出的头类型
            response.setHeader("content-Type", "application/vnd.ms-excel");
            // 下载文件的默认名称
            response.setHeader("Content-Disposition", "attachment;filename=gurus.xls");
            // =========easypoi部分
            response.setCharacterEncoding("UTF-8");
            ExportParams exportParams = new ExportParams("上师信息表","上师");
            List<Guru> gurus = guruService.listGurns();
            // exportParams.setDataHanlder(null);//和导入一样可以设置一个handler来处理特殊数据
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, Guru.class, gurus);
            workbook.write(response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /***
     * 创建模拟数据
     *
     * @return
     */
}


