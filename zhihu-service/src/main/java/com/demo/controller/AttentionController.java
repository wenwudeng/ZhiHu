package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Attention;
import com.demo.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attent")
public class AttentionController {
    @Autowired
    private AttentionService attentionService;

    @RequestMapping("/getConcern")
    public ResultVO getConcern(@RequestParam String id){
        /*测试数据*/
//        String id="F3667642610543F5A3992D0F7E3EA1C9";
        return attentionService.getMyConcern(id);
    }
    /*获取关注的问题*/
    /*@RequestParam String id*/
    @RequestMapping("/getAttentionQues")
    private ResultVO getAttentionQues(@RequestParam String id){
        /*测试数据*/
//        String id="14C32C1BD22C499899F0DA167C239112";
        return attentionService.getAttentionQues(id);
    }
    //@RequestBody Attention attention
    /*对某个问题进行关注*/
    @RequestMapping("/setAttentionQues")
    private ResultVO setAttentionQues(@RequestBody Attention attention){
        /*测试数据*/
//        Attention attention=new Attention();
//        attention.setUserId("14C32C1BD22C499899F0DA167C239112");
//        attention.setFocusId("B83537E45FF141979401EA479BE05AC4");
//        attention.setFocusType(3);
        return attentionService.setAttentionQues(attention);
    }
    /*对某个问题取消关注*/
    @RequestMapping("/deleteAttentionQues")
    private ResultVO deleteAttentionQues(@RequestBody Attention attention){
        /*测试数据*/
//        Attention attention=new Attention();
//        attention.setUserId("9A8CBC30A1214E999F6171EA6A03E7CC");
//        attention.setFocusId("64661474CF684908A3271C4645A11C92");
//        attention.setFocusType(3);
        return attentionService.deleteAttentionQues(attention);
    }
    //获取当前用户对某个用户的关注态度
    @RequestMapping("/getAttentionWithOtherUser")
    public ResultVO getAttentionWithOtherUser(@RequestParam String userId,@RequestParam String otherUserId){
        return attentionService.getAttentionWithOtherUser(userId,otherUserId);
    }

    @RequestMapping("/setAttentionUser")
    private ResultVO setAttentionUser(@RequestBody Attention attention){
//        Attention attention=new Attention();
//        attention.setUserId("14C32C1BD22C499899F0DA167C239112");
//        attention.setFocusId("F3667642610543F5A3992D0F7E3EA1C9");
        return attentionService.setAttentionUser(attention);
    }
    @RequestMapping("/deleteAttentionUser")
    private ResultVO deleteAttentionUser(@RequestBody Attention attention){
        return attentionService.deleteAttentionUser(attention);
    }



    //获取某个用户的粉丝数
    @RequestMapping("getFansCount")
    private ResultVO getFansCount(@RequestParam String id){
        return attentionService.getFansCount(id);
    }
    //获取关注某个问题的人数--废弃
    @RequestMapping("getQuesAttentionCount")
    private ResultVO getQuesAttentionCount(@RequestParam String id){
        return attentionService.getQuesAttentionCount(id);
    }
    //通用接口——获取关注某个东西的用户，已以及判断我是否已经关注了TA
    @RequestMapping("getUserByFocusId")
    private ResultVO getUserByFocusId(@RequestParam String userId,@RequestParam String focusId,@RequestParam int type){
        //System.out.println("userId="+userId+"  focusId="+focusId+"  type="+type);
        return attentionService.getUserByFocusId(userId,focusId,type);
    }
    //通用接口——判断用户是否关注了某个东西
    @RequestMapping("isAttention")
    private  ResultVO isAttention(@RequestParam String userId,@RequestParam String focusId,@RequestParam int type){
        return attentionService.isAttention(userId,focusId,type);
    }
}
