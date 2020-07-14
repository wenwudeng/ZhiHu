package com.demo.mapper;

import com.demo.ResultVO;
import com.demo.entity.TopicQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TopicQuestionMapper {
    /*插入问题与话题的关联*/
    void insertRelation(TopicQuestion topicQuestion);

    /**
     * 获取最热话题
     * @return
     */
    List<Map<String,Object>> getHotTopic();

    //根据问题的id来查询其所属的话题
    List<Map<String,Object>> getTopicByQuesId(String id);
}