package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Answer;
import com.demo.entity.request.UserAttitudeRequest;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    /*获取某个问题回答*/
    ResultVO getAnswer(UserAttitudeRequest userAttitudeRequest);
    /*为问题写问答*/
    ResultVO setAnswer(Answer answer);
    /*我的问答*/
    ResultVO getUserAnswer(String id);
}
