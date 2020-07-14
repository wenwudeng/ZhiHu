package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Collect;
import com.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @RequestMapping("/setCollect")
    public ResultVO setCollect(@RequestBody Collect collect){
        /*测试数据*/
//        Collect collect=new Collect();
//        collect.setUserId("14C32C1BD22C499899F0DA167C239112");
//        collect.setQuesId("F3667642610543F5A3992D0F7E3EA1C9");
//        collect.setFavoritesId("622B46DAE2674763AB105432A7111482");
        return collectService.setCollect(collect);
    }
    @RequestMapping("/deleteCollect")
    public ResultVO deleteCollect(@RequestBody Collect collect){
        /*测试数据*/
//        Collect collect=new Collect();
//        collect.setUserId("14C32C1BD22C499899F0DA167C239112");
//        collect.setQuesId("F3667642610543F5A3992D0F7E3EA1C9");
//        collect.setFavoritesId("622B46DAE2674763AB105432A7111482");
        return collectService.deleteCollect(collect);
    }
}
