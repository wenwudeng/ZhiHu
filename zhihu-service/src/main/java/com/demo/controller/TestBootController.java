package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.*;
import com.demo.entity.request.LoginRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sch
 * @create 2019/3/29
 * 这是一个测试类！这是一个测试类！这是一个测试类
 */
@RestController
@RequestMapping("/api/user")
public class TestBootController {
    @RequestMapping("/getHome")
    public String getHome(ModelMap map) {
        return "Home";
    }
    @RequestMapping("/getLogin")
    public ResultVO getLogin(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        Test test=new Test();
        test.setName("11");
        return new ResultVO(200,test,"测试");   //data 是你要返回的数据
    }
}