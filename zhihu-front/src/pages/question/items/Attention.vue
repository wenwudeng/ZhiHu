<template>
  <div class="context-item">
    <div class="user-info">
      <!-- 显示用户头像 -->
      <el-avatar class="user_img" shape="square" fit="cover" :src="attention.portrait"/>
      <!-- 显示用户名 -->
      <div class="user_username">
        <span>{{attention.name}}</span>
      </div>
      <!-- 显示已经有多少人关注了TA -->
      <div class="fans_Num">
        <span>已经有&nbsp;{{attention.fans}}&nbsp;人关注了TA</span>
      </div>
      <!-- 用户操作部分 -->
      <el-button class="attentionButton" size="small" style="background-color: #0077e6;color: white" @click="handleAttention">
        <span v-show="attention.attent == 0">关注TA</span>
        <span v-show="attention.attent == 1">取消关注</span>
      </el-button>
    </div>

  </div>
</template>
<script>
import { setAttentionUser, deleteAttentionUser } from '../../../api/attention.js'
export default {
  props: ['attention'],
  data () {
    return {
      isAttention: false
    }
  },
  methods: {
    handleAttention: function () {
      let params = {
        userId: sessionStorage.getItem('userId'),
        focusId: this.attention.user_id
      }
      // 要关注
      if (this.attention.attent === 0) {
        setAttentionUser(params).then(res => {
          if (res.resultCode === 200) { this.reget() }
        })
      } else {
        // 否则就取消关注
        deleteAttentionUser(params).then(res => {
          if (res.resultCode === 200) { this.reget() }
        })
      }
    },
    reget: function () {
      this.$emit('regetAttention')
      this.$emit('regetAsker')
    }
  },
  computed: {
  }
}
</script>
<style scoped>
  .context-item {
    background-color: #ffffff;
    width: 95%;
    float: left;
    margin: 2px 2px 2px 2px;
    padding: 5px 5px 5px 5px
  }
  .user-info{
    background: #ffffff;
    width: 98%;
    float: left;
    padding: 3px 3px 3px 3px;
  }
  .user_img{
    width: 60px;
    height: 60px;
    float: left;
  }
  .user_username {
    font-size: 30px;
    float: left;
    margin: 8px 0px 0px 10px;
  }
  .fans_Num{
    float: right;
    font-size: 8px;
    margin: 0px 0px 0px 0px;
  }
  .user_opt {
      background-color: #ffffff;
      float: left;
      width: 97%;
      margin: 5px 0px 2px 2px;
      padding: 5px 5px 5px 5px;
  }
  .attentionButton {
      float: right;
      margin: 28px -120px 0px 5px;
  }
  .v-line {
      background-color: #6e6e6e;
      width: 1px;
      height: 10px;
      float: left;
      margin: 8px 5px 0px 5px;
  }
</style>
