package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Attention;
import com.demo.entity.request.UpdataAttentionCount;
import com.demo.entity.result.ConcernResult;
import com.demo.mapper.AnswerMapper;
import com.demo.mapper.AttentionMapper;
import com.demo.mapper.QuesMapper;
import com.demo.mapper.UserMapper;
import com.demo.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AttentionServiceImpl implements AttentionService {
    @Autowired
    private AttentionMapper attentionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private QuesMapper quesMapper;
    @Autowired
    private UserMapper userMapper;
    /*获取我关注的人*/
    @Override
    public ResultVO getMyConcern(String id) {
        List<Map<String,Object>> concernResultList=attentionMapper.getMyConcern(id);

        for(Map<String,Object> concernResult : concernResultList) {
            concernResult.put("answerNumber",
                    answerMapper.getAnswerCount((String)concernResult.get("Focus_id")));//获取用户的回答次数
            concernResult.put("questionNumber",
                    quesMapper.getQuesCount((String)concernResult.get("Focus_id")));//获取用户的回答次数
            concernResult.put("followerNumber",
                    attentionMapper.getFansCount((String)concernResult.get("Focus_id")));//获取用户的回答次数
        }
        return new ResultVO(200,concernResultList,"查询关注的人");
    }

    @Override
    public ResultVO getFans(String id) {
        List<Map<String,Object>> fansList=attentionMapper.getFans(id);
        for(Map<String,Object> fans:fansList){
            fans.put("answerNumber",
                    answerMapper.getAnswerCount((String)fans.get("user_id")));//获取用户的回答次数
            fans.put("questionNumber",
                    quesMapper.getQuesCount((String)fans.get("user_id")));//获取用户的回答次数
            fans.put("followerNumber",
                    attentionMapper.getFansCount((String)fans.get("user_id")));//获取用户的回答次数
        }
        return new ResultVO(200,fansList,"关注我的人");
    }

    /*根据问题id获取回答总数*/
    @Override
    public ResultVO getAttentionQues(String id) {
        System.out.println("1111111");
        List<Map<String,Object>> QuesList=attentionMapper.getAttentionQues(id);
        for(Map<String,Object> ques : QuesList) {
            ques.put("answerNumber",
                    answerMapper.getByQuesIdAnswerCount((String)ques.get("Focus_id")));//获取用户的回答次数
            ques.put("attentionNumber",
                    attentionMapper.getAttentionQuesFansCount((String)ques.get("Focus_id")));//获取问题的关注次数
        }
        return new ResultVO(200,QuesList,"查询关注的问题");
    }
    /*用户关注某个问题*/
    @Override
    public synchronized ResultVO setAttentionQues(Attention attention) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        attention.setCreateTime(date);            //插入时间
        attentionMapper.setAttentionQues(attention);
        if(attention.getFocusType()==3){        //修改问题的评论次数
            Map<String,Object> map=quesMapper.getQues(attention.getFocusId());
            System.out.println(map.get("attention_number"));
            UpdataAttentionCount updataAttentionCount=new UpdataAttentionCount();
            updataAttentionCount.setQuesId(attention.getFocusId());
            updataAttentionCount.setCount(Integer.parseInt(String.valueOf(map.get("attention_number")))+1);
            attentionMapper.updataQuesAttentionCount(updataAttentionCount);
            System.out.println("updataAttentionCount"+updataAttentionCount);
        }
        return new ResultVO(200,null,"关注成功");
    }

    @Override
    public ResultVO deleteAttentionQues(Attention attention) {
        attentionMapper.deleteAttentionQues(attention);
        Map<String,Object> map=quesMapper.getQues(attention.getFocusId());
        UpdataAttentionCount updataAttentionCount=new UpdataAttentionCount();
        updataAttentionCount.setQuesId(attention.getFocusId());
        updataAttentionCount.setCount(Integer.parseInt(String.valueOf(map.get("attention_number")))-1);
        attentionMapper.updataQuesAttentionCount(updataAttentionCount);
        return new ResultVO(200,null,"取消关注成功");
    }
    //获取当前用户对某个用户的关注情况——顺带返回用户信息
    @Override
    public ResultVO getAttentionWithOtherUser(String userId, String otherUserId) {
        //获取这个用户的信息
        Map<String,Object> map=userMapper.getUserById(otherUserId);
        //System.out.println(otherUserId+"  "+attentionMapper.getAttentionWithOtherUser(userId,otherUserId));
        //如果当前已经有关注这个用户了
        if(attentionMapper.getAttentionWithOtherUser(userId,otherUserId)!=null)
            map.put("attent",1);
            //如果未关注
        else map.put("attent",0);
        return new ResultVO(200,map,"查询对某个用户的关注情况成功！");
    }
    @Override
    public ResultVO setAttentionUser(Attention attention) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        attention.setCreateTime(date);            //插入时间'
        attentionMapper.setAttentionUser(attention);
        return new ResultVO(200,null,"关注用户成功");
    }

    @Override
    public ResultVO deleteAttentionUser(Attention attention) {
        attentionMapper.deleteAttentionUser(attention);

        return new ResultVO(200,null,"取消关注用户");
    }



    //获取某个用户的粉丝数
    public ResultVO getFansCount(String id){
        return new ResultVO(200,attentionMapper.getFansCount(id),"获取粉丝数");
    }
    //获取某个问题的关注人数
    public ResultVO getQuesAttentionCount(String id){
        return new ResultVO(200,attentionMapper.getAttentionQuesFansCount(id),"获取关注该问题的人数");
    }
    //通用接口——获取关注了某个东西的用户，并判断我是否已经关注了TA
    public ResultVO getUserByFocusId(String userId,String focusId,int type){
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        //先找出关注这个东西的所有用户的ID
        List<String> userIdList=attentionMapper.getUserIdByFocusId(focusId,type);
        for(String id: userIdList)
        {
            //根据这些用户的ID来获取这些用户的详细信息
            Map<String,Object> map=userMapper.getUserById(id);
            //判断我是否应关注了这些用户
            if(attentionMapper.getAttentionWithOtherUser(userId,id)!=null)
                map.put("attent",1);
            else map.put("attent",0);
            //获取这些用户的粉丝数
            map.put("fans",attentionMapper.getFansCount(id));
            list.add(map);
        }
        return new ResultVO(200,list,"通用接口，获取关注某个东西的用户！！！");
    }
    //判断用户是否关注了某个东西
    public ResultVO isAttention(String userId,String focusId,int type){
        Integer num=0;
        if(attentionMapper.isAttention(userId,focusId,type)!=null)
            num=1;
        return new ResultVO(200,num,"通用接口！判断用户是否关注了某个东西！");
    }
}
