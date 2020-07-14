package com.demo.service;

import com.demo.ResultVO;

public interface TopicQuestionService {

    /**
     * 获取
     * @return
     */
    ResultVO getHotTopic();

    //根据问题的id来查询其所属的话题
    ResultVO getTopicByQuesId(String id);
}
