package com.demo.controller;

import com.demo.ResultVO;
import com.demo.service.TopicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicQuestionController {
    @Autowired
    private TopicQuestionService topicQuestionService;
    @RequestMapping("/getHotTopic")
    public ResultVO getHotTopic(){
        return topicQuestionService.getHotTopic();
    }

    //根据问题的id来查询其所属的话题
    @RequestMapping("/getTopic")
    public ResultVO getTopicByQuesId(@RequestParam String id){
        return topicQuestionService.getTopicByQuesId(id);
    }
}
