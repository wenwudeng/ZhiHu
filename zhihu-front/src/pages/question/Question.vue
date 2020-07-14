<template>
    <div>
      <myhead></myhead>
      <mymain
        :question="question"
        :commentNum="commentList.length"
        :attentionList="attentionList"
        :answerList="answerList"
        :user_id="user_id"
        :asker="asker"
        @showComments='openCommentDialog'
        @showAttentions='openAttentionDialog'
        @showInvitations='openInvitationDialog'
        @handleCollect='openCollectDialog'
        @regetAnswer='getAnswers'
        @regetAttention='getAttentions'
        @regetAsker="getAsker">
      </mymain>
      <myfoot></myfoot>
      <!-- 遮盖层 -->
      <boverlay id="black_overlay"></boverlay>
      <!-- 该问题评论的对话框 -->
      <comments
        :question_id="question_id"
        :user_id="user_id"
        :anonymous="anonymous"
        :commentList="commentList"
        :show="commentDialogVisible"
        @close='closeCommentDialog'
        @regetComment='getComments'></comments>
      <!-- 该问题的关注的对话框 -->
      <attentions
        :show="attentionDialogVisible"
        :attentionList="attentionList"
        @regetAsker="getAsker"
        @regetAttention="getAttentions"
        @close='closeAttentionDialog'></attentions>
      <!-- 邀请的对话框 -->
      <invitations
        :show="invitationDialogVisible"
        :question_id="question_id"
        :user_id="user_id"
        @close="closeInvitationDialog"></invitations>
      <!--收藏的对话框-->
     <collect :show="collectDialogVisible"
         :favList="favList"
         :quesId="question_id"
         @close="closeCollectDialog"
        @openCreateCollectDialog="openCreateCollectDialog"
        @updateFav="getFavoritesList()">
    </collect>
        <creatCollect :showC="creatCollectDialogVisibale"
         @closeC="closeCreateCollectDialog"
         @updateFav="getFavoritesList()"
        >
         </creatCollect>
    </div>
</template>

<script>
import creatCollect from '../zwm/createCollectDialog'
import collect from '../zwm/collectionDialog'
import myhead from './head/head'
import mymain from './main/main'
import myfoot from './foot/foot'
// 导入遮盖层
import boverlay from './tools/black_overlay'
// 导入对话框
import comments from './dialogs/CommentDialog'
import attetions from './dialogs/AttentionDialog'
import invitations from './dialogs/InvitationDialog'

import { getAttentionWithOtherUser, getFansCount, getUserByFocusId } from '../../api/attention.js'
import { getComment } from '../../api/comment.js'
import { getQuestion } from '../../api/question.js'
import { getAnswer } from '../../api/answer.js'
import { getUserFavorites } from '../../api/attent.js'

export default {
  data () {
    return {
      question: '',
      asker: '',
      attentionDialogVisible: false,
      commentDialogVisible: false,
      answerList: '',
      commentList: '',
      attentionList: '',
      collectDialogVisible: false,
      creatCollectDialogVisibale: false,
      favList: [],
      // 问题id
      question_id: sessionStorage.getItem('ques_id'),
      // 用户id
      user_id: sessionStorage.getItem('userId'),
      // 是否匿名操作
      anonymous: false,
      invitationDialogVisible: false
    }
  },
  components: {
    'myhead': myhead,
    'mymain': mymain,
    'myfoot': myfoot,
    'boverlay': boverlay,
    'comments': comments,
    'attentions': attetions,
    'invitations': invitations,
    'collect': collect,
    'creatCollect': creatCollect
  },
  methods: {
    // 获取问题信息
    getThisQuestion: function () {
      let params = 'id=' + this.question_id
      getQuestion(params).then(res => {
        if (res.resultCode === 200) {
          this.question = res.data
          this.getAsker()// 获取该问题的提问者
        }
      })
    },

    // 获取问题的回答
    getAnswers: function () {
      let params = {
        userId: sessionStorage.getItem('userId'),
        quesId: sessionStorage.getItem('ques_id')
      }
      getAnswer(params).then(res => {
        if (res.resultCode === 200) { this.answerList = res.data }
      })
    },
    // 获取问题的提问者
    getAsker: function () {
      let params = 'userId=' + sessionStorage.getItem('userId') + '&otherUserId=' + this.question.user_id
      getAttentionWithOtherUser(params).then(res => {
        if (res.resultCode === 200) {
          this.asker = res.data
          this.getFansNum()
        }
      })
    },
    // 获取提问者的粉丝
    getFansNum: function () {
      let params = 'id=' + this.asker.user_id
      getFansCount(params).then(res => {
        if (res.resultCode === 200) {
          this.asker.follower_number = res.data
        }
      })
    },
    // 获取问题的评论
    getComments: function () {
      let params = 'id=' + this.question_id
      getComment(params).then(res => {
        if (res.resultCode === 200) { this.commentList = res.data.commentsList }
      })
    },
    // 获取关注该问题的人
    getAttentions: function () {
      let params = 'userId=' + sessionStorage.getItem('userId') + '&focusId=' +
       sessionStorage.getItem('ques_id') + '&type=' + 3
      getUserByFocusId(params).then(res => {
        if (res.resultCode === 200) {
          this.attentionList = res.data
        }
      })
    },
    openCommentDialog: function () {
      this.commentDialogVisible = true
    },
    closeCommentDialog: function (num) {
      this.commentDialogVisible = false
      this.commentNum = num
    },
    openAttentionDialog: function () {
      this.attentionDialogVisible = true
    },
    closeAttentionDialog: function () {
      this.attentionDialogVisible = false
    },
    openInvitationDialog: function () {
      this.invitationDialogVisible = true
    },
    closeInvitationDialog: function () {
      this.invitationDialogVisible = false
    },
    openCollectDialog: function () {
      this.collectDialogVisible = true
    },
    closeCollectDialog: function () {
      this.collectDialogVisible = false
    },
    openCreateCollectDialog: function () {
      this.creatCollectDialogVisibale = true
    },
    closeCreateCollectDialog: function () {
      this.creatCollectDialogVisibale = false
    },
    getFavoritesList: function () {
      let params = 'id=' + sessionStorage.getItem('userId')
      getUserFavorites(params).then(res => {
        if (res.resultCode === 200) {
          this.favList = res.data
        }
      })
    }
  },
  created () {
    this.getThisQuestion()// 获取问题
    this.getAnswers()// 获取该问题的回答
    this.getComments()// 获取该问题的评论
    this.getAttentions()// 获取关注该问题的人
    this.getFavoritesList()// 获取收藏夹
  }
}
</script>

<style scoped>

</style>
