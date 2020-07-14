package com.demo.mapper;

import com.demo.entity.Endorse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EndorseMapper {
    /*
     *根据用户id查询赞同回答
     */
    List<Endorse> getEndorse(String id);
    /*第一次操作赞同或反对*/
    void setEndorse(Endorse endorse);
    /*修改赞同或反对*/
    void updataEndorse(Endorse endorse);

    /**
     * 删除赞同或反对
     * @param endorse
     */
    void deleteAttitude(Endorse endorse);
    /**
     * 获取用户对某个问题的态度
     * @param endorse
     * @return
     */
    Map<String,Object> getUserEndorse(Endorse endorse);

    Integer getOpposeCount(String id);

}