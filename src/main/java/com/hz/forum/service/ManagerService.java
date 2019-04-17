package com.hz.forum.service;


import com.hz.forum.entity.Manager;
import com.hz.forum.entity.SysPermission;
import com.hz.forum.entity.SysRole;

import java.util.List;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
public interface ManagerService {
    public Manager find(String forumName, String forumPassword);

    public Manager findByName(String forumName);

    public int modify(Manager manager);

    /*public List<SysRole> findRolesByUserName(String mgrName);

    public List<SysPermission> findPermissionByUsername(String mgrName);*/

    public List<SysRole> findRolesByUserName(String mgrName);

    public List<SysPermission> findPermissionByUsername(String mgrName);

}
