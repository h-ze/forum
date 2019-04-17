package com.hz.forum.service.impl;

import com.hz.forum.dao.ManagerDAO;
import com.hz.forum.entity.Manager;
import com.hz.forum.entity.SysPermission;
import com.hz.forum.entity.SysRole;
import com.hz.forum.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 11022 on 2018/7/4 0004.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDAO md;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Manager find(String forumName, String forumPassword) {
        Manager manager = md.select(forumName);
        /*if (manager != null){
            String pwd = DigestUtils.md5Hex(forumPassword+manager.getForumSalt());
            System.out.println(pwd);
            if (manager.getForumPassword().equals(pwd)){
                return manager;
            }
        }*/

       return manager;
    }

    @Override
    public Manager findByName(String mgrName) {
        Manager manager =md.select(mgrName);
        if(manager != null){
            return manager;
        }else{
            return null;
        }

    }

    @Override
    public int modify(Manager manager) {
        return md.updateManager(manager);
    }

    /*@Override
    public List<SysRole> findRolesByUserName(String mgrName) {
        return md.findRolesByManager(mgrName);
    }

    @Override
    public List<SysPermission> findPermissionByUsername(String mgrName) {
        return md.findPermissionsByUsername(mgrName);
    }*/

    @Override
    public List<SysRole> findRolesByUserName(String mgrName) {
        return md.findRolesByManager(mgrName);
    }

    @Override
    public List<SysPermission> findPermissionByUsername(String mgrName) {
        return md.findPermissionsByUsername(mgrName);
    }
}
