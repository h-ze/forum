package com.hz.forum.service.impl;

import com.hz.forum.dao.LogDAO;
import com.hz.forum.entity.Log;
import com.hz.forum.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2018/7/9 0009.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;

    @Override
    public int logAdd(Log log) {
        return logDAO.insert(log);
    }

    @Override
    /*@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)*/
    public Map<String, Object> findAll(int totalSize, int pageIndex) {
        List<Log> logList =logDAO.selectAll(totalSize*(pageIndex-1),totalSize);
        int i =logDAO.countLog();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",logList);
        return map;
    }

}
