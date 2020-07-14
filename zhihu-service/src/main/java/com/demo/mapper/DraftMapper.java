package com.demo.mapper;

import com.demo.entity.Draft;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftMapper {
    /*修改草稿*/
    void updataDraft(Draft draft);
}