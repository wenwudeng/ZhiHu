package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.auxiliary.WordTest;
import com.demo.entity.Endorse;
import com.demo.entity.Ques;
import com.demo.entity.Topic;
import com.demo.entity.TopicQuestion;
import com.demo.entity.request.QuesRequest;
import com.demo.entity.request.UpdataAttentionCount;
import com.demo.mapper.*;
import com.demo.service.QuesService;
import com.demo.uuid.CommonToolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class QuesServiceImpl implements QuesService {
    @Autowired
    private QuesMapper quesMapper;
    @Autowired
    private TopicQuestionMapper topicQuestionMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private EndorseMapper endorseMapper;
    /*
    *查询所有话题所有字段
    */
    @Override
    public ResultVO getAllQues(String useId){
        List<Map<String,Object>> quesList=quesMapper.selectAllQues();
        for(Map<String,Object> ques:quesList){
            Map<String,Object> answer=answerMapper.
                    getQuesHotAnswer(ques.get("ques_id").toString());
            ques.put("hotAnswer",answer);
            Endorse endorse=new Endorse();
            endorse.setUserId(useId);
            if(answer!=null){
                endorse.setAnswerId((String)answer.get("answer_id"));
                Map<String,Object> endorseMap=endorseMapper.getUserEndorse(endorse);
                ques.put("endorseMap",endorseMap);
                if (endorseMap!=null){
                    ques.put("manner",endorseMap.get("agr_opp"));
                }
                else{
                    ques.put("manner",-1);
                }
            }
            else{
                ques.put("manner",-1);
            }
            System.out.println(ques);
        }
        return new ResultVO(200,quesList, "推荐列表");
    }
    @Override
    public synchronized ResultVO getQues(String id) {
        Map<String,Object> ques=quesMapper.getQues(id);
        UpdataAttentionCount updataAttentionCount=new UpdataAttentionCount();       //问题流程次数加1
        updataAttentionCount.setQuesId(id);
        updataAttentionCount.setCount(Integer.parseInt(String.valueOf(ques.get("browse_number")))+1);
        quesMapper.updataQuesBrowseNumber(updataAttentionCount);
        return new ResultVO(200,ques,"获取某个问题");
    }

    @Override
    public ResultVO setQues(QuesRequest quesRequest) {
        String uuid = CommonToolkit.getUuid();      //生成uuid
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        quesRequest.setCreateTime(date);            //插入时间
        quesRequest.setQuesId(uuid);
        Map<String,Object> TitleFilter=WordTest.filter(quesRequest.getQues_name());
        Map<String,Object> contentFilter=WordTest.filter(quesRequest.getQuesDescribe());
        for (int i = 0; i < quesRequest.getTopicName().size(); i++) {          //话题包含敏感词汇
            Map<String,Object> topicFilter=WordTest.filter(quesRequest.getTopicName().get(i));
            if(topicFilter.get("flag").toString().equals("true")){
                return new ResultVO(200,topicFilter,"话题包含敏感词汇");
            }
        }
        if(TitleFilter.get("flag").toString().equals("false")                   //标题和内容均不含敏感词汇
                &&contentFilter.get("flag").toString().equals("false")){
            System.out.println("都不包含敏感词汇");
            quesMapper.setQues(quesRequest);
            ArrayList<String> topicName=quesRequest.getTopicName();
            TopicQuestion topicQuestion=new TopicQuestion();            //构造问题与话题的关联
            topicQuestion.setQuesId(quesRequest.getQuesId());          //问题id
            for(int i=0;i<quesRequest.getTopicName().size();i++){
                topicQuestion.setTopicName(quesRequest.getTopicName().get(i));
                System.out.println(topicQuestion);
                System.out.println(quesRequest.getTopicName().get(i));
                topicQuestionMapper.insertRelation(topicQuestion);
                System.out.println(topicMapper.getTopic(quesRequest.getTopicName().get(i)));
                if(topicMapper.getTopic(quesRequest.getTopicName().get(i))==null){     //不存在插入
                    Topic topic=new Topic();
                    topic.setTopicId(CommonToolkit.getUuid());
                    topic.setTopicName(quesRequest.getTopicName().get(i));
                    System.out.println(topic);
                    topicMapper.setTopic(topic);
                }
            }
            return new ResultVO(200,null,"插入问题成功");
        }
        if(TitleFilter.get("flag").toString().equals("true")                    //标题包含敏感词汇
                &&contentFilter.get("flag").toString().equals("false")){
            System.out.println("标题包含敏感词汇");
            return new ResultVO(200,TitleFilter,"标题包含敏感词汇");
        }
        if(TitleFilter.get("flag").toString().equals("false")                   //内容包含敏感词汇
                &&contentFilter.get("flag").toString().equals("true")){
            System.out.println("内容包含敏感词汇");
            return new ResultVO(200,contentFilter,"标题包含敏感词汇");
        }
        if(TitleFilter.get("flag").toString().equals("true")                    //标题和内容均含敏感词汇
                &&contentFilter.get("flag").toString().equals("true")){
            System.out.println("内容和标题都包含敏感词汇");
            List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
            list.add(TitleFilter);
            list.add(contentFilter);
            return new ResultVO(200,list,"标题和内容均包含敏感词汇");
        }
        return new ResultVO(200,null,"不会执行这条");
    }

    /**
     * 获取最热的问题
     * @param name
     * @return
     */
    @Override
    public ResultVO getHotQues(String name) {
        List<Map<String,Object>> quesList=new ArrayList<Map<String, Object>>();
        if(name.equals("全站")){
            quesList=quesMapper.getAllQues();
        }else{
            quesList=quesMapper.getHotQues(name);
        }
        int number=0;
        for(Map<String,Object> ques : quesList) {
            /*热度计算*/
            double heat=0;
            Calendar c = Calendar.getInstance();
            Date nowTime = c.getTime();     //Date类型的系统当前时间
            //(浏览次数*0.02+总评论数*0.3)*1000/(公布时间距离当前时间的小时差+2)
            heat=(Integer.parseInt(String.valueOf(ques.get("browse_number")))*20
                    +Integer.parseInt(String.valueOf(ques.get("answer_number")))*300
                    +Integer.parseInt(String.valueOf(ques.get("attention_number")))*300
                    +Integer.parseInt(String.valueOf(ques.get("comment_number")))*200)
                    /(getDistanceTime2(nowTime,(Date)ques.get("create_time"))+2);
            ques.put("heat",
                    (int) heat);//获取热度
        }
        Collections.sort(quesList, new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer name1 = Integer.valueOf(o1.get("heat").toString()) ;//name1是从你list里面拿出来的一个
                Integer name2 = Integer.valueOf(o2.get("heat").toString()) ; //name1是从你list里面拿出来的第二个name
                return name2.compareTo(name1);
            }
        });
        for(Map<String,Object> ques : quesList){
            number++;
            ques.put("number",number);
        }
        return new ResultVO(200,quesList,"最热列表");
    }
    public static double getDistanceTime2(Date startTime, Date endTime) {
        double hour = 0;
        long time1 = startTime.getTime();
        long time2 = endTime.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        hour = (diff / (60 * 60 * 1000));
        return hour;
    }//计算两个时间小视察

}
