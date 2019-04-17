package com.hz.forum.utils;

import com.hz.forum.entity.Manager;
import com.hz.forum.entity.SysPermission;
import com.hz.forum.entity.SysRole;
import com.hz.forum.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;


/**
 * @author 11022
 */
public class MyRealm extends AuthorizingRealm {
 
    @Autowired
    private ManagerService managerService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo
            (PrincipalCollection principalCollection) {
        String username =(String)principalCollection.getPrimaryPrincipal();
        List<SysRole> roles =managerService.findRolesByUserName(username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole role:roles){
            info.addRole(role.getRoleTag());
        }
        List<SysPermission> permissionByUsername =
                managerService.findPermissionByUsername(username);
        for (SysPermission permission:permissionByUsername){
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        Manager manager = managerService.find(username,String.valueOf(password));
        /*Md5Hash md5Hash = new Md5Hash(password, manager.getForumSalt(), 1024);
        System.out.println(md5Hash);*/
        if (manager != null){
            return new SimpleAuthenticationInfo(manager.getForumName(),
                    manager.getForumPassword(),
                    ByteSource.Util.bytes(manager.getForumSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
