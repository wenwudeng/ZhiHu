<template>
  <div class="question-main-right">
    <div class="main-right-header">
        <div class="header-title">提问者</div>
        <div class="asker-info">
          <span v-if="question.anonymity == 0">
            <el-avatar class="asker_img" shape="square" fit="cover" :src="asker.portrait"/>
          </span>
          <span v-if="question.anonymity == 1">
            <el-avatar class="asker_img" shape="square" fit="cover" :src="url2"/>
          </span>
          <div class="asker-info-main">
            <div class="asker_username"><b>
              <span v-show="question.anonymity == 0">{{asker.name}}</span>
              <span v-show="question.anonymity == 1">匿名用户</span>
            </b></div>
            <!--<div class="asker_agreeNum">TA已经获得&nbsp;{{asker.praise_number}}&nbsp;个赞</div>-->
            <div class="asker_followerNum">已经有&nbsp;{{asker.follower_number}}&nbsp;人关注了TA</div>
          </div>
        </div>
        <div class="user_opeartion">
          <!-- 如果不是匿名提问 -->
          <span v-show="question.anonymity == 0">
              <el-button @click="handleAttention" style="background-color: #0077e6; color: white;">
                <span v-show="asker.attent == 0">关注TA</span>
                <span v-show="asker.attent == 1">取消关注</span>
              </el-button>
          </span>
        </div>
    </div>
    <div class="main-right-main">
      <myExtra style="margin-top: 0px"></myExtra>
      <myFeature style="margin-top: 5px"></myFeature>
    </div>
    <div class="main-right-footer">
      <otherPart></otherPart>
    </div>
  </div>
</template>
<script>
import otherPart from '../../../test2/components/right/aboutZhihu/other_fence'
import myExtra from '../../../test2/components/right/extra/extra_fence'
import myFeature from '../../../test2/components/right/feature/feature_fence'
import { setAttentionUser, deleteAttentionUser } from '../../../../api/attention.js'
export default {
  props: ['asker', 'question'],
  data () {
    return {
      url1: this.asker.portrait,
      url2: 'https://pic1.zhimg.com/da8e974dc_xs.jpg'
    }
  },
  components: {
    'otherPart': otherPart,
    'myExtra': myExtra,
    'myFeature': myFeature
  },
  methods: {
    handleAttention: function () {
      let params = {
        userId: sessionStorage.getItem('userId'),
        focusId: this.asker.user_id
      }
      // 要关注
      if (this.asker.attent === 0) {
        setAttentionUser(params).then(res => {
          if (res.resultCode === 200) {
            if (res.resultCode === 200) {
              this.$emit('regetAttention')
              this.$emit('regetAsker')
            }
          }
        })
      } else {
        // 否则就取消关注
        deleteAttentionUser(params).then(res => {
          if (res.resultCode === 200) {
            this.$emit('regetAttention')
            this.$emit('regetAsker')
          }
        })
      }
    }
  }
}
</script>
<style scoped>
.question-main-right {
    width: 350px;
    height: 100%;
    float: left;
    margin: 3px 0px 10px 8px;
}
.main-right-header {
    background-color: #ffffff;
    width: 98%;
    float: left;
    margin: 5px 4px 5px 4px;
}
.main-right-main {
    width: 98%;
    float: left;
    margin: 0px 4px 5px 4px;
}
.main-right-footer {
    background-color: #ffffff;
    width: 92%;
    float: left;
    margin: 0px 4px 5px 4px;
    padding: 0px 10px 10px 10px;
}
.header-title {
    width: 98%;
    font-size: 16px;
    float: left;
    margin: 5px 5px 5px 5px;
    padding: 0px 0px 0px 10px;
}
.asker-info {
    margin: 2px 0px 5px 10px;
    float: left;
}
.asker_img {
    width: 80px;
    height: 80px;
    margin: 5px 0px 5px 10px;
    float: left;
}
.asker-info-main {
    margin: 5px 10px 5px 0px;
}
.asker_username {
    font-size: 35px;
    float: left;
    margin: 0px 0px 0px 40px;
}
.asker_agreeNum, .asker_followerNum{
    float: left;
    color: #636363;
    font-size: 8px;
    margin: 4px 0px 0px 35px;
}
.user_opeartion {
    float: left;
    margin: 8px 0px 10px 15px;
}
</style>
