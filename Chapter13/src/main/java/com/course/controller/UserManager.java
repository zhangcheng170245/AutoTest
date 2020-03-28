package com.course.controller;

import com.course.model.Account;
import com.course.model.User;
import com.course.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * @Auther: zhangcheng
 * @Date: 2019/7/2 21:57
 * @Description:
 */

@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping("v1")
public class UserManager {

    @Autowired
    private SqlSessionTemplate template;


    @ApiOperation(value = "登陆接口", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user) {
        int i = template.selectOne("login", user);
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);

        if (i == 1) {
            return true;
        }

        return false;

    }
    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int result=0;
        if (x!=null){
            result=template.insert("adduser",user);

        }
        if(result>0){
            System.out.println("添加用户的数量是:"+result);
            return true;
        }
        return false;
    }

    //COOKIE验证方法
    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            System.out.println("cookies为空");
            return false;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                System.out.println("cookies验证通过");
                return true;
            }
        }
        return false;
    }
    @ApiOperation(value = "获取用户(列表)信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean x = verifyCookies(request);
        if(x==true){
            List<User> users = template.selectList("getUserInfo",user);
            System.out.println("getUserInfo获取到的用户数量是" +users.size());
            return users;
        }else {
            return null;
        }
    }


    @ApiOperation(value = "更新/删除用户接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int i = 0;
        if(x==true) {
            i = template.update("updateUserInfo", user);
        }
        System.out.println("更新数据的条目数为:" + i);
        return i;

    }


    private  AccountService  service;
    @ApiOperation(value = "获取账号信息",httpMethod = "POST")
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public Account getAccount( HttpServletRequest request, @PathVariable String id) {
        return service.getById(id);


    }


}
