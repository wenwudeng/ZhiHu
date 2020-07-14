package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Draft implements Serializable {
    private String userId;

    private String draftContent;

    private Date createTime;
}