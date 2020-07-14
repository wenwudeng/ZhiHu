package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Attention implements Serializable {
    private String userId;

    private String focusId;

    private int focusType;

    private Date createTime;

    private Integer answerNumber;

    private Integer questionNumber;

    private Integer followerNumber;
}