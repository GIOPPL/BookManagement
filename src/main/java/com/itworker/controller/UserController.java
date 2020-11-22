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
 * TODO:用户的Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private BookService bookService;
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
