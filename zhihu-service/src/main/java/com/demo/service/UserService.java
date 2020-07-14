package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.User;
import com.demo.entity.request.LoginRequest;

public interface UserService {
    /*根据邮箱或手机号码查询*/
    ResultVO UserLogin(LoginRequest loginRequest);
    /*根据邮箱或手机号码进行注册*/
    ResultVO UserRegister(LoginRequest loginRequest);

    /**
     * @param user 修改用户头像
     */
    void setUserPortrait(User user);
    //根据用户的ID来获取用户
    ResultVO getUserById(String id);
}
