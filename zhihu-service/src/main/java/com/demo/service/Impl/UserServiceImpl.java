package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.User;
import com.demo.entity.request.LoginRequest;
import com.demo.mapper.UserMapper;
import com.demo.service.UserService;
import com.demo.uuid.CommonToolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author MHJ
 * @Date: 2019-7-03
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /*用户登陆验证*/
    @Override
    public ResultVO UserLogin(LoginRequest loginRequest){
        if(isMobile(loginRequest.getAccount())){      //是手机号码
            Map<String,Object> user=userMapper.LoginByPhone(loginRequest.getAccount());
            if(user==null){
                return new ResultVO(200,null,"账户不存在");
            }
            else if(user.get("password").equals(loginRequest.getPassword())){
                return new ResultVO(200,user,"账号密码正确，允许登陆");
            }
            else {
                return new ResultVO(200, null, "密码不正确");
            }
        }
        else{
            Map<String,Object> user=userMapper.LoginByEmali(loginRequest.getAccount());
            if(user==null){
                return new ResultVO(200,null,"账户不存在");
            }
            else if(user.get("password").equals(loginRequest.getPassword())){
                return new ResultVO(200,user,"账号密码正确，允许登陆");
            }
            else {
                return new ResultVO(200, null, "密码不正确");
            }
        }
    }
    /*用户注册*/
    @Override
    public ResultVO UserRegister(LoginRequest loginRequest) {
        if(isMobile(loginRequest.getAccount())){
            Map<String,Object> userold=userMapper.LoginByPhone(loginRequest.getAccount());
            if(userold!=null){
                return new ResultVO(200,null,"手机号已被注册");
            }
            else{
                User user=new User();
                user.setUserId(CommonToolkit.getUuid());
                user.setPhone(loginRequest.getAccount());
                user.setPassword(loginRequest.getPassword());
                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                user.setCreateTime(date);            //插入时间
                userMapper.RegisterByPhone(user);
                return new ResultVO(200,null,"注册成功");
            }
        }
        else{
            return new ResultVO(200,null,"请输入正确的手机号");
        }
    }

    @Override
    public void setUserPortrait(User user) {
        userMapper.setUserPortrait(user);
    }

    /*
     * 正则表达式验证手机号码
     * */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean isMatch = false;
        //制定验证条件
        String regex1 = "^[1][3,4,5,7,8][0-9]{9}$";
        String regex2 = "^((13[0-9])|(14[579])|(15([0-3,5-9]))|(16[6])|(17[0135678])|(18[0-9]|19[89]))\\d{8}$";

        p = Pattern.compile(regex2);
        m = p.matcher(str);
        isMatch = m.matches();
        return isMatch;
    }

    //根据用户ID获取用户
    public ResultVO getUserById(String id){
        return new ResultVO(200,userMapper.getUserById(id),"根据用户ID获取用户");
    }
}
