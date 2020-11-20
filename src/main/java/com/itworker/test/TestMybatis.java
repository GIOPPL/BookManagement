package com.itworker.test;

import com.itworker.Constants;
import com.itworker.dao.BookDao;
import com.itworker.domain.BookBean;
import com.itworker.utils.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        Map<String,Object> param=new HashMap();
        param.put("page", (0)* Constants.PAGE_SIZE);
        param.put("page_size",Constants.PAGE_SIZE);
        param.put("book_name","%雅思%");
        List<BookBean> bookBeans = mapper.findByName(param);
        for (BookBean bookBean:bookBeans){
            System.out.println(bookBean.toString());
        }
        sqlSession.close();
    }
}
