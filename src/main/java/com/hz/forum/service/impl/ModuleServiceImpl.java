package com.hz.forum.service.impl;

import com.hz.forum.dao.ModuleDAO;
import com.hz.forum.entity.Article;
import com.hz.forum.entity.Module;
import com.hz.forum.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
    @Autowired
    private ModuleDAO md;
    @Override
    public Map<String, Object> findAll(int pageSize, int pageIndex, String dim) {
        if(dim != null){
            dim = "%"+dim+"%";
        }
        List<Module> users = md.selectAll((pageIndex-1)*pageSize,pageSize,dim);
        int i = md.countArticle(dim);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",users);
        return map;
    }

    @Override
    public Module find(String moduleId) {
        return null;
    }
}
