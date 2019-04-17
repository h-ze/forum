package com.hz.forum.controller;

import com.hz.forum.entity.Article;
import com.hz.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService as;

    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String,Object> queryMaster(@RequestParam("rows") int totalSize, @RequestParam("page") int pageIndex, String articleName){
        System.out.println(articleName);
        return as.findAll(totalSize,pageIndex,articleName);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(String articleName,String articleAuthor){
        String uuid = UUID.randomUUID().toString().replace("-","");
        Article article = new Article(uuid,articleName,articleAuthor,new Date());

        int add = as.add(article);
        if (add != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modify(String articleId,String moduleStatus){
        Article article = as.find(articleId);
        if (article != null){
            int modify = as.modify(article);
            System.out.println(modify);
            if (modify != 0){
                return "success";
            }
        }
        return "fail";
    }

    @RequestMapping("remove")
    @ResponseBody
    public String remove(String articleId){
        Article article = as.find(articleId);
        if (article!= null){
            int remove = as.remove(article);
            if (remove!= 0){
                return "success";
            }
        }
        return "fail";
    }
}
