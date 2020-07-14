<template>
    <div class="answer">

      <div class="answer-header">
        <div class="answer-header-user">
          <span v-if="answerInfo.anonymity==0">
            <el-avatar class="user_img" shape="square" fit="cover" :src="answer.portrait"></el-avatar>
            <div class="user_username">{{answerInfo.aname}}</div>
          </span>
          <!-- 匿名用户 -->
          <span v-if="answerInfo.anonymity==1">
            <el-avatar class="user_img" shape="square" :src="anonymous_image_url"></el-avatar>
            <div class="user_username">{{anonymous_username}}</div>
          </span>
        </div>
        <!--赞和踩的次数-->
        <div class="Counts">
          <span class="agreeCount">支持：{{answerInfo.endorse_number}}</span>
          <span class="againstCount">反对：{{answerInfo.opposeCount}}</span>
        </div>
      </div>
      <div class="answer_time">
        数据更新于：{{date}}&nbsp;&nbsp;{{time}}
      </div>
      <div class="answer-context">
        <div class="answer-context-item">
          <div v-html="answerInfo.answer_content"></div>
        </div>
      </div>
      <div class="answer-footer">
        <div class="agree_against">
          <!-- 点赞按钮 -->
          <el-button class="agreeButton" size="small"
            v-show="answerInfo.manner === -1||answerInfo.manner === 2"
            @click="handleAgree" icon="el-icon-caret-top">点赞</el-button>
          <el-button class="agreeButton" size="small" v-show="answerInfo.manner==1"
            @click="handleAgree">取消点赞</el-button>

          <!-- 反对按钮 -->
          <el-button class="againstButton" size="small"
            v-show="answerInfo.manner === -1||answerInfo.manner === 2"
            @click="handleAgainst" icon="el-icon-caret-bottom">反对</el-button>
          <el-button class="againstButton" size="small" v-show="answerInfo.manner==0"
            @click="handleAgainst">取消反对</el-button>

          <!-- 评论按钮 -->
          <el-button class="commentButton" @click="getComment" size="small">查看评论</el-button>
        </div>
      </div>
      <!-- 回答的评论的对话框 -->
      <cDialog
        :answer_id="answer_id"
        :user_id="user_id"
        :commentList="commentList"
        :show="commentDialogVisible"
        @close='closeCommentDialog'
        @regetComment='getComment'
      ></cDialog>
    </div>
</template>

<script>
import cDialog from '../dialogs/AnswerCommentDialog'
import { getAnswerComment } from '../../../api/comment.js'
import { setAttitude, updataAttitude } from '../../../api/attitude.js'
export default {
  props: ['answer'],
  components: {
    'cDialog': cDialog
  },
  data () {
    return {
      add: 0,
      sub: 0,
      answerInfo: this.answer,
      commentDialogVisible: false,
      commentList: [],
      user_id: sessionStorage.getItem('userId'),
      answer_id: this.answer.answer_id,
      state: 0,
      anonymous_image_url: 'https://pic1.zhimg.com/da8e974dc_xs.jpg',
      anonymous_username: '匿名用户'
    }
  },
  computed: {
    date: function () {
      var t = '' + this.answerInfo.create_time
      return t.substring(0, 10)
    },
    time: function () {
      var t = '' + this.answerInfo.create_time
      return t.substring(11, 19)
    }
  },
  methods: {
    handleAgree: function () {
      var opp
      // 如果已经点赞就取消点赞
      if (this.answerInfo.manner === 1) {
        opp = 2
        this.answerInfo.endorse_number--
      } else { // 那就是要点赞
        opp = 1
        this.answerInfo.endorse_number++
      }

      // 更新数据库表
      this.handleChange(opp)

    },
    handleAgainst: function () {
      var opp
      // 如果已经反对就取消反对
      if (this.answerInfo.manner === 0) {
        opp = 2
        this.answerInfo.opposeCount--
      } else { // 那就是要反对
        opp = 0
        this.answerInfo.opposeCount++
      }
      // 更新数据库表
      this.handleChange(opp)
    },
    handleChange: function (opp) {
      let params = {
        userId: sessionStorage.getItem('userId'),
        answerId: this.answerInfo.answer_id,
        agrOpp: opp
      }
      // 如果之前没有点赞过——初次建立态度
      if (this.answer.manner === -1) {
        setAttitude(params).then(res => {
          if (res.resultCode === 200) {
            this.answerInfo.manner = opp }
        })
      } else { // 否则就是更新态度
        updataAttitude(params).then(res => {
          if (res.resultCode === 200) { this.answerInfo.manner = opp }
        })
      }
      // this.answerInfo.manner = opp
    },
    getComment: function () {
      let params = 'id=' + this.answer.answer_id
      getAnswerComment(params).then(res => {
        if (res.resultCode === 200) {
          this.commentList = res.data
          this.commentDialogVisible = true
        }
      })
    },
    closeCommentDialog: function (num) {
      this.commentDialogVisible = false
    }
  }
}
</script>

<style scoped>
div ,span,p{
  word-break: break-all;
}
 .answer-header {
    background-color:#ffffff;
    width: 98%;
    float: left;
    margin: 5px 0px 5px 5px;
 }
 .answer-header-user {
    float: left;
 }
 .user_img {
    float: left;
    width: 40px;
    height: 40px;
    margin: 2px 0px 2px 5px;
 }
 .user_username {
   font-size: 16px;
    float: left;
    margin: 10px 0px 2px 15px;
 }
 .Counts {
   float: right;
   margin: 10px 20px 2px 0px;
 }
 .agreeCount,.againstCount {
   color: #919191;
   font-size: 10px;
   margin:0px 10px 0px 10px;
 }
 .answer_time {
   color: #858484;
   font-size: 15px;
   margin: 2px 0px 2px 10px
 }
 .answer-context {
     background-color: #ffffff;
     width: 93%;
     float: left;
     margin-left: 5px;
     padding: 15px;
 }
 .answer-context-item{
   width:96%;
   word-break: break-all;
 }
 .answer-footer {
   background-color: #ffffff;
   float: left;
   width:98%;
   margin: 5px 0px 5px 5px;
 }
 .agreeButton , .againstButton{
  background-color: #0077e6;
  color: #ffffff;
  float: left;
  margin: 5px 0px 5px 10px;
 }
  .collectButton,.commentButton{
  float: left;
  margin: 5px 0px 5px 10px;
  }
</style>
