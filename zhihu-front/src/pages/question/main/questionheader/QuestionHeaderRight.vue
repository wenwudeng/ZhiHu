<template>
    <div class="att_and_vst">
    <!-- 关注 -->
      <div class="attention" title="点击查看关注该问题的人">
        <div @click="showAttentions">
          <div class="attention-text">关注者</div>
          <div class="attention-num"><b>{{attentionNum}}</b></div>
        </div>
      </div>
      <!-- 垂直分界线 -->
      <div class="v-line"/>
      <!-- 访问 -->
      <div class="visit">
          <div class="visit-text">访问数</div>
          <div class="visit-num"><b>{{question.browse_number}}</b></div>
      </div>
    </div>
</template>

<script>
export default {
  props: ['attentionNum', 'question'],
  methods: {
    showAttentions: function () {
      this.$emit('showAttentions')
    }
  }
}
</script>

<style scoped>
  a {
    text-decoration: none;
  }
  .att_and_vst {
    width: 290px;
    height: 90px;
    margin: 5px 5px 5px 5px;
  }
  .attention {
    width: 140px;
    height: 100%;
    float: left;
  }
  .attention-text {
    margin-top: 18px;
    width: 100%;
    text-align: center;
    color: #3a3636;
    float: left;
  }
  .attention-num {
    font-size: 20px;
    width: 100%;
    text-align: center;
    color: #3a3636;
    float: left;
  }
  .v-line {
      background-color: #cecbcb;
      width: 1px;
      height: 70%;
      float: left;
      margin: 15px 4px 0px 4px;
  }
  .visit {
      width: 140px;
      height: 100%;
      float: left;
  }
  .visit-text {
    margin-top: 18px;
    width: 100%;
    color: #3a3636;
    text-align: center;
    float: left;
  }
  .visit-num {
    font-size: 20px;
    width: 100%;
    text-align: center;
    float: left;
  }
</style>
