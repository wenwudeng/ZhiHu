package com.demo.controller;

import com.demo.ResultVO;
import com.demo.mapper.TopicMapper;
import com.demo.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;
    @RequestMapping("/getAllTopic")
    public ResultVO getAllTopic(){
        return topicService.getAllTopic();
    }
}
