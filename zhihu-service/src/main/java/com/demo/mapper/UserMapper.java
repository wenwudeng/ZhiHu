package com.demo.mapper;

import com.demo.entity.User;
import com.demo.entity.request.LoginRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    /*根据手机号码查询*/
    Map<String,Object> LoginByPhone(String account);
    /*根据邮箱查询*/
    Map<String,Object> LoginByEmali(String account);
    /*根据手机号码查询*/
    void RegisterByPhone(User user);
    /*根据邮箱查询*/
    User RegisterByEmali(LoginRequest loginRequest);
    /**
     * 插入用户头像
     * @param user
     */
    void setUserPortrait(User user);
    //根据用户ID来查询用户
    Map<String,Object> getUserById(String id);
    //根据用户ID来查询用户
    List<Map<String,Object>> getAllUser();
    //禁用用户
    void prohibitUser(User user);
    //解封用户
    void unsealingUser(String userId);
    //根据用户名搜索用户
    List<Map<String,Object>> searchUser(String content);
}