package com.zero.atomikos.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SystemUserEntity {

    private String userId;
    private String username;
    private int age;
    private int gender;
    private String remark;
    private Date createTime;
    private String createId;
    private Date updateTime;
    private String updateId;
    private int enabled;

}
