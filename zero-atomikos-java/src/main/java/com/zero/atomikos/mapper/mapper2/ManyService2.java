package com.zero.atomikos.mapper.mapper2;

import com.zero.atomikos.domain.entity.SystemUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManyService2 {

    UserInfoMapper2 userInfoMapper2;

    @Autowired
    public ManyService2(UserInfoMapper2 userInfoMapper2) {
        this.userInfoMapper2 = userInfoMapper2;
    }

    public SystemUserEntity select(String userId) {
        return userInfoMapper2.findById(userId);
    }

    @Transactional
    public int insert(String userId,String username, Integer age) {
        int i = userInfoMapper2.insert(userId,username, age);
        System.out.println("userInfoMapper2.insert end :" + null);
        int a = 1 / age;// if age is zero  ,then a error will be happened.
        return i;
    }

}