package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Ques;
import com.demo.entity.request.QuesRequest;

import java.util.List;
public interface QuesService {
    /*获取所有问题*/
    ResultVO getAllQues(String userId);
    /*根据问题id获取问题*/
    ResultVO getQues(String id);
    /*提出新的问题*/
    ResultVO setQues(QuesRequest quesRequest);

    /**
     * 获取最热的问题
     * @param name
     * @return
     */
    ResultVO getHotQues(String name);
}
