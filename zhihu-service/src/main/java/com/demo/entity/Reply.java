package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Reply implements Serializable {
    private String replyId;

    private String commentId;

    private String replyContent;

    private Integer praiseNumber;

    private Date createTime;
}