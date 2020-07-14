package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Collect implements Serializable {
    private String userId;

    private String favoritesId;

    private String quesId;

    private Date createTime;
}