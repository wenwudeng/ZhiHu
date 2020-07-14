package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Answer implements Serializable {
    private String answerId;

    private String userId;

    private String quesId;

    private String answerContent;

    private Integer anonymity;

    private Date createTime;
}