package com.demo.mapper;

import com.demo.entity.Ques;
import com.demo.entity.request.QuesRequest;
import com.demo.entity.request.UpdataAttentionCount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuesMapper {
    /*查询所有问题，根据创建先后时间排序*/
    List<Map<String,Object>> selectAllQues();
    /*根据问题id查询问题*/
    Map<String,Object> getQues(String id);
    /*提出问题*/
    void setQues(QuesRequest quesRequest);
    /*根据用户id获取提问总数*/
    Integer getQuesCount(String id);
    List<Map<String,Object>> getAllQues();
    /**
     * 修改浏览次数
     * @param updataAttentionCount
     */
    void updataQuesBrowseNumber(UpdataAttentionCount updataAttentionCount);
    /* 指定问题的评论数+1 */
    void addCommentCountOfQuestion(String id);

    List<Map<String,Object>> getHotQues(String name);
    /*后台获取数据*/
    List<Map<String,Object>> getBackstageQues();
    /*删除问题*/
    void deleteQues(String id);
    /*搜索问题*/
    List<Map<String,Object>> searchQues(String content);
}