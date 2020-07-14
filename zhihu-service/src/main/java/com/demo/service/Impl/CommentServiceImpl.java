package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Comment;
import com.demo.entity.request.CommentRequest;
import com.demo.mapper.CommentMapper;
import com.demo.mapper.QuesMapper;
import com.demo.service.CommentService;
import com.demo.uuid.CommonToolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * @author MHJ
 * @creade 2019-7-09
 * */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired(required = false)
    private CommentMapper commentMapper;
    @Autowired
    private QuesMapper quesMapper;

    /*根据话题id查询评论*/
    @Override
    public List<Comment> seleseByQues(String id){
        return commentMapper.seleseByQues(id);
    }

    //按评论id查询评论
    public Comment findComment(String id){
        return commentMapper.findComment(id);
    }

    //新增评论的方法
    @Override
    public boolean addComment(CommentRequest commentRequest)
    {
        boolean flag=false;
        //构造一个新的Comment对象
        Comment comment=new Comment();
        comment.setCommentId(CommonToolkit.getUuid());//随机生成id
        comment.setCommentObjectId(commentRequest.getCommentObjectId());//评论对象的id
        comment.setUserId(commentRequest.getUserId());//评论者的id
        comment.setObjectType(commentRequest.getObjectType());//评论对象的类型
        comment.setCommentContent(commentRequest.getCommentContent());//评论的具体内容
        comment.setPraiseNumber(0);//初始化点赞次数为0
        comment.setStepOnNumber(0);//初始化反对次数为0
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");//评论的时间为当前时间
        comment.setCreateTime(date);
        //存入数据库
        commentMapper.addComment(comment);
        //检查是否存入成功！
        if(findComment(comment.getCommentId())!=null)
        {
            //如果是对问题进行评论，则需要让它的评论数+1
            if(Integer.parseInt(commentRequest.getObjectType())==1)
                quesMapper.addCommentCountOfQuestion(commentRequest.getCommentObjectId());
            flag=true;
        }
        return flag;
    }
    //根据回答的ID获取回答的评论
    public ResultVO getCommentByAnswerId(String id){
        return new ResultVO(200, commentMapper.selectByAnswerId(id),"获取回答的评论");
    }
}