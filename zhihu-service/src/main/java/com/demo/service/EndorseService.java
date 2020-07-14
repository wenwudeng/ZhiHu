package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Endorse;

public interface EndorseService {
    /*根据用户id获取点赞*/
    ResultVO getendorse(String id);
    /*第一次对文章进行点赞或者反对操作*/
    ResultVO setEndorse(Endorse endorse);
    /*对文章点赞进行修改*/
    ResultVO updataEndorse(Endorse endorse);

    /**
     * 删除用户对问题或评论的点赞
     * @param endorse
     * @return
     */
    ResultVO deleteAttitude(Endorse endorse);
}
