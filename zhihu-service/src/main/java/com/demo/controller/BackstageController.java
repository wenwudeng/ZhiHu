package com.demo.controller;

import com.demo.entity.User;
import com.demo.mapper.QuesMapper;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Backstage")
public class BackstageController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuesMapper quesMapper;
    @RequestMapping("/getHome")
    public String getHome(ModelMap map) {
        return "Home";
    }
    @RequestMapping("/getIndex")
    public String getIndex(ModelMap map){
        List<Map<String,Object>> userList=userMapper.getAllUser();
        map.addAttribute("userList",userList);
        return "index";
    }
    @RequestMapping("/Prohibit")
    @ResponseBody
    public String Prohibit(@RequestBody Map<String,String> map) throws ParseException {
        System.out.println(map.get("DisabledTime").toString());
        System.out.println(map.get("userId").toString());
        User user=new User();
        user.setUserId(map.get("userId").toString());
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format1.parse(map.get("DisabledTime").toString()));
        user.setForbiddenTime(map.get("DisabledTime").toString());
        userMapper.prohibitUser(user);
        return "用户禁用";
    }
    @RequestMapping("/Unsealing")
    @ResponseBody
    public String Unsealing(@RequestBody Map<String,String> map){
        System.out.println("userId"+map.get("userId").toString());
        userMapper.unsealingUser(map.get("userId").toString());
        return "200";
    }
    @RequestMapping("/problem")
    public String problem(ModelMap map){
        List<Map<String,Object>> QuesList=quesMapper.getBackstageQues();
        map.addAttribute("QuesList",QuesList);
        return "problem";
    }
    @RequestMapping("/deleteQues")
    @ResponseBody
    public String deleteQues(@RequestBody Map<String,String> map){
        System.out.println("quesId"+map.get("quesId").toString());
        quesMapper.deleteQues(map.get("quesId").toString());
        return "problem";
    }
    @RequestMapping("/searchUser")
    public String searchUser(@RequestParam String content,ModelMap modelMap){
        System.out.println(userMapper.searchUser(content));
        List<Map<String,Object>> userList=userMapper.searchUser(content);
        modelMap.addAttribute("userList",userList);
        return "index";
    }
    @RequestMapping("/searchQues")
    public String searchQues(@RequestParam String content,ModelMap modelMap){
        System.out.println(userMapper.searchUser(content));
        List<Map<String,Object>> QuesList=quesMapper.searchQues(content);
        modelMap.addAttribute("QuesList",QuesList);
        return "problem";
    }

}
