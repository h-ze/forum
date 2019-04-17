package com.hz.forum.dao;

import com.hz.forum.entity.Menu;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public interface MenuDAO {
    List<Menu> selectAll(Integer menuParentId);
}
