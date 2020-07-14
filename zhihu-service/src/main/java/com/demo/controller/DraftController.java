package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Draft;
import com.demo.entity.request.LoginRequest;
import com.demo.service.DraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/draft")
public class DraftController {
    @Autowired
    private DraftService draftService;
    @RequestMapping("/updata")
    public ResultVO updataDraft(@RequestBody Draft draft){
        return draftService.updataDraft(draft);
    }
}
