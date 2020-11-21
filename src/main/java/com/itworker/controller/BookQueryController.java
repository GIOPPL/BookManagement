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
    public @ResponseBody
    List<BookBean> findByName(HttpServletRequest httpServletRequest) {
        String bookName = httpServletRequest.getParameter("bookName");
        String page = httpServletRequest.getParameter("page");
        return bookService.findByName(bookName, Integer.parseInt(page));
    }

    /**
     * TODO:通过Isbn查询
     */
    @RequestMapping(value = "/findByIsbn", method = RequestMethod.GET)
    public @ResponseBody
    List<BookBean> findByIsbn(HttpServletRequest httpServletRequest) {
        String isbn = httpServletRequest.getParameter("isbn");
        String page = httpServletRequest.getParameter("page");
        return bookService.findByIsbn(isbn, Integer.parseInt(page));
    }

    /**
     * TODO:查询一个用户的所有发布书籍
     */
    @RequestMapping(value = "/findAllUserBook", method = RequestMethod.GET)
    public @ResponseBody
    List<BookBean> findAllUserBook(HttpServletRequest httpServletRequest) {
        String user = httpServletRequest.getParameter("user");
        String page = httpServletRequest.getParameter("page");
        return bookService.findAllUserBook(user, Integer.parseInt(page));
    }
    /**
     * TODO:查询一个用户的所有收藏的书籍
     */
    @RequestMapping(value = "/findAllUserLikeBook", method = RequestMethod.GET)
    public @ResponseBody
    List<BookBean> findAllUserLikeBook(HttpServletRequest httpServletRequest) {
        String user = httpServletRequest.getParameter("user");
        String page = httpServletRequest.getParameter("page");
        return bookService.findAllUserLikeBook(user, Integer.parseInt(page));
    }


    /**
     * TODO:插入一本书
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public @ResponseBody
    String addBook(HttpServletRequest httpServletRequest) {
        String book_name = httpServletRequest.getParameter("book_name");
        String author = httpServletRequest.getParameter("author");
        String publisher = httpServletRequest.getParameter("publisher");
        String publish_year = httpServletRequest.getParameter("publish_year");
        String photo_url_1 = httpServletRequest.getParameter("photo_url_1");
        String photo_url_2 = httpServletRequest.getParameter("photo_url_2");
        String photo_url_3 = httpServletRequest.getParameter("photo_url_3");
        String isbn = httpServletRequest.getParameter("isbn");
        String user = httpServletRequest.getParameter("user");
        String priceString = httpServletRequest.getParameter("price");
        float price;
        if (priceString.isEmpty()){
            price=0;
        }else {
            price = Float.parseFloat(priceString);
        }
        String originalPriceString = httpServletRequest.getParameter("original_price");
        float original_price;
        if (originalPriceString.isEmpty()){
            original_price=0;
        }else {
            original_price = Float.parseFloat(originalPriceString);
        }
        String classificationString = httpServletRequest.getParameter("classification");
        int classification;
        if (classificationString.isEmpty()){
            classification=0;
        }else {
            classification = Integer.parseInt(classificationString);
        }
        String collegeString = httpServletRequest.getParameter("college");
        int college;
        if (collegeString.isEmpty()){
            college=0;
        }else {
            college = Integer.parseInt(collegeString);
        }
        String statusString = httpServletRequest.getParameter("status");
        int status;
        if (statusString.isEmpty()){
            status=0;
        }else {
            status = Integer.parseInt(statusString);
        }
        String quantityString = httpServletRequest.getParameter("quantity");
        int quantity;
        if (quantityString.isEmpty()){
            quantity=0;
        }else {
            quantity = Integer.parseInt(quantityString);
        }
        String gradeString = httpServletRequest.getParameter("grade");
        int grade;
        if (gradeString.isEmpty()){
            grade=0;
        }else {
            grade = Integer.parseInt(gradeString);
        }
        String schoolAreaString = httpServletRequest.getParameter("school_area");
        int school_area;
        if (schoolAreaString.isEmpty()){
            school_area=0;
        }else {
            school_area = Integer.parseInt(schoolAreaString);
        }
        BookBean bookBean=new BookBean(0,book_name,author,publisher,publish_year,photo_url_1,photo_url_2,
                photo_url_3,price,original_price,classification,college,isbn,user,status,quantity,grade,school_area);
        System.out.println(bookBean.toString());
        bookService.addBook(bookBean);
        return "插入成功";
    }


    /**
     * TODO:插入一本书
     */
    @RequestMapping(value = "/addMyLike", method = RequestMethod.GET)
    public @ResponseBody
    String addMyLike(HttpServletRequest httpServletRequest) {
        String b_id = httpServletRequest.getParameter("b_id");
        String user = httpServletRequest.getParameter("user");
        bookService.addMyLike(Integer.parseInt(b_id),user);
        return "插入成功";
    }
}
