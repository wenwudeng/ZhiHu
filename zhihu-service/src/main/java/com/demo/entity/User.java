package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {
    private String userId;

    private String emali;

    private String phone;

    private String name;

    private String password;

    private String gender;

    private String portrait;

    private Integer praiseNumber;

    private Integer thankNumber;

    private Integer questionNumber;

    private Integer answerNumber;

    private Integer collectNumber;

    private Integer editNumber;

    private Integer attentionNumber;

    private Integer followerNumber;

    private Integer concernTopicNumber;

    private String forbidden;

    private String  forbiddenTime;

    private Date createTime;
}