package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.TopicQuestion;
import com.demo.mapper.TopicQuestionMapper;
import com.demo.service.TopicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TopicQuestionServiceImpl implements TopicQuestionService {
    @Autowired
    private TopicQuestionMapper topicQuestionMapper;

    @Override
    public ResultVO getHotTopic() {
        return new ResultVO(200, topicQuestionMapper.getHotTopic(),"当前最热话题列表");
    }

    //根据问题的id来查询其所属的话题
    @Override
    public ResultVO getTopicByQuesId(String id) {
        System.out.println(topicQuestionMapper.getTopicByQuesId(id));
        return new ResultVO(200, topicQuestionMapper.getTopicByQuesId(id),"获取问题所属的话题");
    }
}
