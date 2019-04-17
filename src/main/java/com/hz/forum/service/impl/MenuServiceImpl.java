package com.hz.forum.service.impl;

import com.hz.forum.dao.MenuDAO;
import com.hz.forum.entity.Menu;
import com.hz.forum.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 11022 on 2019/3/6 0006.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO md;
    @Override
    public List<Menu> findAll(Integer menuParentId) {
        return md.selectAll(menuParentId);
    }
}
