package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Draft;
import com.demo.mapper.DraftMapper;
import com.demo.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@author MHJ
* @creade 2019-7-04
* */
@Service
public class DraftServiceImpl implements DraftService {
    @Autowired
    private DraftMapper draftMapper;
    @Override
    public ResultVO updataDraft(Draft draft) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        draft.setCreateTime(date);
        draftMapper.updataDraft(draft);
        return new ResultVO(200,null,"修改成功");
    }
}
