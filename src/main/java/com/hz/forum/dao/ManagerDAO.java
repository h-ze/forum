package com.hz.forum.dao;

import com.hz.forum.entity.Manager;
import com.hz.forum.entity.SysPermission;
import com.hz.forum.entity.SysRole;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public interface ManagerDAO {
    public Manager select(String mgrName);

    public Manager findByManagername(String mgrName);

    public int updateManager(Manager manager);

    public List<SysRole> findRolesByManager(String mgrName);

    public List<SysPermission> findPermissionsByUsername(String mgrName);

}
