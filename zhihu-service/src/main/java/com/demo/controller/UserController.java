package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.User;
import com.demo.entity.request.LoginRequest;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Date 2019-07-03
 * @author mhj
 * */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * @Description: 用户类controller
     * @Author: 缪浩杰
     * @Date: 2019-07-03
     */
    //@RequestBody LoginRequest loginRequest
    @RequestMapping("/Login")
    public ResultVO Login(@RequestBody LoginRequest loginRequest){
    /*    LoginRequest loginRequest=new LoginRequest();
        loginRequest.setAccount("18059882212");
        loginRequest.setPassword("202cb962ac59075b964b07152d234b70");
        System.out.println(loginRequest);*/
        ResultVO resultVO=userService.UserLogin(loginRequest);
//        System.out.println("resultVO"+resultVO);
        return resultVO;  //data 是你要返回的数据
    }
    //    @RequestBody LoginRequest loginRequest
    @RequestMapping("/register")
    public ResultVO register(@RequestBody LoginRequest loginRequest){
        /*以下是测试数据*/
//        LoginRequest loginRequest= new LoginRequest();
//        loginRequest.setAccount("18059882333");
//        loginRequest.setPassword("202cb962ac59075b964b07152d234b70");
        return userService.UserRegister(loginRequest);
    }
    //@RequestBody User user
    @RequestMapping("/setUserPortrait")
    public ResultVO setUserPortrait(@RequestBody User user) {
//        User user=new User();
//        user.setUserId("0C9FD6DD3A924790B6C9ED9A181E5070");
//        user.setPortrait("@222");
        userService.setUserPortrait(user);
        return new ResultVO(200,null,"修改头像");
    }
    //根据用户的ID来获取用户
    @RequestMapping("/getUserById")
    public ResultVO getUserById(@RequestParam String id){
        return  userService.getUserById(id);
    }
}
