package com.hz.forum.controller;

import com.hz.forum.entity.Menu;
import com.hz.forum.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuService ms;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Menu> findAll(Integer menuParentId){
        List<Menu> menuList = ms.findAll(menuParentId);
        return menuList;
    }
}
