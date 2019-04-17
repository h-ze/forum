package com.hz.forum.service;

import com.hz.forum.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
public interface UserService {
    Map<String, Object> findAll(int pageSize, int pageIndex, String dim);

    User find(String userId);

    int add(User user);

    int modify(User user);

    int remove(User user);

    List<User> downloadAll();
}
