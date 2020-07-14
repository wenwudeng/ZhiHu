<template>
    <div class="attention-dialog">
      <el-dialog title="查看问题关注情况"
        width="50%"
        :visible.sync="show"
        :before-close="handleClose">
          <div class="dialog-context-header">
            <div class="h-line"></div>
            <div class="dialog-context-title">有{{attentionList.length}}人关注了这个问题</div>
          </div>

          <div class="dialog-context-main">
            <div class="context-main-item"
              v-for="(attention,id) of attentionList"
              :key="id">
              <div class="context-h-line"/>
              <div class="context-item">
                <Attention
                  :attention="attention"
                  @regetAsker="regetAsker"
                  @regetAttention="regetAttention"
                ></Attention>
              </div>
              <div class="context-h-line"/>
            </div>
          </div>

          <div class="dialog-context-footer">
            <el-button type="primary" @click="handleClose" class="closeButton">关闭</el-button>
          </div>
      </el-dialog>
    </div>
</template>

<script>
import Attention from '../items/Attention'
export default {
  props: ['show', 'attentionList'],
  components: {
    'Attention': Attention
  },
  data () {
    return {

    }
  },
  methods: {
    handleClose: function () {
      this.$emit('close')
    },
    regetAsker: function () {
      this.$emit('regetAsker')
    },
    regetAttention: function () {
      this.$emit('regetAttention')
    }
  }
}
</script>

<style scoped>
  .dialog-context {
    margin: -30px 0px 5px 0px;
    background-color: #ffffff;
    width: 100%;
  }
  .h-line {
    background-color: #969696;
    width: 90%;
    height: 1px;
    float: left;
    margin: 0px 30px 10px 30px;
  }
  .dialog-context-header {
    font-size: 14px;
  }
  .dialog-context-title {
    margin: 0px 0px 5px 30px;
  }
  .context-h-line {
    background-color: #ebe9e9;
    width: 90%;
    height: 1px;
    float: left;
    margin: 2px 0px 2px 30px;
  }
  .context-item {
    background-color: #ffffff;
    width: 95%;
    float: left;
    margin: 2px 10px 2px 10px;
    padding: 2px 5px 2px 5px
  }
  .closeButton {
    margin: 5px 15px 0px 530px;
    background-color: #0077e6;
    color: white;
  }
</style>
