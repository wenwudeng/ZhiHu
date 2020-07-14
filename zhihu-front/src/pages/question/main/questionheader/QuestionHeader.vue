<template>
  <div class="question-header">
    <!-- 问题首部的主题：问题的类型与具体的问题 -->
    <div class="question-header-main">
      <hleft
      :question="question"
      ></hleft>
    </div>

    <!-- 该问题的关注者与访问数 -->
    <div class="question-header-right">
      <hright
        :question="question"
        :attentionNum="this.attentionList.length"
        @showAttentions='showAttentions'></hright>
    </div>

    <!-- 问题首部底下的操作：关注、回答等 -->
    <div class="question-header-foot">
      <hfoot
      :question="question"
      :attention="attention"
      :doEditor="doEditor"
      :commentNum="commentNum"
      :anonymous="anonymous"
      @handleAnonymous="handleAnonymous"
      @showComments='showComments'
      @handleAttention="handleAttention"
      @showInvitations="showInvitations"
      @handleDoEditor="handleDoEditor"
      @handleCollect="handleCollect"
      ></hfoot>
    </div>
  </div>
</template>
<script>
import hleft from './QuestionHeaderLeft'
import hright from './QuestionHeaderRight'
import hfoot from './QuestionHeaderFoot'
import { doAttentionQues, unAttentionQues, isAttention } from '../../../../api/attention.js'
export default {
  props: ['commentNum', 'doEditor', 'anonymous', 'question', 'attentionList'],
  data () {
    return {
      attention: ''
    }
  },
  methods: {
    showComments: function () {
      this.$emit('showComments')
    },
    showAttentions: function () {
      this.$emit('showAttentions')
    },
    handleAttention: function () {
      this.attention = !this.attention

      let params = {
        userId: sessionStorage.getItem('userId') + '',
        focusId: this.question.ques_id + '',
        focusType: 3
      }

      // 如果是关注了问题
      if (this.attention) {
        doAttentionQues(params).then(res => {
          if (res.resultCode === 200) { this.$emit('regetAttention') }
        })
      } else { // 取消关注
        unAttentionQues(params).then(res => {
          if (res.resultCode === 200) { this.$emit('regetAttention') }
        })
      }
    },
    showInvitations: function () {
      this.$emit('showInvitations')
    },
    handleDoEditor: function () {
      this.$emit('handleDoEditor')
    },
    handleAnonymous: function () {
      this.$emit('handleAnonymous')
    },
    handleCollect: function () {
      this.$emit('handleCollect')
    },
    // 判断用户是否关注过这个问题
    isAttented: function () {
      let params = 'userId=' + sessionStorage.getItem('userId') + '&focusId=' +
      sessionStorage.getItem('ques_id') + '&type=' + 3

      isAttention(params).then(res => {
        if (res.resultCode === 200) {
          if (res.data === 1) { this.attention = true } else this.attention = false
        }
      })
    }
  },
  created () {
    this.isAttented()
  },
  components: {
    'hleft': hleft,
    'hright': hright,
    'hfoot': hfoot
  }
}
</script>

<style scoped>
    .question-header {
      background-color: #ffffff;
      width: 100%;
      float: left;
      margin: 5px 0px 2px 0px;
      padding: 5px 0px 5px 0px;
    }
    .question-header-main,.question-header-foot  {
      background-color: #ffffff;
      width: 650px;
      float: left;
      margin: 0px 5px 0px 180px;
      padding: 5px;
    }
    .question-header-right {
      background-color: #ffffff;
      width: 300px;
      float: left;
      margin: 10px 0px 10px 0px;
    }
</style>
