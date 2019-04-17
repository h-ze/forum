package com.hz.forum.dao;

import com.hz.forum.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public interface NoticeDAO {
    public List<Notice> selectAll(@Param("begin") int begin, @Param("showSize") int showSize, @Param("dim") String dim);

    public int countArticle(@Param("dim") String dim);

    public int insert(Notice notice);

    public int update(Notice notice);

    public Notice select(String noticeId);

    public int delete(Notice notice);
}
