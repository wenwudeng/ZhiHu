package com.demo.entity.request;

import lombok.Data;

/**
 * 评论的请求数据
 */
@Data
public class CommentRequest {
    private String commentObjectId;
    private String objectType;
    private String userId;
    private String commentContent;
}
