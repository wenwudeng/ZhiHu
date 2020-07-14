package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class Topic implements Serializable {
    private String topicId;

    private String topicName;
}