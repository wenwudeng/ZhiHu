package com.demo.mapper;

import com.demo.entity.Attention;
import com.demo.entity.Ques;
import com.demo.entity.request.UpdataAttentionCount;
import com.demo.entity.result.ConcernResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AttentionMapper {
    /*获取我关注的人*/
    List<Map<String,Object>> getMyConcern(String id);
    /*获取关注我的人*/
    List<Map<String,Object>> getFans(String id);
    /*获取关注我的人的数量*/
    Integer getFansCount(String id);
    /*获取关注某个问题的人的数量*/
    Integer getAttentionQuesFansCount(String id);
    /*获取我关注的问题*/
    List<Map<String,Object>> getAttentionQues(String id);
    /*关注某个问题*/
    void setAttentionQues(Attention attention);
    /*取消关注某个问题*/
    void deleteAttentionQues(Attention attention);
    /*关注某个用户*/
    void setAttentionUser(Attention attention);
    /*取消关注某个用户*/
    void deleteAttentionUser(Attention attention);

    /**
     * 修改问题的关注数量
     * @param UpdataAttentionCount
     */
    void updataQuesAttentionCount(UpdataAttentionCount UpdataAttentionCount);
    //根据用户ID来查询用户
    Map<String,Object> getUserById(String id);
    //获取当前用户对某个用户的关注情况
    Map<String,Object> getAttentionWithOtherUser(String userId, String otherUserId);
    //获取关注了某个东西的用户的id
    List<String> getUserIdByFocusId(String focusId, int type);
    //判断用户是否关注了某个东西
    Map<String,Object> isAttention(String userId,String focusId,int type);
}