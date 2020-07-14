package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Answer;
import com.demo.entity.Endorse;
import com.demo.entity.request.UserAttitudeRequest;
import com.demo.mapper.AnswerMapper;
import com.demo.mapper.EndorseMapper;
import com.demo.service.AnswerService;
import com.demo.uuid.CommonToolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private EndorseMapper endorseMapper;
    /*获取某个问题的回答*/
    @Override
    public ResultVO getAnswer(UserAttitudeRequest userAttitudeRequest) {
        List<Map<String,Object>> answerList=answerMapper.getAnswer(userAttitudeRequest.getQuesId());
        for(Map<String,Object> answer :answerList){                     //获取用户对回答的态度
            Endorse endorse =new Endorse();
            endorse.setUserId(userAttitudeRequest.getUserId());
            endorse.setAnswerId(answer.get("answer_id").toString());
            Map<String,Object> endorseMap=endorseMapper.getUserEndorse(endorse);
            if (endorseMap!=null){
                answer.put("manner",endorseMap.get("agr_opp"));
            }
            else{
                answer.put("manner",-1);
            }
            answer.put("opposeCount",
                    endorseMapper.getOpposeCount(answer.get("answer_id").toString()));      //获取反对数量
        }
        return new ResultVO(200,answerList,"问题的回答");
    }

    @Override
    public ResultVO setAnswer(Answer answer) {
        answer.setAnswerId(CommonToolkit.getUuid());
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        answer.setCreateTime(date);            //插入时间
        answerMapper.setAnswer(answer);
        return new ResultVO(200,null,"回答成功");
    }

    @Override
    public ResultVO getUserAnswer(String id) {
        return new ResultVO(200,answerMapper.getUserAnswer(id),"回答成功");
    }
}
