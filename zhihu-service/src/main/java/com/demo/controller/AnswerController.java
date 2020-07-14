package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Answer;
import com.demo.entity.request.UserAttitudeRequest;
import com.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
*@author MHJ
* @creade 2019-7-04
* */
@RestController
@RequestMapping("/api/answer")
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    //@RequestBody UserAttitudeRequest userAttitudeRequest
    @RequestMapping("/getAnswer")
    public ResultVO getAnswer(@RequestBody UserAttitudeRequest userAttitudeRequest){
        /*测试数据*/
//        UserAttitudeRequest userAttitudeRequest=new UserAttitudeRequest();
//        userAttitudeRequest.setQuesId("05C177E5B3CA44DF9862E2058C485541");
//        userAttitudeRequest.setUserId("6DBA6D1C9F3F41E388DA67B46F88C232");
        return answerService.getAnswer(userAttitudeRequest);
    }
    @RequestMapping("/setAnswer")
    public ResultVO setAnswer(@RequestBody Answer answer){
        /*测试数据*/
//        Answer answer=new Answer();
//        answer.setQuesId("2AC65D769E12427B90F50C315A3BDE05");
//        answer.setUserId("14C32C1BD22C499899F0DA167C239112");
//        answer.setAnswerContent("测试回答内容");
//        answer.setAnonymity(1);
        return answerService.setAnswer(answer);
    }
    @RequestMapping("/getUserAnswer")
    public ResultVO getUserAnswer(@RequestParam String id){
        /*测试数据*/
//        String id="9A8CBC30A1214E999F6171EA6A03E7CC";
        return answerService.getUserAnswer(id);
    }
}
