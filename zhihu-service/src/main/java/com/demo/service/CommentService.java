package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Comment;
import com.demo.entity.request.CommentRequest;

import java.util.List;

public interface CommentService {
    /*
     *根据问题id查询评论
     */
    List<Comment> seleseByQues(String id);

    /*
     * 新增评论
     */
    boolean addComment(CommentRequest commentRequest);

    //根据回答的id获取回答的评论
    ResultVO getCommentByAnswerId(String id);
}
