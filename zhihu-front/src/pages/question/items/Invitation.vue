<template>
  <div class="context-item">
    <div class="user-info">
      <!-- 显示用户头像 -->
      <el-avatar class="user_img" shape="square" fit="cover" src="#"></el-avatar>
      <!-- 显示用户名 -->
      <div class="user_username">
        <span>{{invitation.name}}</span>
      </div>
    </div>
    <!-- 用户操作部分 -->
    <div class="user_opt">
      <el-button class="invitationButton" type="primary" size="mini" @click="invitation()">邀请</el-button>
    </div>
  </div>
</template>
<script>
export default {
  props: ['invitation'],
  data () {
    return {
    }
  },
  methods: {
    // eslint-disable-next-line vue/no-dupe-keys
    invitation: function () {
      alert('邀请' + this.invitation.uid)
    }
  },
  computed: {
  }
}
</script>
<style scoped>
  .context-item {
    background-color: #e6f5f7;
    width: 95%;
    float: left;
    margin: 2px 10px 2px 10px;
    padding: 5px 10px 5px 10px
  }
  .user-info{
    background: #f3f9fa;
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

  .user_opt {
      background-color: #f3f9fa;
      float: left;
      width: 97%;
      margin: 5px 0px 2px 2px;
      padding: 5px 5px 5px 5px;
  }
  .invitationButton {
      float: left;
      margin: 2px 5px 0px 5px;
  }
  .v-line {
      background-color: #6e6e6e;
      width: 1px;
      height: 10px;
      float: left;
      margin: 8px 5px 0px 5px;
  }
</style>
