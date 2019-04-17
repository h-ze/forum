package com.hz.forum.service;

import com.hz.forum.entity.Notice;

import java.util.Map;

/**
 * Created by 11022 on 2019/3/7 0007.
 */
public interface NoticeService {
    Map<String, Object> findAll(int pageSize, int pageIndex, String dim);

    Notice find(String noticeId);

    int add(Notice notice);

    int modify(Notice notice);

    int remove(Notice notice);
}
