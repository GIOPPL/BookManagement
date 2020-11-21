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

    @Override
    public List<BookBean> findAllUserLikeBook(String user, int page) {
        Map<String,Object> param=new HashMap();
        param.put("page", (page-1)* Constants.PAGE_SIZE);
        param.put("pageSize",Constants.PAGE_SIZE);
        param.put("user",user);
        return bookDao.findAllUserLikeBook(param);
    }

    @Override
    public void addBook(BookBean bookBean) {
        Map<String,Object> param=new HashMap();
        param.put("book_name",bookBean.getBook_name());
        param.put("author",bookBean.getAuthor());
        param.put("publisher",bookBean.getPublisher());
        param.put("publish_year",bookBean.getPublish_year());
        param.put("photo_url_1",bookBean.getPhoto_url_1());
        param.put("photo_url_2",bookBean.getPhoto_url_2());
        param.put("photo_url_3",bookBean.getPhoto_url_3());
        param.put("price",bookBean.getPrice());
        param.put("original_price",bookBean.getOriginal_price());
        param.put("classification",bookBean.getClassification());
        param.put("college",bookBean.getCollege());
        param.put("isbn",bookBean.getIsbn());
        param.put("user",bookBean.getUser());
        param.put("status",bookBean.getStatus());
        param.put("quantity",bookBean.getQuantity());
        param.put("grade",bookBean.getGrade());
        param.put("school_area",bookBean.getSchool_area());
        bookDao.addBook(param);
    }

    @Override
    public void addMyLike(int b_id, String user) {
        Map<String,Object> param=new HashMap();
        param.put("b_id",b_id);
        param.put("user",user);
        bookDao.addMyLike(param);
    }
}
