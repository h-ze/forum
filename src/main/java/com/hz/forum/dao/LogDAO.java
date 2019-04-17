package com.hz.forum.dao;

import com.hz.forum.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public interface LogDAO {
    public int insert(Log log);

    public int countLog();

    public List<Log> selectAll(@Param("begin") int begin, @Param("showSize") int showSize);
}
