package com.zero.atomikos.controller;

import com.zero.atomikos.mapper.mapper1.ManyService1;
import com.zero.atomikos.mapper.mapper2.ManyService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system/user")
public class HelloWorldController {

    ManyService1 manyService1;
    ManyService2 manyService2;

    @Autowired
    public HelloWorldController(ManyService1 manyService1, ManyService2 manyService2) {
        this.manyService1 = manyService1;
        this.manyService2 = manyService2;
    }

    @GetMapping(value = "datasource1/info")
    public Object getSystemUserInfo1(String userId) {
        return manyService1.select(userId);
    }

    //http://localhost:8088/datasource1?userId=9&username=datasource1&age=2
    @RequestMapping(value = "datasource1")
    public int datasource1(String userId, String username, Integer age) {
        return manyService1.insert(userId, username, age);
    }

    @GetMapping(value = "datasource2/info")
    public Object getSystemUserInfo2(String userId) {
        return manyService1.select(userId);
    }

    //http://localhost:8088/datasource2?userId=9&username=datasource2&age=2
    @RequestMapping(value = "datasource2")
    public int datasource2(String userId, String username, Integer age) {
        return manyService2.insert(userId, username, age);
    }

    //http://localhost:8088/insertDb1AndDb2?userId=1&username=tom5&age=2
    //http://localhost:8088/insertDb1AndDb2?userId=2&username=tom5&age=0  //touch a error
    @RequestMapping(value = "insertDb1AndDb2")
    public int insertDb1AndDb2(String userId, String username, Integer age) {
        return manyService1.insertDb1AndDb2(userId, username, age);
    }

}