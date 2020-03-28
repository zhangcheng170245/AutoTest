package com.course.service;

import com.course.model.Account;
import org.springframework.stereotype.Service;

/**
 * @Auther: zhangcheng
 * @Date: 2020/1/5 11:45
 * @Description:
 */
@Service
public class AccountService {
    public Account getById(String id){
        return  new Account(id,"121","332");
    }




}
