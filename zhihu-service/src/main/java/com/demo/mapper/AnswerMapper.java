package com.demo.mapper;

import com.demo.entity.Answer;
import com.demo.entity.Endorse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AnswerMapper {
    /*根据问题id查看回答*/
    List<Map<String,Object>> getAnswer(String id);
    /*根据用户id获取回答总数*/
    Integer getAnswerCount(String id);
    /*根据问题id获取回答总数*/
    Integer getByQuesIdAnswerCount(String id);
    /*写回答*/
    void setAnswer(Answer answer);
    /*我的问答*/
    List<Map<String,Object>> getUserAnswer(String id);
    /**
     *修改点赞回答的点赞总计
     *
     * @param endorse
     */
    void updataEndorsNum(Endorse endorse);

    /**
     * 获取某个问题的最热回答
     * @param id
     * @return
     */
    Map<String,Object> getQuesHotAnswer(String id);
}