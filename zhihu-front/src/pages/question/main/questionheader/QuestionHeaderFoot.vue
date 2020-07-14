<template>
  <div>

    <div class="foot-group">
      <div class="foot-operation">
        <!-- 页面切换操作 -->
        <el-button @click="handleAttention" class="priamryButton">
          <span v-show="!attention">关注问题</span>
          <span v-show="attention">取消关注</span>
        </el-button>
        <el-button @click="handleCollect">
          <span>收藏问题</span>
        </el-button>
        <el-button icon="el-icon-edit" @click="handleDoEditor">
          <span v-if="!doEditor">回答</span>
          <span v-if="doEditor">收起</span>
        </el-button>
        <!--<el-button icon="el-icon-edit-outline" size="small" @click="showInvitations">邀请回答</el-button>-->
        <el-button @click="showComments">{{commentNum}}条评论</el-button>
        <el-button @click="handleAnonymous">
          <span v-if="!anonymous">开启匿名</span>
          <span v-if="anonymous">关闭匿名</span>
        </el-button>
      </div>
    </div>

  </div>
</template>
<script>
export default {
  props: ['attention', 'doEditor', 'anonymous', 'question', 'commentNum'],
  data () {
    return {
      collect: false
    }
  },
  methods: {
    showComments: function () {
      this.$emit('showComments')
    },
    handleAnonymous: function () {
      this.$emit('handleAnonymous')
    },
    handleAttention: function () {
      this.$emit('handleAttention')
    },
    showInvitations: function () {
      this.$emit('showInvitations')
    },
    handleDoEditor: function () {
      this.$emit('handleDoEditor')
    },
    handleCollect: function () {
      this.$emit('handleCollect')
    }
  }
}
</script>
<style scoped>
  .foot-operation{
    margin: 5px 0px 5px 10px;
    float: left;
  }
  .priamryButton{
    background-color: #0077e6;
    color: white;
  }
</style>
