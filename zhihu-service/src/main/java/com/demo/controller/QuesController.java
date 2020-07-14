package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Endorse;
import com.demo.entity.Ques;
import com.demo.entity.request.QuesRequest;
import com.demo.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/**
* @author  mhj
* @create  2019/7/2
* */
@RestController
@RequestMapping("/api/user")
public class QuesController {
    @Autowired
    private QuesService quesService;
    /*
     *获取最新的问题
     */
    //@RequestParam String userId
    @RequestMapping("/getAllQues")
    public ResultVO getAllQues(@RequestParam String userId){
     /*  String userId="6DBA6D1C9F3F41E388DA67B46F88C232";
        System.out.println("userId"+userId);*/
        return quesService.getAllQues(userId);   //data 是你要返回的数据
    }
    /**
     * 获取某个问题(测试阶段)
     */
    @RequestMapping("/getQues")
    public ResultVO getQues(@RequestParam String id){
        /*以下是测试数据*/
//        String id="2AC65D769E12427B90F50C315A3BDE05";
        return quesService.getQues(id);
    }
    /*提出问题*/
    @RequestMapping("/setQues")
    public ResultVO setQues(@RequestBody QuesRequest quesRequest){
        /*测试数据*/
//        QuesRequest quesRequest=new QuesRequest();
//        quesRequest.setUserId("14C32C1BD22C499899F0DA167C239112");
//        quesRequest.setQues_name("我是标题测试aaa");
//        quesRequest.setQuesDescribe("我是内容测试aaa");
//        quesRequest.setAnonymity(0);
//        ArrayList<String> topicName=new ArrayList<String>();
//        topicName.add("美食");
//        topicName.add("test5");
//        System.out.println(quesRequest.getTopicName());
//        quesRequest.setTopicName(topicName);
        return quesService.setQues(quesRequest);
    }

    @RequestMapping("/getHotQues")
    public ResultVO getHotQues(@RequestParam String name){
//        String name="美食";
        return quesService.getHotQues(name);
    }
}
