package com.demo.controller;
import com.demo.ResultVO;
import com.demo.entity.Comment;
import com.demo.entity.request.CommentRequest;
import com.demo.service.CommentService;
import com.demo.service.Impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author  mhj
 * @create  2019/7/2
 * */
@RestController
@RequestMapping("/api/user")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @RequestMapping("/getByQues")
    public ResultVO seleseByQues(@RequestParam("id") String id){
        //System.out.println(id);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Comment> commentsList=commentService.seleseByQues(id);
        map.put("commentsList",commentsList);
        System.out.println(map);
        return new ResultVO(200,map,"获取最新的问题");
    }

    @RequestMapping("/saveComment")
    public ResultVO SaveComment(@RequestBody CommentRequest commentRequest)
    {
        boolean flag=false;
//        System.out.println("userId"+commentRequest.getUserId());
//        System.out.println("qid"+commentRequest.getCommentObjectId());
//        System.out.println("context"+commentRequest.getCommentContent());
        flag=commentService.addComment(commentRequest);
        return new ResultVO(200,flag,"写评论");
    }

    //根据回答的ID来获取评论
    @RequestMapping("getCommentByAnswerId")
    public ResultVO getCommentByAnswerId(@RequestParam String id){
        return commentService.getCommentByAnswerId(id);
    }
}
