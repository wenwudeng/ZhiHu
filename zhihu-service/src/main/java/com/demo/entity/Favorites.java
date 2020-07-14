package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Favorites implements Serializable {
    private String favoritesId;

    private String userId;

    private String favoritesName;

    private Integer open;

    private Date createTime;

    private String favoritesDescribe;
}