package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Collect;
import com.demo.mapper.CollectMapper;
import com.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public ResultVO setCollect(Collect collect) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        collect.setCreateTime(date);            //插入时间
        collectMapper.setCollect(collect);
        return new ResultVO(200,null,"收藏成功");
    }

    @Override
    public ResultVO deleteCollect(Collect collect) {
        collectMapper.deleteCollect(collect);
        return new ResultVO(200,null,"取消收藏");
    }
}
