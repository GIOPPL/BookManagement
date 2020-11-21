package com.itworker.dao;

import com.itworker.Constants;
import com.itworker.domain.BookBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by GIOPPL
 * on 2020/11/19 12:26
 * TODO:
 */

@Mapper
public interface BookDao {
    public List<BookBean> findByIsbn(Map<String,Object> param);
    public List<BookBean> findByName(Map<String,Object> param);
    public List<BookBean> findAllUserBook(Map<String,Object> param);
    public List<BookBean> findAllUserLikeBook(Map<String,Object> param);
    public void addBook(Map<String,Object> param);
    public void addMyLike(Map<String,Object> param);
}
