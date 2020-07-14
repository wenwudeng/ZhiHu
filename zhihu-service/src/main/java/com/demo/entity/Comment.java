package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Comment implements Serializable {
    private String commentId;

    private String commentObjectId;

    private String objectType;

    private String userId;

    private String commentContent;

    private Integer praiseNumber;

    private Integer stepOnNumber;

    private Date createTime;

    private User user;
}