package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cmfz
 * @description: MenuService实现
 * @author: zs
 * @create: 2018-07-05 11:28
 **/
@Service
@Transactional
public class MenuServcieImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;


    public List<Menu> goldMenu() {
        return menuDAO.listMenu();
    }
}
