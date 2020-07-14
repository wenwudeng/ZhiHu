package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.mapper.TopicMapper;
import com.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicMapper topicMapper;
    @Override
    public ResultVO getAllTopic() {
        return new ResultVO(200,topicMapper.getAllTopic(),"所有话题列表");
    }
}
