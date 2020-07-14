package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Endorse;
import com.demo.mapper.AnswerMapper;
import com.demo.mapper.EndorseMapper;
import com.demo.service.EndorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author MHJ
 * @create 2019-7-03
 * */
@Service
public class EndorseServiceImpl implements EndorseService {
    @Autowired
    private EndorseMapper endorseMapper;
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public ResultVO getendorse(String id) {
        return new ResultVO(200,endorseMapper.getEndorse(id),"点赞列表");
    }
    /*第一次点赞写入数据库*/
    @Override
    public ResultVO setEndorse(Endorse endorse) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        endorse.setCreateTime(date);
        endorseMapper.setEndorse(endorse);
        answerMapper.updataEndorsNum(endorse);
        return new ResultVO(200,null,"点赞成功");
    }
    /*对点赞操作进行修改*/
    @Override
    public ResultVO updataEndorse(Endorse endorse) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        endorse.setCreateTime(date);
        endorseMapper.updataEndorse(endorse);
        answerMapper.updataEndorsNum(endorse);
        return new ResultVO(200,null,"修改成功");
    }

    @Override
    public ResultVO deleteAttitude(Endorse endorse) {
        endorseMapper.deleteAttitude(endorse);
        return new ResultVO(200,null,"删除点赞成功");
    }
}
