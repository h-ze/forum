package com.hz.forum.service.impl;

import com.hz.forum.dao.ArticleDAO;
import com.hz.forum.entity.Article;
import com.hz.forum.entity.Module;
import com.hz.forum.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2019/3/4 0004.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDAO ad;

    @Override
    public Map<String, Object> findAll(int pageSize, int pageIndex, String dim) {
        if(dim != null){
            dim = "%"+dim+"%";
        }
        System.out.println(dim);
        List<Article> users = ad.selectAll((pageIndex-1)*pageSize,pageSize,dim);
        int i = ad.countArticle(dim);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",users);
        return map;
    }

    @Override
    public Article find(String articleId) {
        return ad.select(articleId);
    }

    @Override
    public int add(Article article) {
        return ad.insert(article);
    }

    @Override
    public int modify(Article article) {
        return ad.update(article);
    }

    @Override
    public int remove(Article article) {
        return ad.delete(article);
    }

}
