package com.tx.atguigu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 */
@Service()
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void insertUser() {
        userDao.insert();
//		otherDao.other();xxx
        System.out.println("插入完成...");
        int i = 10 / 0;
        System.out.println(i);
    }
}
