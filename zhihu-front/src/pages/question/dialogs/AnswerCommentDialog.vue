<template>
    <div class="comment-dialog">
      <el-dialog title="查看评论"
        width="50%" center
        :visible.sync="show"
        :before-close="handleClose">
        <div>
          <div class="dialog-context-header">
            <div class="dialog-context-title">该回答有{{commentList.length}}条评论</div>
          </div>

          <div class="dialog-context-main">
            <div class="context-main-item"
              v-for="(comment,id) of commentList"
              :key="id">
              <div class="context-h-line"/>
              <!-- 评论 -->
              <Comment
                :comment="comment">
              </Comment>
            </div>
          </div>

          <div class="dialog-context-footer">
            <el-input type="textarea"  autosize
              v-model="input" class="commentInput" placeholder="我的评论"/>
            <el-button type="primary" @click="handleSend" class="commentButton">发布</el-button>
          </div>
        </div>
      </el-dialog>
    </div>
</template>

<script>
import { saveComment } from '../../../api/comment.js'
import Comment from '../items/Comment'
export default {
  props: ['show', 'commentList', 'answer_id', 'user_id', 'anonymous'],
  components: {
    'Comment': Comment
  },
  data () {
    return {
      input: ''
    }
  },
  methods: {
    handleClose: function () {
      this.$emit('close', this.commentList.length)
    },
    handleSend: function () {
      let params = {
        commentObjectId: this.answer_id, // 回答id
        objectType: '2', // 类型为2--是对回答进行评论
        userId: sessionStorage.getItem('userId'), // 用户id
        commentContent: this.input// 输入的值
      }
      console.log(params)
      saveComment(params).then(res => {
        if (res.resultCode === 200) {
          this.input = ''
          this.$emit('regetComment')// 让父组件更新评论列表
        }
      })
    }
  }
}
</script>

<style scoped>
  .dialog-context-header {
    margin: -30px 0px 5px 0px;
    background-color: #ffffff;
    width: 100%;
    float: left;
  }
  .dialog-context-title{
    font-size: 14px;
  }
  .dialog-context-header {
    font-size: 14px;
  }
  .context-h-line {
    background-color: #d6d6d6;
    width: 94%;
    height: 1px;
    float: left;
    margin: 2px 0px 2px 20px;
  }
  .commentInput {
    width: 80%;
    margin: 5px 10px 0px 20px;
  }
  .commentButton {
    margin-top: 5px;
    background-color: #0077e6;
    color: white;
  }
</style>
