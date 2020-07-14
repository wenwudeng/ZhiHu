package com.demo.entity.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author  mhj
 * @create  2019/7/04
 * */
@Data
public class QuesRequest {
    private String quesId;
    private String userId;
    private String ques_name;
    private String quesDescribe;
    private int anonymity;
    private String TopicType;
    private Date createTime;
    private ArrayList<String> topicName;
}
