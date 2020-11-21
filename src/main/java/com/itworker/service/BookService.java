package com.itworker.service;

import com.itworker.domain.BookBean;

import java.util.List;

/**
 * Created by GIOPPL
 * on 2020/11/19 12:26
 * TODO:书籍查询的接口
 */
public interface BookService {

    //查询
    public List<BookBean> findByIsbn(String isbn, int page);
    public List<BookBean> findByName(String bookName, int page);
    public List<BookBean> findAllUserBook(String user, int page);
    public List<BookBean> findAllUserLikeBook(String user, int page);

    //插入
    public void addBook(BookBean bookBean);

    /**
     * 插入我的收藏
     */
    public void addMyLike(int b_id,String user);

}
