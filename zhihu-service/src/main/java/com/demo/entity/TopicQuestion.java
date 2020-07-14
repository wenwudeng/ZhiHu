package com.demo.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class TopicQuestion implements Serializable {
    private String topicName;

    private String quesId;
}