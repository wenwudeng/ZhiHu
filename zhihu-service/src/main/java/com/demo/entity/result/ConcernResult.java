package com.demo.entity.result;

import lombok.Data;

import java.util.Date;

@Data
public class ConcernResult {
    private String userId;

    private String focusId;

    private int focusType;

    private Date createTime;

    private String name;

    private Integer answerNumber;

    private Integer questionNumber;
}
