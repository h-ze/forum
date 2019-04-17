package com.hz.forum.service;

import com.hz.forum.entity.Menu;

import java.util.List;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
public interface MenuService {
    List<Menu> findAll(Integer menuParentId);
}
