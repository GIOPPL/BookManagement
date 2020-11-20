package com.itworker.service;

import com.itworker.domain.BookBean;

import java.util.List;

/**
 * Created by GIOPPL
 * on 2020/11/19 12:26
 * TODO:书籍查询的接口
 */
public interface BookService {

    public List<BookBean> findByIsbn(String isbn, int page);
    public List<BookBean> findByName(String bookName, int page);
    public List<BookBean> findAllUserBook(String user, int page);
}
