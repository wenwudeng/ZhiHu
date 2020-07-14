<template>
  <div class="main">
    <qheader
      :question="question"
      :doEditor="doEditor"
      :anonymous="anonymous"
      :commentNum="commentNum"
      :attentionList="attentionList"
      @showComments="showComments"
      @showAttentions='showAttentions'
      @showInvitations="showInvitations"
      @handleDoEditor="handleDoEditor"
      @handleCollect="handleCollect"
      @regetAttention="regetAttention"
      @handleAnonymous="handleAnonymous">
    </qheader>
    <qmain
      :doEditor="doEditor"
      :anonymous="anonymous"
      :answerList="answerList"
      :user_id="user_id"
      :question="question"
      :asker="asker"
      @regetAnswer="regetAnswer"
      @regetAttention="regetAttention"
      @regetAsker="regetAsker"
    ></qmain>
  </div>
</template>
<script>
import questionheader from './questionheader/QuestionHeader'
import questionmain from './questionmain/QuestionMain'
export default {
  data () {
    return {
      anonymous: false,
      doEditor: false
    }
  },
  props: ['answerList', 'user_id', 'question', 'asker', 'commentNum', 'attentionList'],
  components: {
    'qheader': questionheader,
    'qmain': questionmain
  },
  methods: {
    showComments: function () {
      this.$emit('showComments')
    },
    showAttentions: function () {
      this.$emit('showAttentions')
    },
    showInvitations: function () {
      this.$emit('showInvitations')
    },
    handleDoEditor: function () {
      this.doEditor = !this.doEditor
    },
    handleAnonymous: function () {
      this.anonymous = !this.anonymous
    },
    regetAnswer: function () {
      this.$emit('regetAnswer')
    },
    regetAttention: function () {
      this.$emit('regetAttention')
    },
    regetAsker: function () {
      this.$emit('regetAsker')
    },
    handleCollect: function () {
      this.$emit('handleCollect')
    }
  }
}
</script>
<style scoped>
    .main{
      background-color: #f1efef;
      width: 100%;
      float: left;
    }
</style>
