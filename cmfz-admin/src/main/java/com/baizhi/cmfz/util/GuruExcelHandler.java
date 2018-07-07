package com.baizhi.cmfz.util;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.baizhi.cmfz.entity.Guru;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @program: cmfz
 * @description: 上师批量插入
 * @author: zs
 * @create: 2018-07-07 14:52
 **/

public class GuruExcelHandler extends ExcelDataHandlerDefaultImpl<Guru> {

    private static final Logger log = LoggerFactory.getLogger(GuruExcelHandler.class);

    @Override
    public Object importHandler(Guru obj, String name, Object value) {
        log.info(name + ":" + value);
        return super.importHandler(obj, name, value);
    }
}
