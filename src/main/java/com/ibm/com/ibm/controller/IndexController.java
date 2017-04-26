package com.ibm.com.ibm.controller;

import com.ibm.com.ibm.model.Result;
import com.ibm.com.ibm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhouhaoyan on 2017/4/26.
 */
@Controller
public class IndexController {

    @Value("${user.userServerPath}")
    private String url;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/user")
    public ModelAndView getUserById(){
      // String name="user/findpage?pageNum=1&pageSize=10";
        String name="user";
        ModelAndView model=new ModelAndView();
        System.out.println(this.url+name);

        /**
         * 新增用户
         * post:  user  http://url/user
         */

/*
        User user=new User();
        user.setUserName("小花");

        ResponseEntity<Result> resBody=this.restTemplate.postForEntity(this.url+"user",user,Result.class);
        Result res= resBody.getBody();*/

        /**
         * 查询所有用户
         * getForObject:   http://url/user
         */

       // List<User> userList= (List<User>) this.restTemplate.getForObject(this.url+"user", Object.class); //需开发 类型转换 工具类

        /**
         * 删除指定用户
         *  http;//url/user/{id}
         */

        //this.restTemplate.delete(this.url+"user/{id}",6); //地址  ID  (该方法没有返回)  无法判断 是否使用其他方式调用

        /**
         * 更新制定用户
         *
         */
/*        User user=new User();
        user.setId(4L);
        user.setUserName("小花");

        this.restTemplate.put(this.url+"user/{id}",user,1);*/


        ResponseEntity<User> resBody=this.restTemplate.getForEntity(this.url+"user/{id}",User.class,4);
        User res= resBody.getBody();
        model.addObject("hello",res.toString());
        model.setViewName("index");
        return model;
    }
}
