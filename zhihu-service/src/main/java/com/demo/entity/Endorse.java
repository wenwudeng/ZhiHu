package com.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Endorse {
    private String userId;
    private String answerId;
    private int agrOpp;
    private Date createTime;
}
