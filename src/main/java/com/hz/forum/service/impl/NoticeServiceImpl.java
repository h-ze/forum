package com.hz.forum.service.impl;

import com.hz.forum.dao.NoticeDAO;
import com.hz.forum.entity.Notice;
import com.hz.forum.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2019/3/7 0007.
 */
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDAO nd;
    @Override
    public Map<String, Object> findAll(int pageSize, int pageIndex, String dim) {
        if(dim != null){
            dim = "%"+dim+"%";
        }
        System.out.println(dim);
        List<Notice> users = nd.selectAll((pageIndex-1)*pageSize,pageSize,dim);
        int i = nd.countArticle(dim);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",users);
        return map;
    }

    @Override
    public Notice find(String noticeId) {
        return nd.select(noticeId);
    }

    @Override
    public int add(Notice notice) {
        return nd.insert(notice);
    }

    @Override
    public int modify(Notice notice) {
        return nd.update(notice);
    }

    @Override
    public int remove(Notice notice) {
        return nd.delete(notice);
    }
}
