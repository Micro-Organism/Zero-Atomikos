package com.zero.atomikos.mapper.mapper2;

import com.zero.atomikos.domain.entity.SystemUserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoMapper2 {

    /**
     * query
     * @param userId  用户id
     * @return  用户信息
     */
    @Select("SELECT * FROM system_user WHERE user_id = #{userId}")
    SystemUserEntity findById(@Param("userId") String userId);

    /**
     * query
     * @param username  用户名
     * @return  用户信息
     */
    @Select("SELECT * FROM system_user WHERE username = #{username}")
    SystemUserEntity findByName(@Param("username") String username);

    /**
     * add
     * @param userId    用户id
     * @param username  用户名
     * @param age        年龄
     * @return  插入结果
     */
    @Insert("INSERT INTO system_user(user_id, username, age) VALUES(#{userId},#{username}, #{age})")
    int insert(@Param("userId") String userId, @Param("username") String username, @Param("age") Integer age);
}