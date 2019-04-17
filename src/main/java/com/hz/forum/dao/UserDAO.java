package com.hz.forum.dao;

import com.hz.forum.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public interface UserDAO {
    public List<User> selectAll(@Param("begin") int begin, @Param("showSize") int showSize, @Param("dim") String dim);

    public int countMaster(@Param("dim") String dim);

    public int insert(User user);

    public int update(User user);

    public User select(String userId);

    public int delete(User user);
    public List<User> downloadAll();

}
