package com.hz.forum.service;

import com.hz.forum.entity.Module;

import java.util.Map;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
public interface ModuleService {
    Map<String, Object> findAll(int pageSize, int pageIndex, String dim);

    Module find(String moduleId);

}
