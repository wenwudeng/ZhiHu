<template>
    <div class="invitation-dialog">
      <el-dialog title="邀请回答"
        width="50%"
        :visible.sync="show"
        :before-close="handleClose">
          <div class="dialog-context-header">
            <div class="h-line"></div>
            <div class="dialog-context-title">你可以邀请他们来回答这个问题</div>
          </div>

          <div class="dialog-context-main">
            <div class="context-main-item"
              v-for="(invitation,id) of invitationList"
              :key="id">
              <div class="context-h-line"/>
              <!-- 邀请的用户 -->
              <Invitation
                :invitation="invitation">
              </Invitation>
              <div class="context-h-line"/>
            </div>
          </div>

          <el-button class="closeButton" type="primary" @click="handleClose">关闭</el-button>
      </el-dialog>
    </div>
</template>

<script>
import Invitation from '../items/Invitation'
export default {
  props: ['show', 'invitationList', 'question_id', 'user_id'],
  components: {
    'Invitation': Invitation
  },
  data () {
    return {
    }
  },
  methods: {
    handleClose: function () {
      this.$emit('close')
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
  .h-line {
    background-color: #696969;
    width: 100%;
    height: 1px;
    float: left;
    margin-bottom: 5px;
  }
  .dialog-context-header {
    font-size: 14px;
  }
  .context-h-line {
    background-color: #d6d6d6;
    width: 100%;
    height: 1px;
    float: left;
    margin: 2px 0px 2px 0px;
  }
  .closeButton{
    margin: 10px 0px 0px 550px;
  }
</style>
