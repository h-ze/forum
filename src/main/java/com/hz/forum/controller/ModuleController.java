package com.hz.forum.controller;

import com.hz.forum.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
@Controller
@RequestMapping("module")
public class ModuleController {

    @Autowired
    private ModuleService ms;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> queryMaster(@RequestParam("rows") int totalSize, @RequestParam("page") int pageIndex, String articleName){
        System.out.println(articleName);
        return ms.findAll(totalSize,pageIndex,articleName);

    }
}
