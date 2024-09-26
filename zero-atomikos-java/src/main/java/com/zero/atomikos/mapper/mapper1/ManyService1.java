package com.zero.atomikos.mapper.mapper1;

import com.zero.atomikos.domain.entity.SystemUserEntity;
import com.zero.atomikos.mapper.mapper2.UserInfoMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManyService1 {

    UserInfoMapper1 userInfoMapper1;
    UserInfoMapper2 userInfoMapper2;

    @Autowired
    public ManyService1(UserInfoMapper1 userInfoMapper1, UserInfoMapper2 userInfoMapper2) {
        this.userInfoMapper1 = userInfoMapper1;
        this.userInfoMapper2 = userInfoMapper2;
    }

    public SystemUserEntity select(String userId) {
        return userInfoMapper1.findById(userId);
    }


    @Transactional
    public int insert(String userId,String username, Integer age) {
        int insert = userInfoMapper1.insert(userId,username, age);
        int i = 1 / age;// if age is zero  ,then a error will be happened.
        return insert;
    }

    @Transactional
    public int insertDb1AndDb2(String userId,String username, Integer age) {
        int insert = userInfoMapper1.insert(userId,username, age);
        int insert2 = userInfoMapper2.insert(userId,username, age);
        int i = 1 / age;// if age is zero  ,then a error will be happened.
        return insert + insert2;
    }


}