package com.itworker.controller;

import com.itworker.domain.BookBean;
import com.itworker.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * Created by GIOPPL
 * on 2020/11/19 12:26
 * TODO:书籍查询的Controller
 */
@Controller
@RequestMapping("/book")
public class BookQueryController {

    @Autowired
    private BookService bookService;

    /**
     * TODO:通过书名模糊查询
     */
    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public @ResponseBody List<BookBean> findByName(HttpServletRequest httpServletRequest) {
        String bookName = httpServletRequest.getParameter("bookName");
        String page = httpServletRequest.getParameter("page");
        return bookService.findByName(bookName,Integer.parseInt(page));
    }

    /**
     * TODO:通过Isbn查询
     */
    @RequestMapping(value = "/findByIsbn", method = RequestMethod.GET)
    public @ResponseBody List<BookBean> findByIsbn(HttpServletRequest httpServletRequest) {
        String isbn = httpServletRequest.getParameter("isbn");
        String page = httpServletRequest.getParameter("page");
        return bookService.findByIsbn(isbn,Integer.parseInt(page));
    }

    /**
     * TODO:查询一个用户的所有发布书籍
     */
    @RequestMapping(value = "/findAllUserBook", method = RequestMethod.GET)
    public @ResponseBody List<BookBean> findAllUserBook(HttpServletRequest httpServletRequest) {
        String user = httpServletRequest.getParameter("user");
        String page = httpServletRequest.getParameter("page");
        return bookService.findAllUserBook(user,Integer.parseInt(page));
    }



}
