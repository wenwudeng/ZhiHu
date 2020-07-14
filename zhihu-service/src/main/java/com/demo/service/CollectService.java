package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Collect;

public interface CollectService {
    /*对问题进行收藏*/
    ResultVO setCollect(Collect collect);
    /*取消收藏*/
    ResultVO deleteCollect(Collect collect);
}
