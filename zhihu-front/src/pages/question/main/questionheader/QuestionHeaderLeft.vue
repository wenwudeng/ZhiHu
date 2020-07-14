<template>
    <div>
      <!-- 问题所属的类别  -->
      <div class="question-topic-group">
        <el-button-group>
          <div class="question-topic"
            v-for="(item, id) of topic"
            :key='id'>
            <el-button round size="small">{{item.topic_name}}</el-button>
          </div>
        </el-button-group>
      </div>
      <!-- 具体的问题 -->
      <div class="question-main">
        <div class="question-main-title"><b>{{question.ques_name}}</b></div>
        <div class="question-main-context" v-html="question.ques_describe"></div>
      </div>
    </div>
</template>

<script>
import { getTopic } from '../../../../api/question.js'
export default {
  props: ['question'],
  data () {
    return {
      topic: this.getTopics()
    }
  },
  methods: {
    getTopics: function () {
      let params = 'id=' + sessionStorage.getItem('ques_id')
      getTopic(params).then(res => {
        if (res.resultCode === 200) { this.topic = res.data }
      })
    }
  }
}
</script>
<style scoped>
    .question-topic-group {
      float: left;
      width: 650px;
      margin: 5px 10px 0px 0px;
    }
    .question-topic {
      float: left;
      margin: 5px 0px 0px 10px;
    }
    .question-main {
      float: left;
      width: 650px;
      margin: 5px 0px 0px 20px;
    }
    .question-main-title {
      font-size: 28px;
      margin-bottom: 10px;
    }
    .question-main-context {
      font-size: 16px;
      margin-bottom: 10px;
    }
  .answerNum{
    font-size: 10px;
    color: #807e7e;
    float: left;
    margin: 20px 15px 5px 0px;
  }
</style>
