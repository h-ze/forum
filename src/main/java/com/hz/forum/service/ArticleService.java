package com.hz.forum.service;

import com.hz.forum.entity.Article;

import java.util.Map;

/**
 * Created by 11022 on 2019/3/4 0004.
 */
public interface ArticleService {
    Map<String, Object> findAll(int pageSize, int pageIndex, String dim);

    Article find(String moduleId);

    int add(Article article);

    int modify(Article article);

    int remove(Article article);
}
