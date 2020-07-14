package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Endorse;
import com.demo.mapper.AnswerMapper;
import com.demo.service.EndorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
* @author MHJ
 * @create  2019/7/2
* */
@RestController
@RequestMapping("/api/user")
public class EndorseController {
    @Autowired
    private EndorseService endorseService;
    @Autowired
    private AnswerMapper answerMapper;
    /*根据用户id查询点赞/反对列表*/
    @RequestMapping("/getEndorse")
    public ResultVO getEndorse(@RequestParam("id") String id){
        return endorseService.getendorse(id);
    }
    /*根据用户对问题进行点赞或反对*/
    //@RequestBody Endorse endorse
    @RequestMapping("/setEndorse")
    public ResultVO setEndorse(@RequestBody Endorse endorse){
        /*测试数据*/
//        Endorse endorse=new Endorse();
//        endorse.setUserId("0C9FD6DD3A924790B6C9ED9A181E5070");
//        endorse.setAnswerId("ED83B2C5E975404688027D8DF5BF28B9");
//        endorse.setAgrOpp(1);
        endorseService.setEndorse(endorse);
        return new ResultVO(200,null,"点赞成功");
    }
    /*根据用户对文章修改点赞或反对*/
    @RequestMapping("/updataEndorse")
    public ResultVO updataEndorse(@RequestBody Endorse endorse){
        return endorseService.updataEndorse(endorse);
    }

    /**
     * 删除对问题或评论的态度
     * @return
     */
    @RequestMapping("/deleteAttitude")
    public ResultVO deleteAttitude(@RequestBody Endorse endorse){
        /*测试数据*/
//        Endorse endorse=new Endorse();
//        endorse.setUserId("0C9FD6DD3A924790B6C9ED9A181E5070");
//        endorse.setAnswerId("ED83B2C5E975404688027D8DF5BF28B9");
        return endorseService.deleteAttitude(endorse);
    }
}
