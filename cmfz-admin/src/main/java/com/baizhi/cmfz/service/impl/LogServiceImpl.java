package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDAO;

import com.baizhi.cmfz.entity.LogMessage;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description:
 * @author: zs
 * @create: 2018-07-09 20:15
 **/
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;

    public Map<String, Object> queryAllLog(Integer page, Integer single) {
        int begMes = (page-1) * single;
        List<LogMessage> logs = logDAO.listLogs(begMes,single);
        int total = logDAO.getTotalMesage();
        Map<String, Object> mapEmps = new HashMap<String, Object>();
        mapEmps.put("total", total);
        mapEmps.put("rows", logs);
        return mapEmps;
    }
}
