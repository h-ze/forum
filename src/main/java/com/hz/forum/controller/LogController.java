package com.hz.forum.controller;

import com.hz.forum.service.LogService;
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
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> queryLog(@RequestParam("rows")int totalSize, @RequestParam("page")int pageIndex){
        System.out.println(logService.findAll(totalSize,pageIndex));
        return logService.findAll(totalSize,pageIndex);
    }

}
