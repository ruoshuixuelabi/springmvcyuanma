package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.dao.BookDao;

/**
 * @author Administrator
 */
@Service
public class BookService {
    //@Qualifier("bookDao")
    @Autowired(required = false)
    //@Resource(name="bookDao2")
//	@Inject
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
