package com.demo.mapper;

import com.demo.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentMapper {
    /*
    *根据问题id查询评论
    */
    List<Comment> seleseByQues(String id);
    //根据评论id查询评论
    Comment findComment(String id);

    //写评论
    void addComment(Comment comment);
    //根据回答的id查询评论
    List<Comment> selectByAnswerId(String id);
}