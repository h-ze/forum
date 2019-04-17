package com.hz.forum.service.impl;

import com.hz.forum.dao.UserDAO;
import com.hz.forum.entity.User;
import com.hz.forum.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO us;
    @Override
    /*public List<User> findAll() {
        List<User> users = us.selectAll();
        return users;
    }*/

    public Map<String, Object> findAll(int pageSize, int pageIndex, String dim) {
        if(dim != null){
            dim = "%"+dim+"%";

        }
        System.out.println(dim);
        List<User> users = us.selectAll((pageIndex-1)*pageSize,pageSize,dim);
        int i = us.countMaster(dim);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",i);
        map.put("rows",users);
        return map;
    }

    @Override
    public User find(String userId) {
        return us.select(userId);
    }

    @Override
    public int add(User user) {
        return us.insert(user);
    }

    @Override
    public int modify(User user) {
        return us.update(user);
    }

    @Override
    public int remove(User user) {
        return us.delete(user);
    }

    @Override
    public List<User> downloadAll() {
        return us.downloadAll();
    }
}
