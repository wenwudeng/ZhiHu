package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Attention;

import java.util.List;
import java.util.Map;

public interface AttentionService {
    /*获取我关注的人*/
    ResultVO getMyConcern(String id);
    /*获取关注我的人*/
    ResultVO getFans(String id);
    /*获取我关注的问题*/
    ResultVO getAttentionQues(String id);
    /*关注某个问题*/
    ResultVO setAttentionQues(Attention attention);
    /*取消关注某个问题*/
    ResultVO deleteAttentionQues(Attention attention);
    //获取当前用户对某个用户的关注态度
    ResultVO getAttentionWithOtherUser(String userId, String otherUserId);
    /*关注某个用户*/
    ResultVO setAttentionUser(Attention attention);
    /*取消关注某个用户*/
    ResultVO deleteAttentionUser(Attention attention);


    //获取某个用户的粉丝数
    ResultVO getFansCount(String id);
    //获取某个问题的关注人数
    ResultVO getQuesAttentionCount(String id);
    //通用接口——获取关注某个东西的用户，并判断我是否已经关注了TA
    ResultVO getUserByFocusId(String userId, String focusId, int type);
    //通用接口——判断用户是否关注了某个东西
    ResultVO isAttention(String userId, String focusId, int type);
}
