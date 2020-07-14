package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Ques implements Serializable {
    private String quesId;

    private String quesName;

    private String quesDescribe;

    private String photo;

    private Integer answerNumber;

    private Integer attentionNumber;

    private Integer endorseNumber;

    private Integer browseNumber;

    private Integer anonymity;

    private Date createTime;
}