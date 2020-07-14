<template>
  <div class="context-item">
    <div class="user-info">
      <!-- 显示用户头像 -->
      <el-avatar class="user_img" shape="square" fit="cover" :src="comment_user.portrait"></el-avatar>
      <!-- 显示用户名 -->
      <div class="user_username">
        <span>{{comment_user.name}}</span>
      </div>

      <!--评论的时间-->
      <div class="comment_time">
        <span>评论时间：{{date}}&nbsp;&nbsp;{{time}}</span>
      </div>
    </div>

    <!-- 评论的正文部分 -->
    <div class="context-item-main">
      <span>{{comment.commentContent}}</span>
    </div>
  </div>
</template>
<script>
import { getAttentionWithOtherUser } from '../../../api/attention.js'
export default {
  props: ['comment'],
  data () {
    return {
      comment_user: '',
      isAgree: false,
      isAgainst: false
    }
  },
  methods: {
    agree: function () {
      this.isAgree = !this.isAgree
    },
    against: function () {
      this.isAgainst = !this.isAgainst
    },
    // 获取评论者，以及当前用户对其的关注情况
    getCommentUser: function () {
      let params = 'userId=' + sessionStorage.getItem('userId') + '&otherUserId=' + this.comment.userId
      getAttentionWithOtherUser(params).then(res => {
        if (res.resultCode === 200) {
          this.comment_user = res.data
          console.log(this.comment_user)
        }
      })
    }
  },
  created () {
    this.getCommentUser()
  },
  computed: {
    date: function () {
      var t = '' + this.comment.createTime
      return t.substring(0, 10)
    },
    time: function () {
      var t = '' + this.comment.createTime
      return t.substring(11, 19)
    }
  }
}
</script>
<style scoped>
  .context-item {
    background-color: #ffffff;
    width: 95%;
    float: left;
    margin: 2px 10px 2px 10px;
    padding: 5px 10px 5px 10px
  }
  .user-info{
    background: #ffffff;
    width: 98%;
    float: left;
    padding: 3px 3px 3px 3px;
  }
  .user_img{
    width: 45px;
    height: 45px;
    float: left;
  }
  .user_username {
    font-size: 20px;
    float: left;
    margin: 8px 0px 0px 10px;
  }
  .comment_time {
    float:right;
    font-size: 5px;
  }
  .context-item-main {
    background-color: #ffffff;
    float: left;
    width: 96%;
    margin: 5px 0px 2px 2px;
    padding: 8px 8px 8px 8px;
    word-break: break-all;
  }
  .v-line {
      background-color: #6e6e6e;
      width: 1px;
      height: 10px;
      float: left;
      margin: 8px 5px 0px 5px;
  }
  .el-button--default
  {
    font-size: 13px;
    border: 1px solid #DDDDDD;
    background:#0077e6;
    color:white;
    height: 35px;
    width: 70px;
    border-radius:5px;
  }
  .el-button--default:hover
  {
    background:#0084ff;
    color: white;
  }
  .el-button--default:focus
  {
    background:#0084ff;
    color: white;
  }
</style>
