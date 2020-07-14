<template>
  <div class="question-main-left">
    <div class="user-answer">
      <quilleditor
        :doEditor="doEditor"
        :anonymous="anonymous"
        :user_id="user_id"
        :question_id="question.ques_id"
        @regetAnswer="regetAnswer">
      </quilleditor>
    </div>
    <div class="answer-list">
      <div class="answer-list-num">
        <b>{{answerList.length}}个回答</b>
      </div>
      <div class="answer-list-item"
        v-for="(item,id) of answerList"
        :key="id">
        <answer
          :answer="item"
          @regetAnswer="regetAnswer"></answer>
        <div class="h-line"/>
      </div>
    </div>
  </div>
</template>
<script>
import quilleditor from '../../tools/AnswerQuillEditor'
import answer from '../../items/Answer'
export default {
  props: ['doEditor', 'anonymous', 'answerList', 'user_id', 'question'],
  data () {
    return {
    }
  },
  methods: {
    regetAnswer: function () {
      this.$emit('regetAnswer')
    }
  },
  components: {
    'quilleditor': quilleditor,
    'answer': answer
  }
}
</script>

<style scoped>
  .question-main-left {
    width: 650px;
    background-color: #ffffff;
    float: left;
    margin: 8px 0px 0px 180px;
  }
  .answer-list{
    background-color: #ffffff;
    width: 98%;
    float: left;
    margin: 5px 0px 5px 5px;
  }
  .answer-list-num{
    float: left;
    font-size: 16px;
    margin: 10px 0px 10px 10px;
  }
  .answer-list-item{
    background-color: #ffffff;
    width: 98%;
    float: left;
    margin: 2px 5px 0px 5px;
  }
  .h-line {
    background-color: #b4afaf;
    height: 1px;
    width: 100%;
    float: left;
  }
</style>
