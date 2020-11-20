package com.itworker.service.impl;

import com.itworker.Constants;
import com.itworker.dao.BookDao;
import com.itworker.domain.BookBean;
import com.itworker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GIOPPL
 * on 2020/11/19 12:26
 * TODO:书籍查询的业务层
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public List<BookBean> findByIsbn(String isbn, int page) {
        Map<String,Object> param=new HashMap();
        param.put("page", (page-1)* Constants.PAGE_SIZE);
        param.put("pageSize",Constants.PAGE_SIZE);
        param.put("isbn",isbn);
        return bookDao.findByIsbn(param);
    }

    @Override
    public List<BookBean> findByName(String bookName, int page) {

        Map<String,Object> param=new HashMap();
        param.put("page", (page-1)* Constants.PAGE_SIZE);
        param.put("pageSize",Constants.PAGE_SIZE);
        param.put("bookName","%"+bookName+"%");
        return bookDao.findByName(param);
    }

    @Override
    public List<BookBean> findAllUserBook(String user, int page) {
        Map<String,Object> param=new HashMap();
        param.put("page", (page-1)* Constants.PAGE_SIZE);
        param.put("pageSize",Constants.PAGE_SIZE);
        param.put("user",user);
        return bookDao.findAllUserBook(param);
    }
}
