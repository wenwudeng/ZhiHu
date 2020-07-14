package com.demo.mapper;

import com.demo.entity.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TopicMapper {
    /*根据话题名查询是否存在*/
    Map<String,Object> getTopic(String name);

    void setTopic(Topic topic);

    /**
     * 获取所有的话题
     * @return
     */
    List<Map<String,Object>> getAllTopic();

}