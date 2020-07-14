<template>
  <div class="question-main">
    <div>
      <qmianLeft
        :question="question"
        :doEditor="doEditor"
        :anonymous="anonymous"
        :answerList="answerList"
        :user_id="user_id"
        @regetAnswer="regetAnswer">
      </qmianLeft>
      <qmainRight
        :asker="asker"
        :question="question"
        @regetAttention="regetAttention"
        @regetAsker="regetAsker"></qmainRight>
    </div>
  </div>
</template>
<script>
import qmainLeft from './QuestionMainLeft'
import qmainRight from './QuestionMainRight'
export default {
  props: ['doEditor', 'anonymous', 'answerList', 'user_id', 'question', 'asker'],
  methods: {
    regetAnswer: function () {
      this.$emit('regetAnswer')
    },
    regetAttention: function () {
      this.$emit('regetAttention')
    },
    regetAsker: function () {
      this.$emit('regetAsker')
    }
  },
  components: {
    'qmianLeft': qmainLeft,
    'qmainRight': qmainRight
  }
}
</script>

<style scoped>
  .question-main {
    width: 100%;
    background-color: #f1efef;
    float: left;
  }
</style>
