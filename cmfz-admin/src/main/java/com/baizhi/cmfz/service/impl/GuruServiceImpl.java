package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.GuruDAO;
import com.baizhi.cmfz.entity.Guru;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: cmfz
 * @description: 上师业务
 * @author: zs
 * @create: 2018-07-06 19:59
 **/
@Service
@Transactional
public class GuruServiceImpl implements GuruService {

    @Autowired
    private GuruDAO guruDAO;

    public Map<String, Object> queryGurus(String name, String value, Integer page, Integer single) {
        int begMes = (page-1) * single;
        List<Guru> pictures = guruDAO.listGurus(name, value, begMes,single);
        int total = guruDAO.getTotalMesage(name,value);
        Map<String, Object> mapEmps = new HashMap<String, Object>();
        mapEmps.put("total", total);
        mapEmps.put("rows", pictures);
        return mapEmps;
    }

    @Override
    public Integer dropGuru(String gurnId) {
        return guruDAO.deleteGuru(gurnId);
    }

    @Override
    public Integer modifyGuru(Guru guru) {
        return guruDAO.updateGuru(guru);
    }

    @Override
    public Integer addGuru(Guru guru) {
        return guruDAO.insertGuru(guru);
    }

    @Override
    public List<Guru> listGurns() {
        List<Guru> gurus = guruDAO.listGurus(null,null,0,guruDAO.getTotalMesage(null,null));
        return gurus;
    }
}
