package com.demo.mapper;

import com.demo.entity.Collect;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectMapper {
    /*对问题进行收藏*/
    void setCollect(Collect collect);
    /*取消收藏*/
    void deleteCollect(Collect collect);
    /*获取收藏夹的收藏总数*/
    Integer getCollectCount(String id);
}